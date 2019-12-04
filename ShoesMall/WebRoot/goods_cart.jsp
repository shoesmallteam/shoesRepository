<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
		<link rel="stylesheet" type="text/css" href="css/customAnimate.css" /> 
		<link rel="stylesheet" type="text/css" href="css/animate.css" />
		<link rel="stylesheet" type="text/css" href="css/loginRegist.css"/>
		<link rel="stylesheet" type="text/css" href="css/goods_cart.css"/>
    <title></title>
</head>
<body>
	
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <a href="home.jsp">
                        <img src="images/mainPage/logo.svg"/>
                    </a>
                    <div class="col-xs-12 navb text-center">
                        <ul>
                            <li><a href="./classify.jsp?typename=女" target="_self">女装</a></li>
                            <li><a href="./classify.jsp?typename=男" target="_self">男装</a></li>
                            <li><a href="./classify.jsp?typename=童" target="_self">童装</a></li>
                            <li><a href="./classify.jsp?typename=安踏" target="_self">安踏</a></li>
                            <li><a href="./classify.jsp?typename=nike" target="_self">耐克</a></li>
                            <li><a href="./classify.jsp?typename=老人" target="_self">老人</a></li>
                            <li><a href="./classify.jsp?typename=秋冬" target="_self">秋冬款</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-xs-4 col-sm-3" id="logo_right">
                <div class="row">
                    <div class="col-xs-12 search">
                        <div class="input-group">
                            <input type="text" value="" class="form-control" id="logo_right_top"/>
                            <span class="input-group-addon">
						         <span class="glyphicon glyphicon-search"></span>
						   </span>
                        </div>
                    </div>
                    <div class="col-xs-12">
                    	<input type="hidden" value="${nikename}" id="nn"/>
                    	<input type="hidden" value="${msg}" id="msg"/>
                    	<a href="center.jsp" class="navbar-text" id="welcome" style="cursor: pointer;"></a>
                        <p class="cart">
                          <a href="goods_cart.jsp"><span class="glyphicon glyphicon-shopping-cart "></span></a>
                        </p>
                      <button class="btn btn-danger" id="exit" >退出</button>
                       
						<button class="btn btn-danger" id="regist" data-toggle="modal" data-target="#registerModal">注册</button>
						<button class="btn btn-danger" id="login" data-toggle="modal" data-target="#landModal">登录</button>
					 
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
    
<div id="_subnav">
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">女鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">鞋子</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						<li><h3><a href="javascript:;">凉鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">趋势</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						<li><h3><a href="javascript:;">其他购物方式</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
					</ul>
					<div class="col-md-3"><img src="images/mega-nav-combat-2.jpg"/></div>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">男装鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">鞋子</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						<li><h3><a href="javascript:;">凉鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">趋势</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						<li><h3><a href="javascript:;">其他购物方式</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
					</ul>
					<div class="col-md-3"><img src="images/mega-nav-combat-2.jpg"/></div>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">按大小购物</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						<li><h3><a href="javascript:;">其他购物方式</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">女童鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">男童鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">配件类</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">拖鞋</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
						
					</ul>
					<ul class="col-md-3">
						<li><h3><a href="javascript:;">其他购物方式</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-12">
						<li><h3><a href="javascript:;">趋势商店</a></h3></li>
						<li>
							<img style="" src='images/1.jpg'/>
							<img style="" src='images/2.jpg'/>
							<!--<img style="float: left" src='img/3.jpg'/>-->
						</li>
						<li>
							<a href="">女士靴店</a>
							<a style="padding-left: 320px"  href="">您会喜欢的趋势</a>
						</li>
						<li style="height: 50px;"></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul class="col-md-12">
						<li class="text-center">
							<img style="height: 160px;width: 160px;" src="images/adidas.png"/>
							<img style="height: 160px;width: 160px;" src="images/converse.png"/>
							<img style="height: 160px;width: 160px;" src="images/mega-nav-buttons-puma.jpg"/>
							<img style="height: 160px;width: 160px;" src="images/nike.png"/>
							<img style="height: 160px;width: 160px;" src="images/skechers.png"/>
							<img style="height: 160px;width: 160px;" src="images/vans.png"/>
						</li>
						<li class="text-center">
							<img style="height: 160px;width: 160px;" src="images/adidas.png"/>
							<img style="height: 160px;width: 160px;" src="images/converse.png"/>
							<img style="height: 160px;width: 160px;" src="images/mega-nav-buttons-puma.jpg"/>
							<img style="height: 160px;width: 160px;" src="images/nike.png"/>
							<img style="height: 160px;width: 160px;" src="images/skechers.png"/>
							<img style="height: 160px;width: 160px;" src="images/vans.png"/>
						</li>
						<li style="height: 20px;"></li>
						<li class="text-center">
							<button>查看所有品牌</button>
						</li>
						<li style="height: 20px;"></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="subnav animated  wow">
			<div class="container">
				<div class="row">
					<ul style="padding-left: 70px;" class="col-md-3">
						<li style="height: 50px;"></li>
						<li><h3><a href="javascript:;">特价</a></h3></li>
						<li><a href="">靴子</a></li>
						<li><a href="">运动鞋</a></li>
						<li><a href="">休闲鞋</a></li>
						<li><a href="">礼服鞋</a></li>
						<li><a href="">凉鞋</a></li>
						<li><a href="">工作与服务鞋</a></li>
						<li><a href="">拖鞋</a></li>
						<li><a href="">所有女鞋</a></li>
					</ul>
					<ul class="col-md-9">
						<img style="width: 700px;height: 380;" src="images/meganavbanner-rectangle-1.jpg"/>
						<li style="height: 30px;"></li>
					</ul>
				</div>
			</div>
		</div>
		
		
		</div>
					
	
		<div class="banner">
			<div class="container">
				<div class="row">
					<div class="col-xs-8 col-sm-9">
						<p>Famously Foot Wear</p>
					</div>
				</div>
			</div>
		</div>
<div class="goods-cart container">
	<div>
		<font class="go-home">首页</font>
		<font>&gt;</font>
		<font class="currentPage">购物车</font>
	</div>
        <table cellpadding="0px" cellspacing="0px">
<!--        表头-->
            <tr class="row">
                <th class="col-md-3">
                    <div class="">
                        <input type="checkbox" class="cart_selectAll">
                        <span class="">全选</span>
                    </div>
                </th>
                <th  class="col-sm-4">
                    <div>
                        <span class="">商品信息</span>
                    </div>
                </th>
                <th class="col-sm-2">
                    <div >
                        <span class="">颜色尺码</span>
                    </div>
                </th>
                
                <th class="col-sm-1">
                    <div >
                        <span class="">数量</span>
                    </div>
                </th>
                <th class="col-sm-1">
                    <div>
                        <span class="">价格</span>
                    </div>
                </th>
                <th class="col-sm-1">
                    <div>
                        <span class="">小计</span>
                    </div>
                </th>
            </tr>
        </table>
        <div class="cart_total">总价：00.00￥<button class="settlement btn btn-primary">结算</button></div>
    </div>
    
    
    <!--点击弹出模态框(登陆)-->
		<div id="landModal" class="modal fade animated zoomIn wow" data-backdrop = "static">
			<!--弹出窗口-->
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title text-center">
							账号登录
							<span class="close" data-dismiss="modal">&times;</span>
						</h3>
					</div>
					<div class="modal-body">
						<ul>
							<li class="text-center">
								<input  type="text" id="username" class="accountNumber " value="${uuname}" placeholder="邮箱/手机号码/ID"/>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">账号错误</span>
								</div>
							</li>
							<li class="text-center">
								<input  type="password" id="pwd" class="password " value="${uupass}" placeholder="密码"/>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">密码错误</span>
								</div>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">用户名或密码不能为空</span>
								</div>
							</li>
							<li class="text-center">
								<button class="btn" id="loginBtn">登录</button>
							</li>
						</ul>
					</div>
		        	<div class="modal-footer">
		        		<a href="" class="modal-footer-l">手机短信登录</a>
		        		<a href="#" class="modal-footer-r" data-toggle="modal" data-target="#registerModal">立即注册</a>
		        		<a href="#" class="modal-footer-r1" data-toggle="modal" data-target="#forgetModal">忘记密码</a>
	        		</div>
	        	</div>
			</div>
		</div>
		<!--忘记密码模态框-->
		<div id="forgetModal" class="modal fade animated zoomIn wow" data-backdrop = "static">
			<!--弹出窗口-->
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title text-center">
							忘记密码
							<span class="close" data-dismiss="modal">&times;</span>
						</h3>
					</div>
					<div class="modal-body">
						<ul>
							<li class="text-center">
								<input  type="text" id="forgetusername" class="accountNumber " value="" placeholder="邮箱"/>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">邮箱错误</span>
								</div>
							</li>
							<li class="text-center">
								<input  type="text" id="forgetname" class="Obtain " value="" placeholder="请输入验证码"/>
								<input type="hidden" value="点击发送验证码" id="t1"/>
								<button class="btn" id="ObtainBtn" >点击发送验证码</button>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">验证码错误</span>
								</div>
							</li>
							<li class="text-center">
								<input  type="password" id="forgetpwd" class="password " value="" placeholder="请设置新密码"/>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">密码格式错误</span>
								</div>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">必须8-14位不能有空格</span>
								</div>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">信息不能为空</span>
								</div>
							</li>
							<li class="text-center">
								<button class="btn" id="ResetBtn">确认重置</button>
							</li>
						</ul>
					</div>
		        	<div class="modal-footer">
		        		<a href="" class="modal-footer-l">手机短信登录</a>
		        		<a href="#" class="modal-footer-r" data-toggle="modal" data-target="#registerModal">立即注册</a>
		        		<a href="#" class="modal-footer-r1" data-toggle="modal" data-target="#landModal">立即登陆</a>
	        		</div>
	        	</div>
			</div>
		</div>
		<!--点击弹出模态框(注册)-->
		<div id="registerModal" class="modal fade animated rotateInUpLeft wow" data-backdrop = "static">
			<!--弹出窗口-->
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title text-center">
							账号注册
							<span class="close" data-dismiss="modal">&times;</span>
						</h3>
					</div>
					<div class="modal-body">
						<ul>
							<li>
								<div class="modal-body-l1">
									<span>昵称</span>
									<input type="text"  value="" class="form-control" placeholder="请设置用户名"/>
								</div>
							</li>
							<li>
								<p class="p1">中英文数字下划线均可,不能以数字开头,最长9位</p>
								<p class="p2">用户名格式不正确</p>
								<p class="p3"></p>
							</li>
							<li>
								<div class="modal-body-l1">
									<span>手机号</span>
									<input type="text"  value="" class="form-control" placeholder="请设置手机号码"/>
								</div>
							</li>
							<li>
								<p class="p1">请输入中国大陆手机号</p>
								<p class="p2">手机号码格式不正确</p>
								<p class="p3"></p>
								<p class="p4">电话号码已存在</p>
							</li>
							<li>
								<div class="modal-body-l1">
									<span>　密码　</span>
									<input type="password" class="form-control" placeholder="请设置登陆密码"/>
								</div>
							</li>
							<li>
								<p class="p1">长度为8～14个字符</p>
								<p class="p1">支持数字、大小写字母和标点符号,不能有空格</p>
								<p class="p2">密码格式不正确</p>
								<p class="p3"></p>
							</li>
							<li>
								<div class="modal-body-l1">
									<span>　邮箱　</span>
									<input type="text" value="" class="form-control" placeholder="可用于登陆和找回密码"/>
								</div>
							</li>
							<li>
								<p class="p1">支持各种邮箱</p>
								<p class="p2">邮箱格式不正确</p>
								<p class="p3"></p>
								<p class="p4">邮箱已存在</p>
							</li>
							<li>
								<div class="modal-body-l2">
									<span>验证码</span>
									<input type="text" id="checkCode" class="form-control" value="" placeholder="请输入验证码"/>
									<img id="i" src="img.do"/>
								</div>
							</li> 
							<li>							
								<p class="p2">验证码错误,请点击验证码刷新</p>
								<p class="p3"></p>
							</li>
						</ul>
						<button class="btn" id="register">注册</button>
					</div>
					<div class="modal-footer">
						<a href="" class="modal-footer-l">手机短信注册</a>
						<a href="#" class="modal-footer-r" data-toggle="modal" data-target="#landModal">立即登录</a>
		        		<a href="" class="modal-footer-r">已有帐号</a>
					</div>
				</div>
			</div>
		</div>
    
    
</body>
</html>
<script src="./js/jquery-3.4.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/goods_cart.js"></script>
<script type="text/javascript" src="js/register.js" ></script>
<script type="text/javascript" src="js/loginRegist.js" ></script>
<script type="text/javascript" src="js/login.js" ></script>
<script type="text/javascript" src="js/auto_login.js" ></script>
<script type="text/javascript" src="js/forget.js" ></script>