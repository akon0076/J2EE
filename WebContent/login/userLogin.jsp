<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>用户登录页面</title>
</head>
<body>
	<h1 align="center">请先登录</h1>
	<div align="center">
	 <form name="form1" action="userlogin.action" method="post">
		账号：<input type="text" name="user.username">
		<br> 
		密码：<input style="margin-top: 5px" type="password" name="user.password">
		<br> 
		<input style="margin-left: 173px; margin-top: 20px" type="submit" value="登录">
	 </form>
	</div>
</body>
</html>

