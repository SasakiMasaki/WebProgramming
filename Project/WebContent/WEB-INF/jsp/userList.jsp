<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/origin/common.css">
</head>
<body>
	<div class="container">
		<form action="UserListServlet" method="post">
			<header>
				<div>${loginUser.name}さん&emsp;<a href="http://localhost:8080/UserManagement/login.html">ログアウト</a></div>
			</header>
			<div class="title">
				<p class="text-center"><a>ユーザ一覧</a></p>
			</div>
			<p class="text-right">
				<a href="http://localhost:8080/UserManagement/addUser.html">新規登録</a>
			</p>
			<table class="a">
				<tr>
					<th>ログインID</th>
					<td colspan = "3"><input type="text" name="id"></td>
					<th></th>
				</tr>
				<tr>
					<th>ユーザ名</th>
					<td colspan = "3"><input type="text" name="name"></td>
					<th></th>
				</tr>
				<tr>
					<th>生年月日</th>
					<td><input type="date" name="firstDate"></td>
					<td>～</td>
					<td><input type="date" name="lastDate"></td>
					<th></th>
				</tr>
			</table>
			<div class="text-right">
				<input class="submit" type="submit" name="search" value="検索"><br>
			</div>
			<table class="table">
				<thead class="thead-light">
					<tr>
						<th>ログインID</th>
						<th>ユーザ名</th>
						<th>生年月日</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.loginId}</td>
						<td>${user.name}</td>
						<td>${user.birthDate}</td>
						<td>
							<button type="button" onclick="location.href='UserListServlet'" class="btn btn-primary btn-sm" name="detail" value="${user.loginId}">詳細</button>
							<button type="button" onclick="location.href='UserListServlet'" class="btn btn-success btn-sm" name="update" value="${user.loginId}">更新</button>
							<button type="button" onclick="location.href='UserListServlet'" class="btn btn-danger btn-sm" name="delete" value="${user.loginId}">削除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>