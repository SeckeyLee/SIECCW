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
<jsp:useBean id="dsbm" type="Javabean.DsbmBean" scope="request"/>

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
							<a href="occ">查看个人资料</a>
						</dd>
						<dd>
							<a href="reocc.jsp">修改个人资料</a>
						</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							公告管理
						</dt>
						<dd>
							<a href="chaw">查询公告</a>
						</dd>
						<dd>
							<a href="zengw">增加公告</a>
						</dd>
						
						
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							大赛管理
						</dt>
						<dd>
							<a href="chadsinfo">查询大赛信息</a>
						</dd>
					<dd>
							<a href="zengdsinfo">增加大赛信息</a>
						</dd>
						<dd>
							<a href="dsbm">报名确认</a>
						</dd>
						<dd>
							<a href="dszpzs">作品展示</a>
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
						<a><i class="icon-user"></i>大赛组委会::<%=session.getAttribute("name") %></a>
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
						<h2 class="title">报名确认</h2>
						<p class="title-description">
							可以在这里确认报名！
						</p>
					</header>
					<hr>
				</section>
		
				<table class="table mb-15">
					<thead>
						<tr>
						
							<th>大赛名称</th>
							
							<th>报名者学号</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

				<jsp:getProperty property="result" name="dsbm"/>
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
