<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>学生信息查询系统</title>
    <link rel="shortcut icon" href="#" />
    <meta charset="utf-8">
</head>

<body>
<a style="cursor:pointer" href="${pageContext.request.contextPath }/exit.action" title="退出">退出</a>
<div class="operationDIV">
    <form action="search" method="POST" class="formStyle">
        <div class="itemStyle">
            <p>属性:</p>
        </div>
        <div class="itemStyle">
            <select name="condition" class="selectStyle">
            <option value="number" selected="selected">学号</option>
            <option value="name">姓名</option>
        </select>
        </div>

        <div class="itemStyle">
            <select name="type" class="selectStyle">
                <option value="contain" selected="selected">包含</option>
                <option value="equal">相等</option>
            </select>
        </div>

        <div class="itemStyle">
            <input name="string" class="inputStyle" />
        </div>
        <div class="itemStyle">
            <input type="submit" class="buttonStyle"></input>
        </div>
        <div class="itemStyle">
            <input style="width: 115px;height: 30px; font-size: 18px; margin-left: 15px; margin-top: 5px; background: lightgray; cursor:pointer;" value="下载查询结果"></input>
        </div>
    </form>

</div>
<table cellpadding="10" cellspacing="0" border="1" class="tbStyle">
    <thead>
    <tr class="tdStyle">
        <td>姓名</td>
        <td>学号</td>
        <td>年龄</td>
    </tr>
    </thead>

    <tbody>
    <s:iterator value="#request.emps">
        <tr>
            <td>${name}</td>
            <td>${number}</td>
            <td>${age}</td>
        </tr>
    </s:iterator>
    </tbody>

</table>
<style>
    .inputStyle {
        margin: 8px 0px 0px 10px;
        height: 25px;
        width: 100%;
    }
    .formStyle {
        width: 100%;
        height: 100%;
    }
    .itemStyle {
        float: left;
        line-height: 0px;
    }
    .selectStyle {
    	cursor: pointer;
        width: 60px;
        height: 30px;
        font-size: 18px;
        margin-left: 10px;
        margin-top: 5px;
    }
    .buttonStyle {
        width: 60px;
        height: 30px;
        font-size: 18px;
        margin-left: 15px;
        margin-top: 5px;
        cursor: pointer;
    }
    .operationDIV {
        width: 40%;
        margin: auto;
        margin-top: 15%;
        height: 30px;
    }
    .tbStyle {
        clear: both;
        width: 50%;
        margin: auto;
    }
    .tdStyle {
        width: 200px;
        min-width: 150px;
        background: black;
        color: white;
    }
    body {
        font-size: 20px;
    }
</style>
</body>
</html>