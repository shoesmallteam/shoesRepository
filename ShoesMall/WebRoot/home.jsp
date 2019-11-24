<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
    <title></title>
</head>
<body>
	
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <div class="col-xs-12 logo">
                        <img src="images/mainPage/logo.svg"/>
                    </div>
                    <div class="col-xs-12 navb text-center">
                        <ul>
                            <li><a href="./classify.jsp?cartId=62" target="_self">女装</a></li>
                            <li><a href="./classify.jsp?cartId=69" target="_self">男装</a></li>
                            <li><a href="./classify.jsp?cartId=45" target="_self">孩子们</a></li>
                            <li><a href="./classify.jsp?cartId=92" target="_self">配饰</a></li>
                            <li><a href="./classify.jsp?cartId=62" target="_self">发展趋势</a></li>
                            <li><a href="./classify.jsp?cartId=69" target="_self">品牌</a></li>
                            <li><a href="./classify.jsp?cartId=45" target="_self">特卖</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-xs-4 col-sm-3" id="logo_right">
                <div class="row">
                    <div class="col-xs-12 search">
                        <div class="input-group">
                            <input type="text" class="form-control" id="logo_right_top"/>
                            <span class="input-group-addon">
						         <span class="glyphicon glyphicon-search"></span>
						   </span>
                        </div>
                    </div>
                    <div class="col-xs-12">
                    	<p class="navbar-text" id="welcome"></p>
                        <p class="cart">
                          <a href=""><span class="glyphicon glyphicon-shopping-cart "></span></a>
                        </p>
                      <!--  <button class="btn btn-danger" id="exit" data-toggle="modal" data-target="#landModal">退出</button>
                       
						<button class="btn btn-danger" id="regist" data-toggle="modal" data-target="#registerModal">注册</button>
						<button class="btn btn-danger" id="login" data-toggle="modal" data-target="#landModal">登录</button>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
    
<div id="_subnav">
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
		
		<div class="subnav animated fadeInDown wow">
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
					<div class="col-xs-4 col-sm-3 text-center">
						  <button class="btn btn-danger" id="exit" data-toggle="modal" data-target="#landModal">退出</button>
						<!--注册登陆按钮-->
						<button class="btn btn-danger" id="regist" data-toggle="modal" data-target="#registerModal">注册</button>
						<button class="btn btn-danger" id="login" data-toggle="modal" data-target="#landModal">登录</button>
					</div>
				</div>
			</div>
		</div>
			


<section>
			<div class="content_img">
				<div class="topImg container">
					<div  class="mainImg animated pulse wow" data-wow-iteration="infinite"  data-wow-duration="2s" >
						<img src="images/mainPage/spot1-copycentered.jpg" />
					</div>
					<div data-wow-delay="1s" class="imgtop animated pulse wow" data-wow-iteration="infinite"  data-wow-duration="2s">
						<img src="images/mainPage/bogo-no-border.jpg" />
					</div>
					<div data-wow-delay="1s" class="imgbottom animated pulse wow" data-wow-iteration="infinite"  data-wow-duration="2s">
						<img src="images/mainPage/hp-banner-story2a-23.jpg" />
				  </div>
				</div>
				
				<div class="centerImg container">
						<div data-wow-offset="50" data-wow-duration="2s" class="imgleft animated bounceInLeft wow">
							<img src="images/mainPage/hpdesktopspot3caus-1.jpg" />
						</div>
						<div data-wow-offset="50" data-wow-duration="2s" class="imgright animated bounceInRight wow">
							<img src="images/mainPage/hp-banner-story3-with-cta.jpg" />
						</div>
				</div>
				
				<div class="bottomImg container">
					<h1 data-wow-offset="100" class="left animated fadeIn wow">还有更多的爱</h1>
					<div class="content row">
						<div class="col-xs-4">
						<div data-wow-offset="100" class="left animated fadeInLeft wow">
							<img src="images/mainPage/hp-banner-story2a-combat.jpg" />
						</div>
						</div>
						<div class="col-xs-4">
						<div data-wow-offset="100" class="center animated fadeInUp wow">
							<img src="images/mainPage/hp-banner-s2a-1.jpg" />
						</div>
						</div>
						<div class="col-xs-4">
						<div data-wow-offset="100" class="right animated fadeInRight wow">
							<img src="images/mainPage/hp-banner-story2a-1.jpg" />
						</div>
						</div>
					</div>
				</div>
			</div>
			<div class="contentText container">
				<div class="row">
					<div class="textImg col-xs-1 animated pulse wow" data-wow-iteration="infinite">
						<img src="images/mainPage/locate-icon.png"/>
					</div>
					<div class="col-xs-3">
					<div class="textleft">
							<h3>寻找店铺</h3>
							<p>选购超过1000家商店</p>
							<a>找到您附近的商店</a>
					</div>
					</div>
					
					<div class="textImg col-xs-1 animated pulse wow" data-wow-iteration="infinite">
						<img src="images/mainPage/track-icon.png"/>
					</div>
					<div class="col-xs-3">
					<div class="textcenter">
						<h3>追踪您的订单</h3>
						<p>查看当前订单状态</p>
						<a>立即追踪</a>
					</div>
					</div>
					
				<div class="textImg col-xs-1 animated pulse wow" data-wow-iteration="infinite">
						<img src="images/mainPage/reward-icon.png"/>
					</div>
					<div class="col-xs-3">
					<div class="textright">
						<h3>奖励现金</h3>
						<p>购物，赚钱，奖励您应得的</p>
						<a>学到更多</a>
					</div>
				 </div>
				</div>
			</div>
			
			<div class="bottomText text-center container">
				<p>   </p>
				<h4><strong>按性别购物：  女性 - 男性 - 儿童 - 全部选购</strong></h4>
				<h4><strong>鞋店-网上购物鞋店-著名鞋类- 获取报价</strong></h4>
			</div>
	</section>
	
<footer>
		<div class="col-xs-3 text-center">
			<ul>
			<li><strong>我们的商店</strong></li>
			<li><a href="javascript:;">寻找店铺</a></li>
			<li><a href="javascript:;">免费店内取货</a></li>
			<li><a href="javascript:;">送货上门</a></li>
		</ul>
		</div>
		<div class="col-xs-3 text-center">
			<ul>
			<li><strong>我们的公司</strong></li>
			<li><a href="">关于我们</a></li>
			<li><a href="">招纳贤士</a></li>
			<li><a href="">网站地图</a></li>
			<li><a href="">移动应用</a></li>
			<li><a href="">公司背景</a></li>
		</ul>
		</div>
		<ul class="col-xs-3 text-center">
			<li><strong>客户服务</strong></li>
			<li><a href="">联系我们</a></li>
			<li><a href="">退订邮件</a></li>
			<li><a href="">追踪订单</a></li>
			<li><a href="">运输</a></li>
			<li><a href="">退货</a></li>
			<li><a href="">我的账户</a></li>
		</ul>
		<ul class="col-xs-3 text-center">
			<li><strong>政策规定</strong></li>
			<li><a href="">隐私政策</a></li>
			<li><a href="">安全政策</a></li>
			<li><a href="">法律</a></li>
		</ul>
		</div>

		<div class="col-xs-12 text-center">
			<img src="images/mainPage/accessibility-1.png"/>
		</div>
		<div class="col-xs-12 text-center"><br/>
			<img src="images/mainPage/paypal.svg"/>
			<span class="pay"><strong>安全支付</strong></span>
			<p></p>
			<p>输入我的电子邮件地址，即表明我提供的信息准确无误，并且我已年满18岁。预计每周会收到几次电子邮件。查看我们的<a href="">隐私政策</a></p>
		</div>
	</div>
</footer>

<!--点击弹出模态框(登陆)-->
		<div id="landModal" class="modal fade animated zoomIn wow" data-backdrop = "static">
			<!--弹出窗口-->
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title text-center">
							账号登陆
							<span class="close" data-dismiss="modal">&times;</span>
						</h3>
					</div>
					<div class="modal-body">
						<ul>
							<li class="text-center">
								<input  type="text" id="username" class="accountNumber " value="" placeholder="邮箱/手机号码/ID"/>
							</li>
							<li class="text-center">
								<input  type="password" id="pwd" class="password" value="" placeholder="密码"/>
							</li>
							<li>
								<div class="error">
									<em></em>
									<span class="error-con">用户名或密码不能为空</span>
								</div>
							</li>
							<li class="text-center">
								<button class="btn" id="loginBtn">登陆</button>
							</li>
						</ul>
					</div>
		        	<div class="modal-footer">
		        		<a href="" class="modal-footer-l">手机短信登陆</a>
		        		<a href="#" class="modal-footer-r" data-toggle="modal" data-target="#registerModal">立即注册</a>
		        		<a href="" class="modal-footer-r">忘记密码</a>
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
									<span>用户名</span>
									<input type="text"  value="" class="form-control" placeholder="请设置用户名"/>
								</div>
							</li>
							<li>
								<p class="p1">设置后不可更改,中英文数字下划线均可</p>
								<p class="p1">不能以数字开头,最长6位</p>
								<p class="p2">用户名格式不正确</p>
								<p class="p3"></p>
							</li>
							<li>
								<div class="modal-body-l1">
									<span>手机号</span>
									<input type="text"  value="" class="form-control" placeholder="可用于登陆和找回密码"/>
								</div>
							</li>
							<li>
								<p class="p1">请输入中国大陆手机号</p>
								<p class="p2">手机号码格式不正确</p>
								<p class="p3"></p>
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
									<input type="text" value="" class="form-control" placeholder="请设置登陆邮箱"/>
								</div>
							</li>
							<li>
								<p class="p1">支持各种邮箱</p>
								<p class="p2">邮箱格式不正确</p>
								<p class="p3"></p>
							</li>
							<li>
								<div class="modal-body-l2">
									<span>验证码</span>
									<input type="text" id="checkCode" class="form-control" value="" placeholder="请输入验证码"/>
									<img id="i" src="img.do"/>
								</div>
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

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/mainPage.js"></script>
<script type="text/javascript" src="js/register.js" ></script>
<script type="text/javascript" src="js/login.js" ></script>
<script type="text/javascript" src="js/loginRegist.js" ></script>

