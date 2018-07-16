<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 수 출력</title>
</head>
<body>
	<%
	if(MemberServiceImpl.getInstance().count() == 999){
		%>
		<h3>조회 실패! </h3>
		<% 
	}else {
		%>
		<h3>회원 수 : <%=MemberServiceImpl.getInstance().count()%></h3> 
		<h3><a href="../../main.jsp">홈으로 가기</a></h3>
		<%
	}
	%>
	
</body>
</html>