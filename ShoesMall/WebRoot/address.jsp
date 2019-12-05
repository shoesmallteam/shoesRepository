
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
    <title>My JSP 'submitOrder.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="css/submitOrder.css"/>
    <link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
  </head>
<body>
<header style="height: 74px;">
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <div class="col-xs-12 logo">
                    <a href="home.jsp" style="margin-left: 196px">
                        <img src="images/mainPage/logo.svg"/>
                    </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
	<!--收货信息-->	
		<section class="receiveSection">
			<div class="title"><p>我的收货地址</p></div>
			<div class="receive-info">
				<!-- <h3>收货信息</h3> -->
				<!-- 填写信息 -->
				
				<div class="main-info" style="display: none;">
				<input type="hidden" id="uid" value="${uid }" />
				<input type="hidden" id="addressid" value="${addressid }" />
					收货人
					<div class="receiver">
						<label>收货人</label>
						<input type="text" name="consignee" id="consignee" placeholder="长度为2-16个字符"/>
						<span>*</span>
					</div>
					电话
					<div class="tel">
						<label>手机号码</label>
						<input type="text" name="phone-number" id="phone-number" placeholder="请输入手机号码"/>
						<span>*</span>
					</div>
					大概地址
					<div class="address">
						<label>所在地区</label>
						<select name="provinces" id="provinces" onChange="changeCity()">
							<option value="" >省</option>
						</select>
						<select name="city" id="city" onChange="changeArea()">
							<option value="">市</option>
						</select>
						<select name="area" id="area">
							<option value="">区&县</option>
						</select>
						<span>*</span>
					</div>
					详细地址
					<div class="main-address">
						<label class="area">详细地区</label>
						<textarea name="detail-address" id="detail-address" placeholder="输入5-150个字符的详细地址"></textarea>
						<span>*</span>
						<p class="no-delivery">不支持港澳台地区配送</p>
					</div>
					默认复选框
					<div class="set-default">
						<input type="checkbox" name="default" id="default"/><p>设为默认</p>
					</div>
					保存
					<div class="keep">
						<button id="save">保存</button>
						<button id="update">修改</button>
						<button id="exit-add">取消</button>
					</div>
				</div> 
				<!--选择地址-->
				<!-- 
							 String uid = request.getParameter("uid");
							System.out.print(uid); 
							//ArrayList<Address> list = (ArrayList<Address>)request.getAttribute("addressList");
				 -->
				<center>
				<div class="select-address" id="select-address" style="display: block;" >
					<table>
						<tbody>
						 <c:forEach var="a" items="${addressList }">
							<tr data-addressid="${a.addressid }" data-name="${a.name }" data-tel="${a.tel }"
								data-province="${a.province}" data-city="${a.city}" data-area="${a.area}" data-detail="${a.detail}"
							>
							    <td><input type="hidden" id="addressid" value="${a.addressid }"></td> 
								<td id="consignees"><p>${a.name }</p></td>
								<td id="phone-numbers"><p>${a.tel }</p></td>
								
								<td id="address"><p>${a.province}${a.city}${a.area}${a.detail}</p></td>
								<td id="operation">
									<span id="modify">修改</span>
									<span>　</span>
									<span id="delete">删除</span>
								</td>
							</tr>
						</c:forEach>
							<tr id="add-address">
								<td>
									<div class="add-curcle"><p>新增收货地址</p></div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				</center>
			</div>
	</section>
		<!--删除界面-->
		<section class="transparent"></section>
		<div class="center-delete">
			<div class="ask-delete">确认删除？</div>
				<input type="button" value="确认" class="enter-delete"/>
				<input type="button" value="取消" class="no-delete"/>
			<div class="close-ask"></div>
		</div>
	</body>
</html>
<script type="text/javascript" src="js/jquery-3.4.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/address.js" charset="GBK"></script>
<script type="text/javascript" src="js/submitOrder.js" charset="GBK"></script>