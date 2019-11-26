//动画初始化调用
  new WOW().init();
//登陆界面点击注册
  $('#landModal .modal-footer .modal-footer-r').click(function(){
  	$('#landModal').fadeOut(1000).modal('hide');
});
//注册界面点击登陆
   $('#registerModal .modal-footer .modal-footer-r').click(function(){
	$('#registerModal').fadeOut(1000).modal('hide');
});
//获得焦点和失去焦点
//用户名框
$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').focus(function(){
	$('#registerModal .modal-body li:eq(1) .p1').slideDown();
	$('#registerModal .modal-body li:eq(1) .p2').hide();
	$('#registerModal .modal-body li:eq(1) .p3').hide();
	$('#registerModal .modal-body li:eq(3) .p1').hide();
	$('#registerModal .modal-body li:eq(5) .p1').hide();
	$('#registerModal .modal-body li:eq(7) .p1').hide();
	$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').css('border','1px solid blue');
});
$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').blur(function(){
	$('#registerModal .modal-body li:eq(1) .p1').slideUp();
	//拿到文本框输入的值
	var m = $('#registerModal .modal-body li:eq(0) .modal-body-l1 input').val();
	//用户名仅支持中英文、数字和下划线,且不能以数字开头,最长6位
 	var re1 =/^[a-z-A-Z_]{1}([a-z-A-Z\d_]){1,5}$/;
 	if (re1.test(m)) {
 			$('#registerModal .modal-body li:eq(1) .p3').slideDown();
 		} else{
 			$('#registerModal .modal-body li:eq(1) .p2').slideDown();
 			$('#registerModal .modal-body li:eq(0) .modal-body-l1 input').css(
 				'border','1px solid red'
 			);
 		};
});
//手机号框
$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').focus(function(){
	$('#registerModal .modal-body li:eq(3) .p1').slideDown();
	$('#registerModal .modal-body li:eq(3) .p2').hide();
	$('#registerModal .modal-body li:eq(3) .p3').hide();
	$('#registerModal .modal-body li:eq(1) .p1').hide();
	$('#registerModal .modal-body li:eq(5) .p1').hide();
	$('#registerModal .modal-body li:eq(7) .p1').hide();
	$('#registerModal .modal-body li:eq(3) .p4').slideUp();
	$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').css('border','1px solid blue');
});
$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').blur(function(){
	$('#registerModal .modal-body li:eq(3) .p1').slideUp();
	//拿到文本框输入的值
	var tel = $('#registerModal .modal-body li:eq(2) .modal-body-l1 input').val();
	//console.log(tel);
	//手机号码 
 	var re1 = /^1[3456789]\d{9}$/g;
 	if (re1.test(tel)) {
 			$('#registerModal .modal-body li:eq(3) .p3').slideDown();
 		} else{
 			$('#registerModal .modal-body li:eq(3) .p2').slideDown();
 			$('#registerModal .modal-body li:eq(3) .p4').slideUp();
 			$('#registerModal .modal-body li:eq(2) .modal-body-l1 input').css('border','1px solid red');
 		};
 	//使用ajax无刷新
  		$.ajax({
  			type:"post",
			url:"tel.do",
			data:"tel="+tel,
			success:function(result){
				//console.log(result);
				if (result) {
					$('#registerModal .modal-body li:eq(3) .p3').slideUp();
					$('#registerModal .modal-body li:eq(3) .p4').slideDown();
				}
			}
  		});
});
//密码框
$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').focus(function(){
	$('#registerModal .modal-body li:eq(5) .p1').slideDown();
	$('#registerModal .modal-body li:eq(5) .p2').hide();
	$('#registerModal .modal-body li:eq(5) .p3').hide();
	$('#registerModal .modal-body li:eq(1) .p1').hide();
	$('#registerModal .modal-body li:eq(3) .p1').hide();
	$('#registerModal .modal-body li:eq(7) .p1').hide();
	$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').css('border','1px solid blue');
});
$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').blur(function(){
	$('#registerModal .modal-body li:eq(5) .p1').slideUp();
	//拿到文本框输入的值
	var m = $('#registerModal .modal-body li:eq(4) .modal-body-l1 input').val();
	//长度为8～14个字符支持数字，大小写字母和标点符号,不能有空格
 	var re1 = /^([a-z-A-Z\d]|[,.!@]){8,14}$/g;
 	if (re1.test(m)) {
 			$('#registerModal .modal-body li:eq(5) .p3').slideDown();
 		} else{
 			$('#registerModal .modal-body li:eq(5) .p2').slideDown();
 			$('#registerModal .modal-body li:eq(4) .modal-body-l1 input').css('border','1px solid red');
 		};
 	
});
//邮箱
$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').focus(function(){
	$('#registerModal .modal-body li:eq(7) .p1').slideDown();
	$('#registerModal .modal-body li:eq(7) .p2').hide();
	$('#registerModal .modal-body li:eq(7) .p3').hide();
	$('#registerModal .modal-body li:eq(1) .p1').hide();
	$('#registerModal .modal-body li:eq(3) .p1').hide();
	$('#registerModal .modal-body li:eq(5) .p1').hide();
	$('#registerModal .modal-body li:eq(7) .p4').slideUp();
	$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').css('border','1px solid blue');
});
$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').blur(function(){
	$('#registerModal .modal-body li:eq(7) .p1').slideUp();
	//拿到文本框输入的值
	var email = $('#registerModal .modal-body li:eq(6) .modal-body-l1 input').val();
	//匹配邮箱
 	var re1 = /^\w+@\w+\.(net|com|cn|org)+$/g;
 	if (re1.test(email)) {
 			$('#registerModal .modal-body li:eq(7) .p3').slideDown();
 		} else{
 			$('#registerModal .modal-body li:eq(7) .p4').slideUp();
 			$('#registerModal .modal-body li:eq(7) .p2').slideDown();
 			$('#registerModal .modal-body li:eq(6) .modal-body-l1 input').css('border','1px solid red');
 		};
 		//使用ajax无刷新
  		$.ajax({
  			type:"post",
			url:"email.do",
			data:"email="+email,
			success:function(result){
				//console.log(result);
				if (result) {
					$('#registerModal .modal-body li:eq(7) .p3').slideUp();
					$('#registerModal .modal-body li:eq(7) .p4').slideDown();
				}
			}
  		});
});
//验证码获得焦点
$('#checkCode').focus(function(){
	$('#checkCode').css('border','1px solid bule');
});
//点击更换验证码
$('#registerModal .modal-body li .modal-body-l2>img').click(function(){
	//console.log(1);
	$('#registerModal .modal-body li .modal-body-l2>img').attr('src', 'img.do?id='+new Date().getTime());
});



////验证码
////页面加载时生成随机验证码
//window.onload=function(){
//     createCode(4);    
//}
//var codeV = document.getElementById('code');
//codeV.onclick = function(){
//	createCode();
//	codeV.style.background=bg3();
//};
////封装验证码方法
////设置一个全局的变量，便于保存验证码
//    var code;
//    function createCode(){
//        //首先默认code为空字符串
//        code = '';
//        //设置长度，这里看需求，我这里设置了4
//        var codeLength = 4;
//        var codeV = document.getElementById('code');
//        //设置随机字符
//        var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
//        //循环codeLength 我设置的4就是循环4次
//        for(var i = 0; i < codeLength; i++){
//            //设置随机数范围,这设置为0 ~ 36
//             var index = Math.floor(Math.random()*36);
//             //字符串拼接 将每次随机的字符 进行拼接
//             code += random[index]+'  '; 
//        }
//        //将拼接好的字符串赋值给展示的Value
//        codeV.value = code;
//    }
////封装变换颜色的方法
//function bg3(){
//             var r=Math.floor(Math.random()*256);
//             var g=Math.floor(Math.random()*256);
//             var b=Math.floor(Math.random()*256);
//             return "rgb("+r+','+g+','+b+")";//所有方法的拼接都可以用ES6新特性`其他字符串{$变量名}`替换
//         }