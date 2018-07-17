<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀검색</title>
</head>
<body>
	<form action="<%=ctx%>/member.do">
	<input type="text" name="TEAM-ID" />
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="searchTeamResult" />
	<input type="submit" name="SUBMIT" value="검색" />
	</form>
	
</body>
</html>