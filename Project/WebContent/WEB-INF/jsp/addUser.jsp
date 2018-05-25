<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ新規登録</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>
<body>
	<div class="container">
		<form action="AddUserServlet">
			<header>
			<div>${loginUser.name}さん&emsp;<a href="LogoutServlet">ログアウト</a></div>
			</header>
			<div class="title">
				<p class="text-center"><a>ユーザ新規登録</a></p>
			</div>
			<table class="b">
				<tr>
					<th><a>ログインID</a></th>
					<td><input type = "text" name = "id"></td>
				<tr>
					<th><a>パスワード</a></th>
					<td><input type = "password" name = "pass"></td>
				</tr>
				<tr>
					<th><a>パスワード(確認)</a></th>
					<td><input type = "password" name = "rePass"></td>
				<tr>
					<th><a>ユーザ名</a></th>
					<td><input type = "text" name = "name"></td>
				<tr>
					<th><a>生年月日</a></th>
					<td><input type = "date" name = "birthDate"></td>
			</table>
			<div class="text-center">
				<br>
				<br>
				<input class="submit" type="submit" name="regist" value="登録"><br>
				<br>
			</div>
			<p class="text-left"><a href = "UserListServlet">戻る</a></p>
		</form>
	</div>
</body>
</html>