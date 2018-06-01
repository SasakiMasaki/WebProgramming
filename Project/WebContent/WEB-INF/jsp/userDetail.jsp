<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報詳細参照</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>
<body>
	<div class="container">
		<form>
			<header>
				<div>${loginUser.name}さん&emsp;<a href="LogoutServlet">ログアウト</a></div>
			</header>
			<div class="title">
				<p class="text-center">ユーザ情報詳細参照</p>
			</div>
			<table class="b">
				<tr>
					<th>ログインID</th>
					<td>${user.loginId}</td>
				<tr>
					<th>ユーザ名</th>
					<td>${user.name}</td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td>${user.birthDate}</td>
				<tr>
					<th>登録日時</th>
					<td>${user.createDate}</td>
				<tr>
					<th>更新日時</th>
					<td>${user.updateDate}</td>
			</table>
			<br>
			<br>
			<p class="text-left"><a href = "UserListServlet">戻る</a></p>
		</form>
	</div>
</body>
</html>