<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册成功</title>
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
    <p>恭喜您注册成功</p>
    <p>请记住您的账号是：${account }</p>
    <form method="post" action="Skip.do">
    	<div class="center"><input type="submit" value="点击跳转到登录页面"/><br/></div>
    </form>
  </body>
</html>
