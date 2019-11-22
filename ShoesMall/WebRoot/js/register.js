(function(){
	//初始化注册信息
	var userName = null;//用户名
	var phoneNumber = null;//电话号码
  	var pwd = null;//密码
  	var email = null;//邮箱
  	var verificationCode =null;//验证码
  	var newverificationCode = null;//随机生成的验证码
  	//模态框里的注册
  	$('#register').click(function(){
  	//拿到注册信息
  		userName = $('#registerModal .modal-body li:eq(0) .modal-body-l1 input').val();
  		phoneNumber = $('#registerModal .modal-body li:eq(2) .modal-body-l1 input').val();
  		pwd = $('#registerModal .modal-body li:eq(4) .modal-body-l1 input').val();
  		email = $('#registerModal .modal-body li:eq(6) .modal-body-l1 input').val();
  		verificationCode = $('#checkCode').val();
  		newverificationCode = $('#code').val();
		console.log(newverificationCode);
		console.log(verificationCode);
//		console.log(userName);
//		console.log(verificationCode);
  		if (userName == '' || phoneNumber == '' || pwd == '' || email == '') {
  			alert('信息不能为空');
  		};
  		if (verificationCode == '') {
  			alert('验证码不能为空');
  			$('#checkCode').focus();
  			$('#checkCode').css('border','1px solid red');
  		};
  		if (verificationCode != newverificationCode) {
  			alert('验证码错误');
  			$('#checkCode').focus();
  			$('#checkCode').select();
  			$('#checkCode').css('border','1px solid red');
  		};
  		
  	    //api
  	  	$.post('http://www.wjian.top/shop/api_user.php',{
      	status : 'register',
      	username : userName,
      	password : pwd,
    }, function(re){
     	var obj = JSON.parse(re)
      	console.log(obj);      
      	//用户名已注册
      	if(obj.code != 0){
      	alert('用户名不可用，已注册');
        $('#registerModal .modal-body li:eq(0) .modal-body-l1 input').focus();
       	$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').select();
        return;
      	};
      	//注册成功跳转到登录页面
      	alert('注册成功，点击跳转首页登录页面');
      	//JS设置页面跳转
      	$('#registerModal').fadeOut(1000).modal('hide');
      	window.location.href = 'index.html';
    	});
  		
  	});
})();
