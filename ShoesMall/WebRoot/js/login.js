//首页打开，判断用户是否登录
function checkLogin(){
  //获取localStorage  username  token
  var userName = localStorage.getItem('username');
  var token = localStorage.getItem('token');
  console.log(token)
  //验证
  if(token){
    $('#regist, #login').hide();
    $('#welcome, #exit, .cart').show();
   /* $('#welcome').html('欢迎 '+userName);*/
    
  }else{
    $('#regist, #login').show();
    $('#welcome, #exit, .cart').hide();
    $('#welcome').html('');
  };
};
checkLogin();
//登录
(function(){
  $('#loginBtn').click(function(){
    //拿到账号和密码
    var userName = $('#username').val();
    var pwd = $('#pwd').val();
    //验证
    if(userName == '' || pwd == ''){
      $('#landModal .modal-body li:eq(2) .error').fadeIn(1000);
      return;
    };
    //请求登录
    $.post('http://www.wjian.top/shop/api_user.php', {
      status : 'login',
      username : userName,
      password : pwd,
    }, function(re){
      var obj = JSON.parse(re);
      console.log(obj);
      //分三种情况 2002  1001  0
      if(obj.code == 2002){
        alert('用户名不存在');
        return;
      };
      if(obj.code == 1001){
        alert('密码错误');
        return;
      };
      //成功  刷新页面
      alert('登录成功'); 
      window.location.href = 'index.html';
      //怎么样才能知道是登录状态   localStorage  cookie
      localStorage.setItem('username',obj.data.username);
      localStorage.setItem('token',obj.data.token);
      //求传过来的goods_id
      var goodsId = getUrlVal('goods_id');
      if(goodsId){
        location.href = 'product.html?goods_id='+goodsId;              
      }else{
        location.href = 'index.html';         
      };
    });   
  });
})();
//点击退出
(function(){
  $('#exit').click(function(){
    //清空本地存储
    localStorage.removeItem('username');
    localStorage.removeItem('token');
    window.location.href = 'index.html';
    //调用交互方法
    checkLogin();
  });
})();