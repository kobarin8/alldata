<%@ page language="java" contentType="text/html; charset=UTF-8"

pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Home画面</title>
<style type="text/css">
.hatugen{
font-size:30px;
color:red;
}


</style>
</head>
<body>
<h2>この発言を登録しますか？</h2>
<div class="hatugen">
<s:property value="session.hatugenKey"/><br><br>
</div>
<s:form action="toukou">
<s:submit value="完了" />
</s:form>

</body>
</html>