<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ID찾기</title>
</head>
<body>
	<form action="<%=ctx%>/member.do">
	ID : <input type="text" name="USER-ID" />
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="searchIDResult" />
	<input type="submit" name="submit" value="검색" />
	</form>
</body>
</html>