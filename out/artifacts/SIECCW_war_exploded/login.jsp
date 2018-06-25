<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  function check(){
  var reg = /([a,t,o,]{1}[0-9]{5})|([0-9]{9})/;
  var zhanghao = document.getElementById("zh").value;
  var mima = document.getElementById("mm").value;
  
  if( zhanghao == ""){
  alert("账号不能为空");
  return false;
  }
  
  if( mima == ""){
  alert("密码不能为空");
  return false;
  }
  
  if(reg.test(zhanghao) == false){
  alert("您输入的格式有误，请检查后重新输入");
  return false;
  }
  }
  </script>
    <base href="<%=basePath%>">
    
    <title>比赛从这里开始！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" type="text/css" href="components/reset.css">
  <link rel="stylesheet" type="text/css" href="components/site.css">

  <link rel="stylesheet" type="text/css" href="components/container.css">
  <link rel="stylesheet" type="text/css" href="components/grid.css">
  <link rel="stylesheet" type="text/css" href="components/header.css">
  <link rel="stylesheet" type="text/css" href="components/image.css">
  <link rel="stylesheet" type="text/css" href="components/menu.css">

  <link rel="stylesheet" type="text/css" href="components/divider.css">
  <link rel="stylesheet" type="text/css" href="components/segment.css">
  <link rel="stylesheet" type="text/css" href="components/form.css">
  <link rel="stylesheet" type="text/css" href="components/input.css">
  <link rel="stylesheet" type="text/css" href="components/button.css">
  <link rel="stylesheet" type="text/css" href="components/list.css">
  <link rel="stylesheet" type="text/css" href="components/message.css">
  <link rel="stylesheet" type="text/css" href="components/icon.css">
   <script src="assets/library/jquery.min.js"></script>
  <script src="components/form.js"></script>
  <script src="components/transition.js"></script>

  <style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
  </style>

</head>
<body>

<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <div class="content">
        比赛从这里开始！
      </div>
    </h2>
    <form class="ui large form" action="hand" method="post" onsubmit="return check();">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="text" placeholder="输入您的账号" id="zh">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="输入您的密码" id="mm">
          </div>
          <br><br>
<div class="ui left icon input">
           
            <select name="identity">
					<Option value="administrator">管理员</option>
					<option value="Committee">大赛组委会</option>
					<option value="teacher">评委教师</option>
					<option value="student">学生</option>
				</select>
          </div>

        </div>
        <input class="ui fluid large teal submit button" type="submit" value="登录"><br>
       <a href="index"> <input class="ui fluid large teal submit button" type="button" value="返回"></a>
      </div>

      <div class="ui error message"></div>

    </form>
  </div>
</div>

</body>

</html>
