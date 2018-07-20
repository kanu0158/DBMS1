<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
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
	<form id="user-login-form" action="<%=ctx%>/member.do">
	ID: <input type="TEXT" name="USER-ID" /><br>
	PASS: <input TYPE="TEXT" NAME="USER-PASS" /><br>
	<input type="hidden" name="action" value="login" />
	<input type="hidden" name="page" value="mypage" />
	<input type="submit" name="SUBMIT" value="전 송"/>
	</form>
	</div>
</body>
</html>