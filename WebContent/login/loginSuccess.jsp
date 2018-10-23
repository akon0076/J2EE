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
		<a href="${pageContext.request.contextPath }/emp.action">进入员工查询界面</a>
	</div>
	<div>
		<a href="../fileUpload/fileUpload.jsp">进入文件上传界面</a>
	</div>
	<div>
		<a href="../fileUpload/download.jsp">进入文件下载界面</a>
	</div>
	<div>
		<a href="../fileUpload/download.jsp">测试查询结果</a>
	</div>
</body>
</html>

