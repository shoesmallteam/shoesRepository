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
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
    <link rel="stylesheet" type="text/css" href="css/mainPage.css">
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
                            <li><a href="./classify.html?cartId=62" target="_self">女装</a></li>
                            <li><a href="./classify.html?cartId=69" target="_blank">男装</a></li>
                            <li><a href="classfiy.html?cartId=82">孩子们</a></li>
                            <li><a href="classfiy.html?cartId=2">配饰</a></li>
                            <li><a href="classfiy.html?cartId=82">发展趋势</a></li>
                            <li><a href="classfiy.html?cartId=82">品牌</a></li>
                            <li><a href="classfiy.html?cartId=82">特卖</a></li>
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
</body>
</html>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/wow.min.js"></script>