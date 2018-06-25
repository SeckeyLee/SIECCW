<%@ page language="java" import="java.util.*,Javabean.Tjzp" pageEncoding="utf-8"%>

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

<jsp:useBean id="tjzp1" type="Javabean.Tjzp" scope="request"/>

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
							<a href="stu">查看个人资料</a>
						</dd>
						<dd>
							<a href="restu.jsp">修改个人资料</a>
						</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt>
							报名
						</dt>
						<dd>
							<a href="xsbm">报名比赛</a>
						</dd>
						<dd>
							<a href="tjzp">提交作品</a>
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
						<a><i class="icon-user"></i>学生:<%=session.getAttribute("name") %></a>
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
						<h2 class="title">提交作品</h2>
						<p class="title-description">
							在这里提交作品
						</p>
					</header>
					<hr>
				</section>
			
					<form action="tjzprun" method="post" onsubmit="return check();" >
				<div class="form-group-col-2">
					<div class="form-label">比赛名称：</div>
					<div class="form-cont">
					<jsp:getProperty name="tjzp1" property="result"/>	
					</div>
				</div>
				<div class="form-group-col-2">
					<div class="form-label"  >作品名称：</div>
					<div class="form-cont">
						<input type="text"  class="form-control form-boxed" style="width:300px;" value="" name="zpname">
						
						<span class="word-aux">
					</div>
				</div>
				<div class="form-group-col-2">
					<div class="form-label">作品简介：</div>
					<div class="form-cont">
						<input type="text"  class="form-control form-boxed"style="width:300px;" value="" name="jj"  >
					</div>		
				</div>

						<div class="form-group-col-2">
							<div class="form-label">百度网盘地址（如有密码请在作品简介中说明）：</div>
							<div class="form-cont">
								<input type="text"  class="form-control form-boxed"style="width:300px;" value="" name="baidu"  >
							</div>
						</div>
				<div class="form-group-col-2">
					<div class="form-label"></div>
					<div class="form-cont">
					
							<input type="hidden" value="学生" name="type"/>
						<input type="submit" class="btn btn-primary" value="提交表单" />
					</form>
				
					</div>
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
