<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册账号</title>
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
  	<h1>欢迎注册账号</h1>
    <form method="post" action="Register.do">
    	<div class="center">用户名：<input type="text" name="username" value="${username }"/><br/></div>
    	<div class="center">性别：<input  type="text" name="sex" value="${sex }"/><br/></div>
    	<div class="center">密码：<input type="password" name="password" value="${password }"/><br/></div>
    	<div class="center"><input type="submit" value="注册"/><br/></div>
    </form>
    <h3>${prompt }</h3>
  </body>
</html>
