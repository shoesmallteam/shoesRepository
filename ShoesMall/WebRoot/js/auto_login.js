//自动登陆
function checkLogin(){
	//拿到账号和密码
    var un = $('#username').val();
    var pw = $('#pwd').val();
    var nn = $('#nn').val();
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
};
checkLogin();
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