<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloServlet</title>
</head>
<body>
<input type="button" value="HelloServlet" onClick="location.href='HelloServlet'">
<input type="button" value="WelcomeServlet" onClick="location.href='welcome.jsp'">
<input type="button" value="問い合わせ" onClick="location.href='inquiry.jsp'">
<input type="button" value="MySQLServlet" onClick="location.href='MySQLServlet'">
<br>

GET通信
<form method="get" action="TestServlet">
<input type="text" name="password">
<input type="password" name="username">
<input type="submit" value="送信">
</form>

Post通信
<form method="post" action="TestServlet">
<input type="text" name="password">
<input type="password" name="username">
<input type="submit" value="送信">
</form>




</body>
</html>