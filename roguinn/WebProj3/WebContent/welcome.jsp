<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WELCOME</title>
</head>
<body>
名前とパスワードを入力してください。

<s:form method="post" action="LoginAction">					<!--post型送信のフォームを設定し、loginactionをactionに設定  -->
	<s:textfield name="username" label="ユーザー名:" />		<!--textfield型に設定し、name属性をusernameに設定する  -->
	<s:password name="password" label="パスワード:" />		<!--入力をpassword型にし、name属性をpasswordに設定する  -->
	<s:submit value="送信" />								<!--submitの文字を送信に設定する  -->
</s:form>

</body>
</html>