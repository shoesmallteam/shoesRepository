(function(){
	var forgetusername;
		//点击获取验证码
		$('#ObtainBtn').click(function(){
			alert("Verification code sent");
			var f = $('#forgetusername').val();
			$.ajax({
				type:"post",
				url:"obtain.do",
				data:"f="+f,
				success:function(result){
					forgetusername = result;
				}
			});
		});
	  	$('#ResetBtn').click(function(){
	    //拿到输入的验证码和新密码
	    var forgetname = $('#forgetname').val();
	    var forgetpwd = $('#forgetpwd').val();
	    var f = $('#forgetusername').val();
	    //验证
	    var re3 = /^([a-z-A-Z\d]|[,.!@]){8,14}$/g;
  	 	if (!re3.test(forgetpwd)) {
  	 		$('#forgetModal .modal-body li:eq(5) .error').fadeIn(1000);
  	 		$('#forgetModal .modal-body li:eq(6) .error').fadeIn(1000);
  	 		return;
  	 	}
	    if(forgetname == '' || forgetpwd == '' || f == ''){
	      $('#forgetModal .modal-body li:eq(7) .error').fadeIn(1000);
		  return;
		};
	    if(forgetusername!=forgetname){
	    	$('#forgetModal .modal-body li:eq(3) .error').fadeIn(1000);
	      return;
	    }else{
	    	$.ajax({
				type:"post",
				url:"forgetpwd.do",
				data:"forgetpwd="+forgetpwd+"&f="+f,
				success:function(result){
					if (result) {
						$('#forgetModal .modal-body li:eq(1) .error').fadeIn(1000);
					}else{
						$('#forgetModal').fadeOut(100).modal('hide');
						$('#landModal').fadeIn(100).modal('show');
					}
				}
			});
	    };
  });
})();
