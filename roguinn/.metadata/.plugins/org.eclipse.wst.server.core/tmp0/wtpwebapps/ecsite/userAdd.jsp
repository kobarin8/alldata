<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="UserAddCompleteAction">
ID	<input type="text" name="id"/>
PASS<input type="text" name="pass"/>
NAME<input type="text" name="name"/>
<s:submit value="ユーザー登録"/>
</s:form>
</body>
</html>