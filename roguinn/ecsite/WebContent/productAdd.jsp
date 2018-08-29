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
<s:form action="ProductAddCompleteAction">
商品名<input type="text" name="name"/>
価格<input type="text" name="price"/>
在庫数<input type="text" name="stock"/>
<s:submit value="商品登録"/>
</s:form>

<a href='<s:url action="KanriAction" />'>管理画面へ戻る</a>
</body>
</html>