<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>사용자로그인</title>
<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<div id="user-login-layout">
	<h1>사용자로그인</h1>
	<form id="user-login-form" action="user_login_result.jsp">
	ID: <input type="TEXT" name="USER-ID" /><br>
	PASS: <input TYPE="TEXT" NAME="USER-PASS" /><br>
	<input type="submit" name="SUBMIT" value="전 송"/>
	</form>
	</div>
</body>
</html>