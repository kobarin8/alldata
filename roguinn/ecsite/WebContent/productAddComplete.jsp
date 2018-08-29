<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
接続ok!
<s:property value="session.namekey" escape="false" />
<s:property value="session.pricekey" escape="false" />
<s:property value="session.stockkey" escape="false" />

<a href='<s:url action="ProductAddAction" />'>登録画面へ戻る</a>
</body>
</html>