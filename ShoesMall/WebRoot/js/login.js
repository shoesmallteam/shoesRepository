(function(){
	  	$('#loginBtn').click(function(){
	    //拿到账号和密码
	    var un = $('#username').val();
	    var pw = $('#pwd').val();
	    //验证
	    if(un == '' || pw == ''){
	      $('#landModal .modal-body li:eq(4) .error').fadeIn(1000);
	      return;
	    };
	    //使用ajax无刷新
		$.ajax({
			type:"post",
			url:"login.do",
			data:"un="+un+"&pw="+pw,
			success:function(result){
				if(result==un){
					//账号不存在
					$('#landModal .modal-body li:eq(1) .error').fadeIn(1000);
				}else if(result==pw){
					//密码错误
					//console.log(pw);
					$('#landModal .modal-body li:eq(3) .error').fadeIn(1000);
				}
				else if(result==un+pw){
					window.location.href = 'manage.jsp';
				}
				else{
					//登陆成功
					$('#landModal').fadeOut(1000).modal('hide');
					//登陆注册按钮隐藏，显示购物车退出按钮欢迎XXX
					$('#regist, #login').hide();
					$('#welcome, #exit, .cart').show();
					$('#welcome').html(result);
				}
			}
		});
  });
})();
