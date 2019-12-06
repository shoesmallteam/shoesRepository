//自动登陆
function checkLogin(){
	//拿到账号和密码
    var un = $('#username').val();
    var pw = $('#pwd').val();
    var nn = $('#nn').val();
    var msg = $('#msg').val();
    var isa = $('#isa').val();
    //判断
    if(un == '' || pw == ''){
    	$('#regist, #login').show();
        $('#welcome, #exit, .cart').hide();
        $('#welcome').html('');
    }else{
    	if(isa == '0'){
    		$('#regist, #login').hide();
    		$('#welcome, #exit, .cart').show();
    		$('#welcome').html(nn);
    	}else{
    		window.location.href = 'manage.jsp';
    	}
    };
    if (msg != '') {
    	alert(msg);
    	$.ajax({
    		type:"post",
    		url:"removemsg.do",
    	});
    	$('#regist, #login').show();
    	$('#welcome, #exit, .cart').hide();
    }
    
};
checkLogin();
//点击昵称，如果已经被踢下线了就返回重新登陆，如果没有就跳转到个人中心页面
//$('#welcome').click(function(){
//	//console.log(224);
//	var msg = $('#msg').val();
//	if (msg != '') {
//    	alert(msg);
//    	$(this).removeAttr("id");
//    	$.ajax({
//    		type:"post",
//    		url:"removemsg.do",
//    	});
//    	$('#regist, #login').show();
//    	
//    	$('#welcome, #exit, .cart').hide();
//    }
//});
//点击退出
$('#exit').click(function(){
	if (confirm(" Are you sure? ")) {
		$.ajax({
			type:"post",
			url:"exits.do",
			success:function(result){
				$('#regist, #login').show();
		    	$('#welcome, #exit, .cart').hide();
			}
		});
	}
});