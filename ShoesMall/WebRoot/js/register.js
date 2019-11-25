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
//  	newverificationCode = $('#newicheckCode').val();
//  	console.log(userName);
//  	console.log(phoneNumber);
//  	console.log(pwd);
//  	console.log(email);
//		console.log(verificationCode);
//		console.log(newverificationCode);
  	//进行初步判断
  		if(userName == ''){
  			$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').focus();
  			$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').css('border','1px solid red');
  			return;
  		}
  		if(phoneNumber == ''){
  			$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').focus();
  			$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').css('border','1px solid red');
  			return;
  		}
  		if(pwd == ''){
  			$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').focus();
  			$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').css('border','1px solid red');
  			return;
  		}
  		if(email == ''){
  			$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').focus();
  			$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').css('border','1px solid red');
  			return;
  		}
  		if(verificationCode == ''){
  			$('#checkCode').focus();
  			$('#checkCode').css('border','1px solid red');
  			return;
  		}
  	//正则验证
  		//用户名仅支持中英文、数字和下划线,且不能为纯数字
  	 	var re1 =/^[a-z-A-Z_]{1}([a-z-A-Z\d_]){1,5}$/;
  	 	if (!re1.test(userName)) {
  	 		return;
 		}
  	 	//手机号码
  	 	var re2 =/^1[3456789]\d{9}$/g;
  	 	if (!re2.test(phoneNumber)) {
  	 		return;
  	 	}
  	 	//长度为8～14个字符支持数字，大小写字母和标点符号,不能有空格
  	 	var re3 = /^([a-z-A-Z\d]|[,.!@]){8,14}$/g;
  	 	if (!re3.test(pwd)) {
  	 		return;
  	 	}
  	 	//匹配邮箱
  	 	var re4 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/g;
  	 	if (!re4.test(email)) {
  	 		return;
  	 	}
  	 	//验证码
//  	 	if (verificationCode != newverificationCode) {
//			$('#checkCode').focus();
//			$('#checkCode').select();
//			$('#checkCode').css('border','1px solid red');
//			return;
//		};
  	//使用ajax无刷新
  		$.ajax({
  			type:"post",
			url:"register.do",
			data:"userName="+userName+"&phoneNumber="+phoneNumber+"&pwd="+pwd+"&email="+email+"&verificationCode="+verificationCode,
			success:function(result){
				//JS设置页面跳转
				//window.location.href = 'http://localhost:8080/ShoesMall/home.jsp';
				//console.log(result);
				if (result) {
					$('#checkCode').focus();
					$('#checkCode').select();
					$('#checkCode').css('border','1px solid red');
					$('#registerModal .modal-body li:eq(9) .p2').slideDown();
					$('#registerModal .modal-body li:eq(9) .p3').slideUp();
				} else {
					$('#registerModal').fadeOut(100).modal('hide');
					$('#landModal').fadeIn(100).modal('show');
					$('#registerModal .modal-body li:eq(9) .p2').slideUp();
					$('#registerModal .modal-body li:eq(9) .p3').slideDown();
				}
			}
  		});
  		
  		
  		
  		
  		
  		
  		
  		
//  		if (userName == '' || phoneNumber == '' || pwd == '' || email == '') {
//  			alert('信息不能为空');
//  		};
//  		if (verificationCode == '') {
//  			alert('验证码不能为空');
//  			$('#checkCode').focus();
//  			$('#checkCode').css('border','1px solid red');
//  		};
//  		if (verificationCode != newverificationCode) {
//  			alert('验证码错误');
//  			$('#checkCode').focus();
//  			$('#checkCode').select();
//  			$('#checkCode').css('border','1px solid red');
//  		};
//  		
//  	    //api
//  	  	$.post('http://www.wjian.top/shop/api_user.php',{
//      	status : 'register',
//      	username : userName,
//      	password : pwd,
//    }, function(re){
//     	var obj = JSON.parse(re)
//      	console.log(obj);      
//      	//用户名已注册
//      	if(obj.code != 0){
//      	alert('用户名不可用，已注册');
//        $('#registerModal .modal-body li:eq(0) .modal-body-l1 input').focus();
//       	$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').select();
//        return;
//      	};
//      	//注册成功跳转到登录页面
//      	alert('注册成功，点击跳转首页登录页面');
//      	//JS设置页面跳转
//      	$('#registerModal').fadeOut(1000).modal('hide');
//      	window.location.href = 'index.html';
//    	});
//  		
  	});
})();
