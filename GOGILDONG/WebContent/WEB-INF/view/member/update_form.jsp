<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
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
	<form action="<%=ctx%>/member.do">
	ID : <input type="text" name="USER-ID"></input><br>
	PASS : <input type="text" name="USER-PASS"></input><br>
	NEW_PASS : <input type="text" name="NEW-PASS"></input>
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="page" value="update_result" />
	<input type="submit" name="submit" value="전송"></input>
	</form>
	</div>
</body>
</html>
