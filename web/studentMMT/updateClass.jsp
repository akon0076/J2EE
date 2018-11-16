<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-11-07
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="updateClass" method="POST">
    <s:textfield style="display: none" name="classes.id"></s:textfield>
    <s:textfield label="ID" name="classes.number"></s:textfield>
    <s:textfield label="编号" name="classes.code"></s:textfield>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
</html>
