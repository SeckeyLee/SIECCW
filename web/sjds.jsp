<%--
  Created by IntelliJ IDEA.
  User: lisiq
  Date: 2018/4/16
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="Javabean.Sjds" %>
<html>
<head>
    <jsp:useBean id="sjds1" type="Javabean.Sjds" scope="request"/>
    <title>SIECCW带你看未来</title>
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="shortcut icon" href="images/logo.ico"/><link rel="Bookmark" href="images/logo.ico"/>
    <script language="text/javascript">
        window.onresize = function(){
            var font1 = document.getElementById("topic-font-cn");
            font1.style["z-index"] = 1;
            var font2 = document.getElementById("topic-font-en");
            font2.style["z-index"] = 1;
        }'
    </script>
</head>
<body>
<div class="top-banner"></div>
<div class="main-banner">
    <img src="images/logo.png" class="logo">
    <div class="topic">
        <div class="topic-font-cn" id="topic-font-cn">
            信息工程学院计算机大赛网站
        </div>
        <div class="topic-font-en" id="topic-font-en">
            School of Information Engineering Computer Competition Website
        </div>
    </div>
    <div class="search"></div>
    <div class="search">
        <input type="text" name="search" placeholder="搜索" class="search-text" />
        <input type="submit" class="search-submit" value=""/>
    </div>
    <div class="search"></div>
</div>
<div class="graybanner"></div>
<div class="navigation-bar">
    <a class="nava" href="index">网站首页</a>
    <a class="navajh" href="sjds">设计大赛</a>
    <a class="nava" href="zpzs">作品展示</a>
    <a class="nava" href="zpjl.jsp">作品交流</a>
    <a class="nava" href="login.jsp">用户登录</a>
    <a class="nava" href="javascript:ts()">客户端</a>

</div>
<div class="middlebg">
    <div class="picture_banner"
         style="background-image: url(images/banner.jpg);background-size: 100%">
        <div class="picture_intr">
            <center><font class="picture_topic">设计大赛</font></center>
            <hr class="picture_hr">
            <font class="picture_word">在这里查看大赛信息！
            </font>
        </div>
    </div>
</div>
<div class="bottombg">
    <div class="bottom_box" >

        <ul style="color: blue">
          <jsp:getProperty name="sjds1" property="result"/>

        </ul>
      <hr style="height:5px;border:none;border-top:2px ridge #333333;">
        <br>
        <form action="sjds" style="float:left">
            <font color="#00f" face="幼圆" style="font-size:150%">第<jsp:getProperty property="x" name="sjds1"/> 页,共<jsp:getProperty property="pall" name="sjds1"/>页。跳转到第<input style="width:50px; height:22px;border:double blue "type="number" name="page"  min="1" max='<jsp:getProperty property="pall" name="sjds1"/>' required>页</font>
            <input type="submit" value="提交" style="width:50px; height:22px;border: solid #00f;color:#fff;background:#00f ">
        </form>

        <%Sjds Dia = (Sjds)request.getAttribute("sjds1"); %>
        <form action="sjds" style="float:right; ">
            <input type='hidden' value="<%=Dia.getX()+1 %>" name="page" />
            <input type='submit' value='下一页' style="width:50px; height:22px;border:solid #00f ;color:#fff;background:#00f">
        </form>

        <form action="sjds" style="float:right">
            <input type='hidden' value="<%=Dia.getX()-1 %>" />
            <input type='submit' value="上一页" style="width:50px; height:22px;border:solid #00f ;color:#fff;background:#00f">
        </form>
    </div>
    <div class="bottom">版权所有 李思奇 Copyright© 2017-2018 All Rights Reserved <br>
        地址:黑龙江省绥化市北林区黄河南路18号绥化学院信息工程学院　　邮箱：<a class="bottomlj" href="mailto:914545985@qq.com">914545985@qq.com</a>    <a class="bottomlj" href="http://www.miitbeian.gov.cn">黑ICP备17003313号-1</a>
    </div>

</div></body>

</html>
