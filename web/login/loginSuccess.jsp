<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>用户登录成功页面</title>
</head>
<body>
	<p align="center">
		登录成功！
		您的用户名是<%=request.getAttribute("user.username")%>
	</p>
	<div>
		<a href="${pageContext.request.contextPath }/emp.action">进入学生查询界面(实验1、2、3)</a>
	</div>
	<div>
		<a href="../fileUpload/fileUpload.jsp">进入文件上传界面(文件上传)</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/studentList.action">班级学生信息管理功能</a>
	</div>
</body>
</html>

