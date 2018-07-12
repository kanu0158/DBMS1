<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<!-- userid, ssn (800101-1),name,roll,teamid,password  -->
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<div id="user-login-layout">
	<h1>회원가입</h1>
	<form action="joinResult.jsp">
		ID: <input type="text" name="USER-ID" /><br>
		PASS: <input type="text" name="USER-PASS" /><br>
		NAME: <input type="text" name="USER-NAME" /><br>
		SSN: <input type="text" name="USER-SSN" /><br>
		<input type="submit" name="SUBMIT" value="전송" />
	</form>
	</div>
	
</body>
</html>