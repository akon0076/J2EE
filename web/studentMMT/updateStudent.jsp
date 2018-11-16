<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-11-08
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="updateStudent" method="POST">
    <s:textfield style="display: none" name="student.id"></s:textfield>
    <s:select label="班级" name="student.classes" class="selectStyle" list="#request.map" listKey="value" listValue="value"></s:select>
    <s:textfield label="学号" name="student.number"></s:textfield>
    <s:textfield label="姓名" name="student.name"></s:textfield>
    <s:textfield label="年龄" name="student.age"></s:textfield>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
