<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
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
<script>
function sendForm() {
	alert('sendForm 진입성공');
	return true;		
}
</script>
	<div id="user-login-layout">
	<h1>회원가입</h1>
	<form action="${context}/member.do" onsubmit="return sendForm()" method="get">
		ID: <input type="text" name="USER-ID" /><br>
		PASS: <input type="text" name="USER-PASS" /><br>
		NAME: <input type="text" name="USER-NAME" /><br>
		SSN: <input type="text" name="USER-SSN" /><br>
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
		<input type="submit" name="SUBMIT" value="전송" />
	</form>
	</div>
	
</body>
</html>