<%--
  Created by IntelliJ IDEA.
  User: lisiq
  Date: 2018/4/15
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,Javabean.*"%>

<html>
  <head>

      <jsp:useBean id="indexsjds" type="Javabean.Sjds" scope="request"/>
      <jsp:useBean id="indexzpzs" type="Javabean.ZpzsBean" scope="request"/>
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
  <script type="text/javascript">(function(){document.write(unescape('%3Cdiv id="bdcs"%3E%3C/div%3E'));var bdcs = document.createElement('script');bdcs.type = 'text/javascript';bdcs.async = true;bdcs.src = 'http://znsv.baidu.com/customer_search/api/js?sid=2124301406193223624' + '&plate_url=' + encodeURIComponent(window.location.href) + '&t=' + Math.ceil(new Date()/3600000);var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(bdcs, s);})();</script>
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
      <input type="text" name="search" placeholder="搜索" class="search-text" id="bdcsMain"/>
      <input type="submit" class="search-submit" value=""/>
    </div>
    <div class="search"></div>
  </div>
  <div class="graybanner"></div>
  <div class="navigation-bar">
    <a class="navajh" href="index">网站首页</a>
    <a class="nava" href="sjds">设计大赛</a>
    <a class="nava" href="zpzs">作品展示</a>
    <a class="nava" href="zpjl.jsp">作品交流</a>
    <a class="nava" href="login.jsp">用户登录</a>
    <a class="nava" href="javascript:ts()">客户端</a>
  </div>
  <div class="middlebg">
    <div class="picture_banner"
         style="background-image: url(images/banner.jpg);background-size: 100%">
      <div class="picture_intr">
        <center><font class="picture_topic">信息工程学院计算机大赛</font></center>
        <hr class="picture_hr">
          <font class="picture_word"><p>信息工程学院计算机大赛旨在鼓励学生学以致用，创新的能力。希望学生能自己开发网站，软件系统！</p></font>
      </div>
    </div>
  </div>
  <div class="bottombg">
    <div class="bottom_box">
        <div class="boxinbox">
            <center> <font style="font-family: '幼圆';font-size: 20px; ">设计大赛</font></center>
            <hr style="height:5px;border:none;border-top:2px ridge black;">
            <jsp:getProperty property="result" name="indexsjds"/>
        </div>
        <div class="boxinbox1">
            <center> <font style="font-family: '幼圆'; font-size: 20px;">作品展示</font></center>
            <hr style="height:5px;border:none;border-top:2px ridge black;">
            <jsp:getProperty name="indexzpzs" property="result"/>
        </div>
        <div class="boxinbox1">
            <center> <font style="font-family: '幼圆'; font-size: 20px;">作品交流</font></center>
            <hr style="height:5px;border:none;border-top:2px ridge black;">
            <a>本版块由于正在开发更加强大的功能，暂停使用。为您带来的不便尽请谅解！</a>
        </div>
        <div class="boxinbox1">
            <center> <font style="font-family: '幼圆';font-size: 20px; ">客户端下载</font></center>
            <hr style="height:5px;border:none;border-top:2px ridge black;">
            适用于安卓手机的客户端正在开发中
        </div>
  </div>
  <div class="bottom">版权所有 李思奇 Copyright© 2017-2018 All Rights Reserved <br>
    地址:黑龙江省绥化市北林区黄河南路18号绥化学院信息工程学院　　邮箱：<a class="bottomlj" href="mailto:914545985@qq.com">914545985@qq.com</a>    <a class="bottomlj" href="http://www.miitbeian.gov.cn">黑ICP备17003313号-1</a>
  </div>

  </div></body>

</html>
