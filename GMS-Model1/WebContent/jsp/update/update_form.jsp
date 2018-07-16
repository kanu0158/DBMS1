<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호변경</title>
</head>
<body>
	<div id="user-login-layout">
	<h3>비밀번호변경</h3>
	<form action="update_result.jsp">
	ID : <input type="text" name="USER-ID"></input><br>
	PASS : <input type="text" name="USER-PASS"></input><br>
	NEW_PASS : <input type="text" name="NEW-PASS"></input>
	<input type="submit" name="submit" value="전송"></input>
	</form>
	</div>
</body>
</html>
