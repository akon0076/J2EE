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
<div class="addStyle"><span style="cursor: pointer"><a href="../studentMMT/addClass.jsp">新增</a></span></div>
<table cellpadding="10" cellspacing="0" border="1" class="tbStyle">
    <thead>
    <tr class="tdStyle">
        <td>ID</td>
        <td>编号</td>
        <td align="center">操作</td>
    </tr>
    </thead>

    <tbody>
    <s:iterator value="#request.clazz">
        <tr>
            <td>${number}</td>
            <td>${code}</td>
            <td align="center">
                <span onclick="updateClass(${id})" class="optionStyle">编辑</span>
                <span onclick="removeClass(${id})" class="optionStyle">删除</span>
            </td>
        </tr>
    </s:iterator>
    </tbody>

</table>
<div class="operationDIV">
    <form action="searchStudent" method="POST" class="formStyle">
        <div class="itemStyle">
            <p>属性:</p>
        </div>
        <div class="itemStyle">
            <p>班级:</p>
        </div>
        <div class="itemStyle">
            <s:select name="stuClasses" class="classSelectStyle" headerKey="请选择" list="#request.map" listKey="value" listValue="value"></s:select>
        </div>
        <div class="itemStyle">
            <select id="condition" name="condition" class="selectStyle">
                <option value="number" selected="selected">学号</option>
                <option value="name">姓名</option>
            </select>
        </div>

        <div class="itemStyle">
            <select id="type" name="type" class="selectStyle">
                <option value="contain" selected="selected">包含</option>
                <option value="equal">相等</option>
            </select>
        </div>

        <div class="itemStyle">
            <input id="string" name="string" class="inputStyle" />
        </div>
        <div class="itemStyle">
            <input type="submit" class="buttonStyle"></input>
        </div>
        <div class="itemStyle">
            <span style="cursor: pointer;display: block; padding: 20px 0px 0px 10px"><a href="toAddStudent.action">新增</a></span>
        </div>
    </form>

</div>
<table cellpadding="10" cellspacing="0" border="1" class="tbStyle">
    <thead>
    <tr class="tdStyle">
   		<td>班级</td>
   		<td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td align="center">操作</td>
    </tr>
    </thead>

    <tbody>
    <s:iterator value="#request.students">
        <tr>
        	<td>${classes}</td>
        	<td>${number}</td>
            <td>${name}</td>
            <td>${age}</td>
      		<td align="center">
            	<span onclick="updateStudent(${id})" class="optionStyle">编辑</span>
            	<span onclick="removeStudent(${id})" class="optionStyle">删除</span>
            </td>
        </tr>
    </s:iterator>
    </tbody>

</table>
<style>
    .addStyle {
        margin: auto;
        text-align: center;
        color: blue;
    }
	.optionStyle {;
		padding: 0px 10px;
		cursor: pointer;
		color: blue;
	}
    .inputStyle {
        margin: 8px 0px 0px 10px;
        height: 25px;
        width: 100%;
    }
    .formStyle {
        width: 100%;
        height: 100%;
        min-width: 650px;
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
    .classSelectStyle {
        cursor: pointer;
        width: 80px;
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
        min-width: 650px;
        width: 33%;
        margin: auto;
        margin-top: 5%;
        height: 30px;
    }
    .tbStyle {
        margin-top: 20px;
        min-width: 665px;
        clear: both;
        width: 40%;
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
<script type="text/javascript">
function updateClass(id) {
    let actionURL = "getSingleClass?id=" + id;
    window.location.href = actionURL;
}
function updateStudent(id) {
    let actionURL = "getSingleStudent?id=" + id;
    window.location.href = actionURL;
}
function removeClass(id) {
    let actionURL = "removeClass?id=" + id;
    window.location.href = actionURL;
}
function removeStudent(id) {
    let actionURL = "removeStudent?id=" + id;
    window.location.href = actionURL;
}
function downLoad() {
	filename = prompt("请输入保存的文件名!" + "在此输入文件名");
	condition = document.getElementById("condition").value;
	type = document.getElementById("type").value;
	string = document.getElementById("string").value;
	let actionURL = "simpledownload2?filename=" + filename + "&condition=" + condition + "&type=" + type + "&string=" + string;
	console.log(actionURL);
	window.location.href=actionURL;
}
</script>
</body>
</html>