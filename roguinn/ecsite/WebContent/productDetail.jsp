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
<s:property value="session.ItemNameKey"/>
<s:property value="session.ItemPriceKey"/>
<s:property value="session.ItemStockKey"/>

<s:form action="DeleteItemAction">
<s:submit value="削除"/>
</s:form>

<s:form action="ProductUpdateAction">
<input type="text" name="ItemName"/>
<input type="text" name="ItemPrice"/>
<input type="text" name="ItemStock"/>
<s:submit value="更新項目へ"/>
</s:form>

<a href='<s:url action="ProductListAction" />'>商品管理画面</a>
</body>
</html>