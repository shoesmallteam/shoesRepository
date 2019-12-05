<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="css/base.css"/>
	<link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
	<link rel="stylesheet" type="text/css" href="css/customAnimate.css" /> 
<!-- 	<link rel="stylesheet" type="text/css" href="css/animate.css" /> -->
	<link rel="stylesheet" type="text/css" href="css/manage.css" />
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
                </div>
            </div>
            <div class="col-xs-4 col-sm-3" id="logo_right">
                <div class="row">
                    <div class="col-xs-12 search">
                        <div class="input-group">
                           <!--  <input type="text" value="" class="form-control" id="logo_right_top"/> -->
                            <span class="input-group-addon">
						       管理员，欢迎您！   <span class="glyphicon glyphicon-heart"></span>
						   </span>
                        </div>
                    </div>
                    <div class="col-xs-12">
                      <button class="btn btn-danger" id="exit" >退出</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<center>
	<div class="contant">
		<hr/>
		<div class="tag">
			<div class="account_tag">账户管理</div>
			<div class="shoes_tag">商品管理</div>
		</div>
		<div class="info">
			<div class="account_info">
				<table>
					
				</table>
			</div>
			<div class="shoes_info">
				<table>
					
				</table>
			</div>
			<button class="prve">上一页</button>
			<input type="hidden" value="1" class="pagesize">
			<button class="next">下一页</button>
		</div>
	</div>
</center>
<section class="transparent"></section>
		<div class="center-delete">
			<div class="ask-delete">确认删除？</div>
				<input type="button" value="确认" class="enter-delete"/>
				<input type="button" value="取消" class="no-delete"/>
			<div class="close-ask"></div>
		</div>
		
		<div class="center-update">
				accountid<input type="text" id="account"/><br/>
				管理员权限：<input type="text" id="isassistant"/><br/>
				　 vip:　　　<input type="text" id="isvip"/><br/>
				
				<input type="button" value="修改" class="enter-update"/>
				<input type="button" value="取消" class="no-update"/>
			<div class="close-update"></div>
		</div>
  </body>
</html>
<script type="text/javascript" src="js/jquery-3.4.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/manageajax.js"></script>