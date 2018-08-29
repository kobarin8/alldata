<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>

<style type="text/css">

</style>

</head>
<body>


<div class="productlist">
<a href='<s:url action="ProductListAction" />'>商品管理画面</a>
<a href='<s:url action="ProductAddAction" />'>商品登録画面</a>
</div>
<div class="userlist">
<a href='<s:url action="UserListAction" />'>ユーザー管理画面</a>
<a href='<s:url action="UserAddAction" />'>ユーザー登録画面</a>
</div>





</body>
</html>