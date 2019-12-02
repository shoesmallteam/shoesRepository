<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="./css/base.css">
    <link rel="stylesheet" href="./css/goods_cart.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="./css/animate.min.css" />
    <link rel="stylesheet" href="./css/mainPage.css">
    <title>购物车</title>
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
                            <input type="text" class="form-control" />
                            <span class="input-group-addon">
						              	<span class="glyphicon glyphicon-search"></span>
						            </span>
                        </div>
                    </div>
                    <div class="col-xs-12">
                        <p class="cart">
                            我的购物车<a href=""><span class="glyphicon glyphicon-shopping-cart "></span></a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="goods-cart container">
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
        <div class="cart_total">总价：00.00￥<button class="btn btn-primary">结算</button></div>
    </div>
</body>
</html>
<script src="./js/jquery-3.4.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/goods_cart.js"></script>