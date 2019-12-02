<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
	<link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
	<link rel="stylesheet" type="text/css" href="css/customAnimate.css" /> 
	<link rel="stylesheet" type="text/css" href="css/loginRegist.css"/>
	<link rel="stylesheet" type="text/css" href="css/product.css"/>
    <link rel="stylesheet" type="text/css" href="css/confirm_order.css">
	
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
                            <li><a href="./classify.jsp?typename=女" target="_self">女装</a></li>
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
                </div>
            </div>
        </div>
    </div>
</header>
<div class="address">
    <div class="row">
        <div class="col-xs-8 col-xs-offset-2">
            <div class="items-headers">
                <div class="header-center">
                    <h2 class="header-title" id="">确认地址信息</h2>
                </div>
                <div class="address-headers">
                    <div class="col-xs-2 items-headers-center">收货人</div>
                    <div class="col-xs-5 items-headers-center">收货地址</div>
                    <div class="col-xs-2 items-headers-center">联系电话</div>
                    <div class="col-xs-2 items-headers-center">确认地址</div>
                </div>
                <div class="address-detail info-cell info-line">
                    <div class="col-xs-2">
                        <p class="name">${confirmdto.address.name }收</p>
                    </div>
                    <div class="col-xs-5">
                        <p class="address-title">${confirmdto.address.province }${confirmdto.address.city }${confirmdto.address.area }${confirmdto.address.detail }</p>
                    </div>
                    <div class="col-xs-2">
                        <p class="tel">${confirmdto.address.tel }</p>
                    </div>
                    <div class="col-xs-2 address-inner">
                        <span class="address-input">
                            <input type="checkbox">
                        </span>
                        <span>确认地址</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" class="accountid" value="${confirmdto.address.accountid }">
<div class="center">
    <div class="row">
        <div class="col-xs-8 col-xs-offset-2">
            <div class="items-headers">
                <div class="header-center">
                    <h2 class="header-title" id="">确认订单信息</h2>
                </div>
                <div class="items-headers-warp">
                    <div class="col-xs-4 items-headers-center">店铺宝贝</div>
                    <div class="col-xs-3 items-headers-center">商品属性</div>
                    <div class="col-xs-1 items-headers-center">单价</div>
                    <div class="col-xs-2 items-headers-center">数量</div>
                    <div class="col-xs-1 items-headers-center">小计</div>
                </div>
                <c:forEach items="${confirmdto.list }" var="shoesdetail" varStatus="i">
	                <div class="body-products info-cell info-line">
	                	<input type="hidden" value="${confirmdto.orderlist[i.index] }" class="orderid">
	                	<input type="hidden" value="${shoesdetail.shoesdetailid }" class="shoesdetailid">
	                    <div class="col-xs-4">
	                        <a href="product.do?shoesid=${shoesdetail.shoesid }" class="detail-img">
	                            <img class="info-img" src="${shoesdetail.image}">
	                        </a>
	                        <div class="detail-descs">
	                            <a href="product.do?shoesid=${shoesdetail.shoesid }" class="detail-title">
	                                ${shoesdetail.descs }
	                            </a>
	                        </div>
	                    </div>
	                    <div class="col-xs-3">
	                        <p class="color">
	                            颜色:
	                            <span>${shoesdetail.color }</span>
	                        </p>
	                        <p class="size">
	                            尺码:
	                            <span>${shoesdetail.size }</span>
	                        </p>
	                    </div>
	                    <div class="col-xs-1">
	                        <p class="price">${shoesdetail.price }</p>
	                    </div>
	                    <div class="col-xs-2 shoescount">
	                        <span class="count-number">${shoesdetail.count }</span>
	                    </div>
	                    <div class="col-xs-1">
	                        <p class="xiaoji">${shoesdetail.price }</p>
	                    </div>
	                </div>
              	</c:forEach>
	            </div>
            </div>
        </div>
    </div>
</div>
<div class="textarea">
    <div class="row">
        <div class="col-xs-8 col-xs-offset-2 textarea-tetil">
            <table>
                <tr>
                    <td rowspan="2">
                        <span class="textarea-say">给卖家留言：</span>
                        <textarea placeholder="选填,请先和商家协商一致" maxlength="200"></textarea>
                    </td>
                    <td>
                        <span>运送方式:</span>
                        <span>普通配送 快递 免邮</span>
                        <span class="textarea-price">0.00</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>运费险:</span>
                        <span>卖家赠送，退换货可赔</span>
                        <span class="textarea-price">0.00</span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="textarea-allprice">
                            <span>店铺合计(含运费)</span>
                            <span class="textarea-price"></span>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="payment">
    <div class="row">
        <div class="col-xs-2 col-xs-offset-8">
            <div>
                <span class="realpay-title">实付款:</span>
                <span class="realpay-price-symbol">￥</span>
                <span class="realpay-price">199.00</span>
            </div>
            <div class="order">提交订单</div>
        </div>
    </div>
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
<script type="text/javascript" src="js/product.js" ></script>
<script type="text/javascript" src="js/confirm_order.js"></script>