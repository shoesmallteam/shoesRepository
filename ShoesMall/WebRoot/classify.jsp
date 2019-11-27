<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/customAnimate.css" />
    <link rel="stylesheet" type="text/css" href="css/animate.min.css" />
    <link rel="stylesheet" href="css/mainPage.css">
    <link rel="stylesheet" type="text/css" href="css/classify.css">
    <title>分类</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <div class="col-xs-12 logo">
                    	<a href="index.html">
                        	<img src="images/mainPage/logo.svg"/>
                        </a>
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
<section>
    <div class="container classify">
        <div class="row">

        </div>
    </div>
    <div class="load-more">加载更多</div>
</section>
</body>
</html>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="./js/base.js"></script>
<script src="./js/classify.js"></script>
<script type="text/javascript" src="js/wow.min.js">
	
</script>