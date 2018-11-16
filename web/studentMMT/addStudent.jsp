<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="addStudent" method="POST">
    <s:select label="班级" name="student.classes" class="selectStyle" list="#request.map" listKey="value" listValue="value"></s:select>
    <s:textfield label="学号" name="student.number"></s:textfield>
    <s:textfield label="姓名" name="student.name"></s:textfield>
    <s:textfield label="年龄" name="student.age"></s:textfield>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
