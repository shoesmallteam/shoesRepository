//自动登陆
function checkLogin(){
	//拿到账号和密码
    var un = $('#username').val();
    var pw = $('#pwd').val();
    var nn = $('#nn').val();
    var msg = $('#msg').val();
    //判断
    if(un == '' || pw == ''){
    	$('#regist, #login').show();
        $('#welcome, #exit, .cart').hide();
        $('#welcome').html('');
    }else{
		$('#regist, #login').hide();
		$('#welcome, #exit, .cart').show();
		$('#welcome').html(nn);
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
//点击昵称
//$('#welcome').click(function(){
//	console.log(224);
//	var msg = $('#msg').val();
//	if (msg != '') {
//    	alert(msg);
//    	$.ajax({
//    		type:"post",
//    		url:"removemsg.do",
//    	});
//    	$('#regist, #login').show();
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
				window.location.href = 'http://localhost:8080/ShoesMall/home.jsp';
			}
		});
	}
});