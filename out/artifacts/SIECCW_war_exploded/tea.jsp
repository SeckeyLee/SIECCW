<%@ page language="java" import="java.util.*,Javabean.InfoBean" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>SIECCW后台管理系统</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">

<link rel="stylesheet"  href="css/style1.css" />
<script src="js/jquery.js"></script>
<script src="js/plug-ins/customScrollbar.min.js"></script>
<script src="js/plug-ins/echarts.min.js"></script>
<script src="js/plug-ins/layerUi/layer.js"></script>
<script src="js/plug-ins/pagination.js"></script>
<script src="js/public.js"></script>
  </head>
 
  <body>
<jsp:useBean id="info1" type="Javabean.InfoBean" scope="request"/>

   <div class="main-wrap">
	<div class="side-nav">
		<div class="side-logo">
			<div class="logo">
			
				SIECCW
				
				
			</div>
		</div>
		
		<nav class="side-menu content mCustomScrollbar" data-mcs-theme="minimal-dark">
			
			<ul>
				<li>
					<dl>
						<dt>
						个人资料
						</dt>
						<dd>
							<a href="tea">查看个人资料</a>
						</dd>
						<dd>
							<a href="retea.jsp">修改个人资料</a>
						</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							评分
						</dt>
						<dd>
							<a href="pf">评分</a>
						</dd>
						
						
					</dl>
				</li>
				
			</ul>
		</nav>
		<footer class="side-footer">©版权所有</footer>
	</div>
	<div class="content-wrap">
		<header class="top-hd">
			
			<div class="hd-rt">
				<ul>
					<li>
						<a href="zpjl" target="_blank"><i class="icon-home"></i>作品交流</a>
					</li>
					
					<li>
						<a><i class="icon-user"></i>评委教师:<%=session.getAttribute("name") %></a>
					</li>
					
					<li>
						<a href="off"><i class="icon-signout"></i>安全退出</a>
					</li>
				</ul>
			</div>
		</header>
		<main class="main-cont content mCustomScrollbar">
			<!--开始::内容-->
			<section class="page-hd">
					<header>
						<h2 class="title">个人资料</h2>
						<p class="title-description">
							在这里查看个人资料
						</p>
					</header>
					<hr>
				</section>
			
					<center><table border=0><tr><td style="height:50px;width:200px;">账号：<jsp:getProperty name="info1" property="num"/></td></tr>
				
			
			
					<tr><td style="height:50px;">姓名：<jsp:getProperty name="info1" property="name"/></td></tr>
					
				
			
					<tr><td style="height:50px;">类型：评委教师</div></td></tr>
							
				
		
		
					
				
		
					<tr><td style="height:50px;">电话号码：<jsp:getProperty name="info1" property="phone"/></td></tr>
					
			
				
				
					</table></center>
					</div>
				</div>
				
			
			
			
			<!--开始::结束-->
		</main>
		<footer class="btm-ft">
			<p class="clear">
				<span class="fl">©Copyright 2017</span>
				
			</p>
		</footer>
	</div>
</div>
</body>
</html>
