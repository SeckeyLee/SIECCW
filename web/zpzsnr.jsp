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
<%@ page contentType="text/html;charset=UTF-8" language="java" import="Javabean.ZpzsBean" %>
<html>
<head>
    <jsp:useBean id="zpzsnr1" type="Javabean.ZpzsBean" scope="request"/>
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
    <a class="nava" href="sjds">设计大赛</a>
    <a class="navajh" href="zpzs">作品展示</a>
    <a class="nava" href="zpjl.jsp">作品交流</a>
    <a class="nava" href="login.jsp">用户登录</a>
    <a class="nava" href="javascript:ts()">客户端</a>

</div>
<div class="middlebg">
    <div class="picture_banner"
         style="background-image: url(images/banner.jpg);background-size: 100%">
        <div class="picture_intr">
            <center><font class="picture_topic">作品展示</font></center>
            <hr class="picture_hr">
            <font class="picture_word">在这里，您可以看到优秀作品！
            </font>
        </div>
    </div>
</div>
<div class="bottombg">
    <div class="bottom_box" >
        <ul>
            <li> 院系：<jsp:getProperty name="zpzsnr1" property="zz_school"/></li>
            <li>班级：<jsp:getProperty name="zpzsnr1" property="zz_class"/></li>
            <li>作者：<jsp:getProperty name="zpzsnr1" property="zz_name"/></li>
            <li>学号：<jsp:getProperty name="zpzsnr1" property="zz_num"/></li>
            <li>类别：<jsp:getProperty name="zpzsnr1" property="zz_zclass"/></li>
            <li>作品名称：<jsp:getProperty name="zpzsnr1" property="zz_zname"/></li>
            <li>分数：<jsp:getProperty name="zpzsnr1" property="zz_grade"/></li>
            <li> 名次：<jsp:getProperty name="zpzsnr1" property="zz_no"/></li>
            <li>比赛：<jsp:getProperty name="zpzsnr1" property="zz_type"/></li>
            <li> 介绍：<textarea><jsp:getProperty name="zpzsnr1" property="zz_introduce"/></textarea></li>
            <li>下载：<a href="<jsp:getProperty name="zpzsnr1" property="zz_baidu"/>"><jsp:getProperty name="zpzsnr1" property="zz_baidu"/></a></li>
        
</ul>
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

        <a href="zpzs" style="color:blue; font-family:微软雅黑; font-size:100%" >返回</a>   <%}
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
