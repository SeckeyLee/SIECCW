<%@ page language="java" import="java.util.*,Javabean.TjzpBean" pageEncoding="utf-8"%>

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
<jsp:useBean id="pf1" type="Javabean.TjzpBean" scope="request"/>

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
						<h2 class="title">评分</h2>
						<p class="title-description">
							在这里评分！
						</p>
					</header>
					<hr>
				</section>
		
				<table class="table mb-15">
					<thead>
						<tr>
						
							<th>比赛</th>
							<th>姓名</th>
							
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

				<jsp:getProperty property="result" name="pf1"/>
					</tbody>
				</table>
				
			
			
			
			
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
