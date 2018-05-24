<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>
<body>
	<div class="container">
		<form action="LoginServlet" method="post" >
			<div class="title">
				<p class="text-center"><a>ログイン画面</a></p>
				<br>
			</div>
			<c:if test="${errMsg != null}">
				<div class="alert">
					${errMsg}
				</div>
			</c:if>
			<table class="b">
				<tr>
					<th>ログインID</th>
					<td><input type = "text" name = "loginId"></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type = "password" name = "password"></td>
				</tr>
			</table>
			<div class="text-center">
				<br>
				<br>
				<input class="submit" type="submit" value="ログイン"><br>
				<br>
			</div>
		</form>
	</div>
</body>
</html>


