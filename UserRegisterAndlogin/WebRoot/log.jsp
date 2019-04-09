<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  <style type="text/css"> 
  		.center {
  			margin:20px auto; 
  			align-self:center;
  		}
  		form{
  			display:flex;
  			flex-direction:column;
  		}
  		h1, h2, h3{
  			margin:20px auto; 
  			text-align:center;
  		}
  </style>
  <body>
    <h1>登录</h1>
    <form method="post" action="Log.do">
    	<div class="center">账号：<input type="text" name="account" /><br/></div>
    	<div class="center">密码：<input type="password" name="password" /><br/></div>
    	<div class="center"><input type="submit" value="登录"/><br/></div>
    </form>
    <h3>${prompt }</h3>
  </body>
</html>
