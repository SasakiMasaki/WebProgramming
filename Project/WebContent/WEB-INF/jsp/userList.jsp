<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<form action="http://localhost:8080/UserManagement/userList.html">
			<header>
				<div>ユーザ名さん&emsp;<a href="http://localhost:8080/UserManagement/login.html">ログアウト</a></div>
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
					<td colspan = "3"><input type="text" name="ID"></td>
					<th></th>
				</tr>
				<tr>
					<th>ユーザ名</th>
					<td colspan = "3"><input type="text" name="name"></td>
					<th></th>
				</tr>
				<tr>
					<th>生年月日</th>
					<td><input type="date" name="birthday"></td>
					<td>～</td>
					<td><input type="date" name="birthday"></td>
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
				<tr>
					<td>id0001</td>
					<td>田中太郎</td>
					<td>1989年04月26日</td>
					<td>
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/userDetail.html'" class="btn btn-primary btn-sm" name="detail" value="詳細">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/updateUser.html'" class="btn btn-success btn-sm" name="update" value="更新">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/deleteUser.html'" class="btn btn-danger btn-sm" name="delete" value="削除">
					</td>
				</tr>
				<tr>
					<td>id0001</td>
					<td>田中太郎</td>
					<td>1989年04月26日</td>
					<td>
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/userDetail.html'" class="btn btn-primary btn-sm" name="detail" value="詳細">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/updateUser.html'" class="btn btn-success btn-sm" name="update" value="更新">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/deleteUser.html'" class="btn btn-danger btn-sm" name="delete" value="削除">
					</td>
				</tr>
				<tr>
					<td>id0001</td>
					<td>田中太郎</td>
					<td>1989年04月26日</td>
					<td>
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/userDetail.html'" class="btn btn-primary btn-sm" name="detail" value="詳細">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/updateUser.html'" class="btn btn-success btn-sm" name="update" value="更新">
						<input type="button" onclick="location.href='http://localhost:8080/UserManagement/deleteUser.html'" class="btn btn-danger btn-sm" name="delete" value="削除">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>