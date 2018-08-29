<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー管理画面</title>

<style type="text/css">
table {
text-align:center;
margin:0 auto;

}
</style>
</head>
<body>

<table border="1">

<tr>
<th>ID</th>
<th>PASSWORD</th>
<th>NAME</th>
<th>SUBSCRIBE</th>
</tr>

<s:iterator value="UserList">
<tr>
<td><s:property value="loginId" /></td>
<td><s:property value="loginPass" /></td>
<td><s:property value="userName" /></td>
<td><s:property value="insertDate" /></td>
</tr>
</s:iterator>

</table>

</body>
</html>