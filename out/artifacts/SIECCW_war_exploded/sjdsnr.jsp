<%--
  Created by IntelliJ IDEA.
  User: lisiq
  Date: 2018/4/30
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
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
    <jsp:useBean id="sjdsnr1" type="Javabean.Sjds" scope="request"/>
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
            <font class="picture_word">在这里，您可以查看大赛章程，通知！

        </div>
    </div>
</div>
<div class="bottombg">
    <div class="bottom_box" >
        <font style="font-family: '幼圆' ;color: blue;size: 15px"><jsp:getProperty property="sjds_topic" name="sjdsnr1"/><br></font>
        <font style="font-family: '幼圆'; color: blue">作者：<jsp:getProperty property="sjds_edit" name="sjdsnr1"/><br>
            时间：<jsp:getProperty property="sjds_date"  name="sjdsnr1"/></font>
        <hr style="height:5px;border:none;border-top:2px ridge #333333;">
        <font style="color: blue"><jsp:getProperty property="sjds_main" name="sjdsnr1"/></font>
        <hr style="height:5px;border:none;border-top:2px ridge #333333;">
        <%String lj1 = request.getParameter("lj");
            int lj2 = 0;
            if(lj1 != null){
                lj2 = Integer.parseInt(lj1);}
            System.out.print(lj2 == 1);
            if(lj2 == 1)
            {%>
        <a href="index" style="color:blue; font-family:微软雅黑; font-size:100%" >返回</a><% }
        if(lj2 == 2)
        {
    %>

        <a href="sjds" style="color:blue; font-family:微软雅黑; font-size:100%" >返回</a>   <%}
        if(lj2 != 1 && lj2 != 2)
        { RequestDispatcher dispather	= request.getRequestDispatcher("index");
            dispather.forward(request,response ); }
    %>
    </div>
    <div class="bottom">版权所有 李思奇 Copyright© 2017-2018 All Rights Reserved <br>
        地址:黑龙江省绥化市北林区黄河南路18号绥化学院信息工程学院　　邮箱：<a class="bottomlj" href="mailto:914545985@qq.com">914545985@qq.com</a>    <a class="bottomlj" href="http://www.miitbeian.gov.cn">黑ICP备17003313号-1</a>
    </div>

</div></body>

</html>
