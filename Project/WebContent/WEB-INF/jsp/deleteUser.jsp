<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>
<body>
	<div class="container">
		<form action="DeleteUserServlet" method="post">
			<header>
				<div>${loginUser.name}さん&emsp;<a href="LogoutServlet">ログアウト</a></div>
			</header>
			<div class="title">
				<p class="text-center">ユーザ削除確認</p>
			</div>
			<input type="hidden" name="loginId" value="${loginId}">
			ログインID：${loginId}<br>
			を本当に削除してよろしいでしょうか。<br>
			<br>
			<br>
			<table class="text-center">
				<tr>
					<td><button class="submit" type = "submit" name="result" value="0">キャンセル</button></td>
					<td><button class="submit" type = "submit" name="result" value="1">OK</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>