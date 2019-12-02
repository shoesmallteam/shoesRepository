<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="css/product.css"/>
    <title></title>
  </head>
  
  <body>
  	<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <div class="col-xs-12 logo">
                        <a href="index.html"><img src="images/mainPage/logo.svg"/></a>
                    </div>
                    <div class="col-xs-12 navb text-center">
                        <ul>
                            <li><a href="./classify.html?cartId=62" target="_self">女装</a></li>
                            <li><a href="./classify.html?cartId=69" target="_self">男装</a></li>
                            <li><a href="./classify.html?cartId=45" target="_self">孩子们</a></li>
                            <li><a href="./classify.html?cartId=92" target="_self">配饰</a></li>
                            <li><a href="./classify.html?cartId=62" target="_self">发展趋势</a></li>
                            <li><a href="./classify.html?cartId=69" target="_self">品牌</a></li>
                            <li><a href="./classify.html?cartId=45" target="_self">特卖</a></li>
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
                    	<input type="hidden" value="${nikename}" id="nn"/>
                    	<input type="hidden" value="${msg}" id="msg"/>
                    	<a href="http://localhost:8080/ShoesMall/center.jsp" class="navbar-text" id="welcome" style="cursor: pointer;"></a>
                        <p class="cart">
                          <a><span class="glyphicon glyphicon-shopping-cart "></span></a>
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
		
		<!--点击弹出模态框(登录)-->
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
									<input type="text"  value="" class="form-control" placeholder="可用于登陆和找回密码"/>
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
									<input type="text" value="" class="form-control" placeholder="请设置登陆邮箱"/>
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

<section class="product">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 content-show">
                <div class="topbtn">
                    <span>style # <span id="shoesid">${dto.shoesid }</span></span>
                </div>
                <div class="product-img">
                    <img src="">
                    <div class="slide"></div>
                </div>
                <nav class="navbar">
                    <div class="container">
                        <ul class="nav navbar-nav">
                        	<c:forEach items="${dto.color }" var="color" varStatus="i">
                        		<c:set var="endcolor" value="${color }"></c:set>
                        		<%--color.key eq endcolor  --%>
                        		<c:if test="${i.count eq 1 }">
	                        		<li><img class="colorImage" src="${color.value }"></li>
                        		</c:if>
                        		<c:if test="${i.count ne 1 }">
	                        		<li><img src="${color.value }"></li>
                        		</c:if>
                        	</c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
            <div class="col-xs-6 banners" >
                <a href="#"><img src="images/blowfish.png"></a>
                <h4>${dto.descs }</h4>
                <div class="price">
                    <span>${dto.price }</span>
                    <span>${dto.price }</span>
                </div>
                <div class="dashedline"></div>
                <nav class="navbar">
                    <div class="container">
                        <span class="navbar-text navbar-left color">颜色:</span>
                        <ul class="nav navbar-nav" id="color">
                        	<c:forEach items="${dto.color }" var="color" varStatus="i">
                        		<li value="${color.key }">
                                	<img src="${color.value }">
                            	</li>
                        	</c:forEach>
                        </ul>
                    </div>
                </nav>
                <div class="size">
                    <span>尺码:</span>
                    <label class="prodSpec">
                    	<c:forEach items="${dto.size }" var="size" varStatus="i">
                    		<a><span>${size }</span></a>
                    	</c:forEach>
                    <%-- 
                        <a><span>35</span></a>
                        <a><span>36</span></a>
                        <a><span>37</span></a>
                        <a><span>38</span></a>
                        <a><span>39</span></a>
                        <a><span>40</span></a>
                        <a><span>41</span></a>
                        <a><span>42</span></a>
                        --%>
                        <a class="more"><span>...</span></a>
                    </label>
                </div>
                <div class="count">
                    <span>数量:</span>
                    <input type="text" value="1" maxlength="2">
                    <div class="buttons">
                        <a href="javascript:;" class="add"></a>
                        <a href="javascript:;" class="sub"></a>
                    </div>
                    <span class="shoescount">库存<span id="onlycount">${dto.allcount }</span>件</span>
                </div>
                <div class="buy-btns">
                    <a href="javascript:;" class="add-cart" data-goods-id="${dto.shoesid }">
                        <button>加入购物车</button>
                    </a>
                    <a href="javascript:;" class="buy">
                        <button>去结算</button>
                    </a>
                </div>
                <div class="big-img"></div>
            </div>
        </div>
    </div>
</section>
<div class="more-size">
    <div class="more-header">
        <span>尺码对照表</span>
        <p>X</p>
    </div>
    <table>
        <caption>尺码表</caption>
        <tr>
            <td>法国码</td>
            <td>32</td>
            <td>33</td>
            <td>34</td>
            <td>35</td>
            <td>36</td>
            <td>37</td>
            <td>38</td>
            <td>39</td>
            <td>40</td>
            <td>41</td>
            <td>42</td>
        </tr>
        <tr>
            <td>国际码</td>
            <td>210</td>
            <td>215</td>
            <td>220</td>
            <td>225</td>
            <td>230</td>
            <td>235</td>
            <td>240</td>
            <td>245</td>
            <td>250</td>
            <td>255</td>
            <td>260</td>
        </tr>
    </table>
</div>

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
  </body>
</html>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/mainPage.js"></script>
<script type="text/javascript" src="js/register.js" ></script>
<script type="text/javascript" src="js/login.js" ></script>
<script type="text/javascript" src="js/auto_login.js" ></script>
<script type="text/javascript" src="js/loginRegist.js" ></script>
<script type="text/javascript" src="js/product.js" ></script>