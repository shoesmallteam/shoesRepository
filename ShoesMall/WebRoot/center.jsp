<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/customAnimate.css"/>
		<link rel="stylesheet" type="text/css" href="css/animate.css"/>	
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
		<link rel="stylesheet" type="text/css" href="css/center.css"/>
<title>Insert title here</title>
</head>
<body>

<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <div class="row">
                    <div class="col-xs-12 logo">
                    <a href="home.jsp">
                        <img src="images/mainPage/logo.svg"/>
                    </a>
                    </div>
                    <div class="col-xs-12 navb text-center">
                        <ul>
                            <li><a href="./classify.do?typename=girl" target="_self">女装</a></li>
                            <li><a href="./classify.jsp?cartId=69" target="_self">男装</a></li>
                            <li><a href="./classify.jsp?cartId=45" target="_self">童装</a></li>
                            <li><a href="./classify.jsp?cartId=92" target="_self">安踏</a></li>
                            <li><a href="./classify.jsp?cartId=62" target="_self">耐克</a></li>
                            <li><a href="./classify.jsp?cartId=69" target="_self">老人</a></li>
                            <li><a href="./classify.jsp?cartId=45" target="_self">秋冬款</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<section>
	<div id="section-big-layout">
		<div id="section-big-layout-left">
			<ul>
				<li><a>个人信息</a></li>
				<li><a>账号密码</a></li>
				<li><a>安全手机</a></li>
				<li><a>安全邮箱</a></li>
				<li><a>实名认证</a></li>
				<li><a>我的订单</a></li>
				<li><a href="selectAddress.do">配送地址</a></li>
				<li><a>评价晒单</a></li>
				<li><a>我的资产</a></li>
				<li><a>消息通知</a></li>
				<!--<li><a>优惠卷</a></li>
				<li><a>红包</a></li>
				<li><a>回收单</a></li>
				<li><a>回收代金卷</a></li>
				<li><a>服务政策</a></li>
				<li><a>服务记录</a></li>-->
			</ul>
		</div>
		<div id="section-big-layout-right">
			<ul>
				<li>					
					<div class="layout-right-l1-all">
						<div class="layout-right-l1-top">
							<span class="span1">个人资料</span>
							<span class="span2">|Personal Information</span>
						</div>
						
						<div class="layout-right-l1-middle">
							<div class="layout-right-l1-middle1">
								<div class="layout-right-l1-middle1-left">
									<p>头像</p>
								</div>
								<div class="layout-right-l1-middle1-right">
								<input type="hidden" value="${ac.photo}" id="imgimg"/>
									<img id="img1" src=""/>
								</div>
							</div>
							<div class="layout-right-l1-middle1">
								<div class="layout-right-l1-middle1-left">
									<p>昵称</p>
								</div>
								<div class="layout-right-l1-middle1-right">
								<input type="hidden" value="${msg}" id="msg"/>
								<input type="hidden" value="${ni}" id="nn"/>
									<p id="ni">用户124564789</p>
								</div>
							</div>
						</div>
						
						<div class="layout-right-l1-middle">
							<div class="layout-right-l1-middle1">
								<div class="layout-right-l1-middle1-left">
									<p>姓名</p>
								</div>
								<div class="layout-right-l1-middle1-right">
								<input type="hidden" value="${ac.ssname}" id="na"/>
									<p id="mingzi">未填写</p>
								</div>
							</div>
							<div class="layout-right-l1-middle1">
								<div class="layout-right-l1-middle1-left">
									<p>性别</p>
								</div>
								<div class="layout-right-l1-middle1-right">
								<input type="hidden" value="${ac.sssex}" id="se"/>
									<p id="sssssix">男</p>
								</div>
							</div>
							<div class="layout-right-l1-middle1">
								<div class="layout-right-l1-middle1-left">
									<p>生日</p>
								</div>
								<div class="layout-right-l1-middle1-right">
								<input type="hidden" value="${ac.ssbirthday}" id="birth"/>
									<p id="sheng">未填写</p>
								</div>
							</div>
						</div>
						<button class="btn layout-right-l1-down" >编辑我的信息</button>
					</div>
					<!-- 
					**
					**
					 -->
					<div class="layout-right-l1-all2">
						<div class="layout-right-l1-top2">
							<span class="span1">个人资料</span>
							<span class="span2">|Personal Information</span>
						</div>
						
						<div class="layout-right-l1-middle2">
							<div class="layout-right-l1-middle22">
								<div class="layout-right-l1-middle22-left">
									<p>头像</p>
								</div>
								<div class="layout-right-l1-middle22-right">
									<img id="img" src="images/mainPage/zong.jpg"/>
								</div>
								<div class="layout-right-l1-middle33-right">
									<input type="file" onchange="show(this)" />
									<input type="hidden" value="" id="content"/>
								</div>
							</div>
							<div class="layout-right-l1-middle22">
								<div class="layout-right-l1-middle22-left">
									<p>昵称</p>
								</div>
								<div class="layout-right-l1-middle22-right">
									<input class="form-control" type="text" placeholder="请填写昵称" name="" id="nicheng" value="${nikename}" />
								</div>
							</div>
						</div>
						
						<div class="layout-right-l1-middle2">
							<div class="layout-right-l1-middle22">
								<div class="layout-right-l1-middle22-left">
									<p>姓名</p>
								</div>
								<div class="layout-right-l1-middle22-right">
									<input class="form-control" type="text" placeholder="请填写姓名" name="" id="xingming" value="" />
								</div>
							</div>
							<div class="layout-right-l1-middle22">
								<div class="layout-right-l1-middle22-left">
									<p>性别</p>
								</div>
								<div class="layout-right-l1-middle22-right">
									<select class="sexs form-control">
				       					<option value="男">男</option>
				        				<option value="女">女</option>
				      				</select>
								</div>
							</div>
							<div class="layout-right-l1-middle22">
								<div class="layout-right-l1-middle22-left">
									<p>生日</p>
								</div>
								<div class="layout-right-l1-middle22-right">
									<div class="birthday">
										<select class="year form-control">
					       					<option>2019</option>
					      				</select>
					      				<span>
					      					年
					      				</span>
				      				</div>
				      				<div class="birthday">
										<select class="month form-control">
					       					<option>1</option>
					      				</select>
					      				<span>
					      					月
					      				</span>
				      				</div>
				      				<div class="birthday">
										<select class="day form-control">
					       					<option>1</option>
					      				</select>
					      				<span>
					      					日
					      				</span>
				      				</div>
				      				
								</div>
							</div>
						</div>
						<button class="btn layout-right-l1-down2" >保存</button>
						<button class="btn layout-right-l1-down3" >取消</button>
					</div>
				</li>
				<li>
					<div class="layout-right-l2-top">
					<input type="hidden" value="密码修改成功，请重新登录" id="t1"/>
						<p>修改密码</p>
					</div>
					<div class="layout-right-l2-middle1">
						<input class="form-control" type="password" placeholder="原密码" name="" value="" />
					</div>
					<div class="layout-right-l2-middle2">
						<input class="form-control" type="password" placeholder="新密码" name="" value="" />
					</div>
					<div class="layout-right-l2-down">
						<p>长度为8～14个字符</p>
						<p>支持数字、大小写字母和标点符号,不能有空格</p>
					</div>
					<button disabled class="btn layout-right-l2-down2" >确认修改</button>
				</li>
				<li>
					<div class="layout-right-l2-top">
					<input type="hidden" value="修改成功" id="t2"/>
						<p>修改手机号码</p>
					</div>
					<div class="layout-right-l2-middle1">
						<input class="form-control" type="text" placeholder="原手机号码" name="" value="" />
					</div>
					<div class="layout-right-l2-middle2">
						<input class="form-control" type="text" placeholder="新手机号码" name="" value="" />
					</div>
					<div class="layout-right-l2-down">
						<p>请输入中国大陆手机号</p>
					</div>
					<button disabled class="btn layout-right-l2-down2" >确认修改</button>
				</li>
				<li>
					<div class="layout-right-l2-top">
					<input type="hidden" value="修改成功" id="t3"/>
						<p>修改登陆邮箱</p>
					</div>
					<div class="layout-right-l2-middle1">
						<input class="form-control" type="text" placeholder="原邮箱" name="" value="" />
					</div>
					<div class="layout-right-l2-middle2">
						<input class="form-control" type="text" placeholder="新邮箱" name="" value="" />
					</div>
					<div class="layout-right-l2-down">
						<p>支持各种邮箱</p>
					</div>
					<button disabled class="btn layout-right-l2-down2" >确认修改</button>
				</li>
				<li>
					<div class="layout-right5-top">
					<input type="hidden" value="修改成功" id="t4"/>
						<p class="layout-right5-top-p1">实名认证</p>
						<p class="layout-right5-top-p2">请确认是您本人，并填写真实信息</p>
					</div>
					<div class="layout-right5-middle1">
						<span>真实姓名</span>
						<input class="form-control" type="text" placeholder="请输入真实姓名 " name="" value="" />
					</div>
					<div class="layout-right5-middle2">
						<span>身份证号</span>
						<input class="form-control" type="text" placeholder="请输入本人身份证号" name="" value="" />
					</div>
					<button disabled class="btn layout-right-l2-down2" >确定</button>
				</li>
				<li>
					
				</li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
</section>

<div style="height: 60px;width: 100%;background: #E5E5E5;"></div>

</body>
</html>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/center.js"></script>
<script type="text/javascript" src="js/center2.js"></script>
<script type="text/javascript" src="js/linkage.js"></script>
<script type="text/javascript" src="js/disabled.js"></script>
<script type="text/javascript">
		function show(obj){
			var fr =new  FileReader();
			var f = obj.files[0];
			fr.readAsDataURL(f);
			fr.onload=function(e){
				var content = e.target.result;
				//console.log(content);
				//预览
				document.getElementById("img").src=content;
				//将编码后的字符串（长）放入隐藏域
				document.getElementById("content").value=content;
			}
		}
</script>