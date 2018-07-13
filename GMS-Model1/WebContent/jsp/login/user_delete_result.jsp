<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>사용자계정 삭제 결과</title>
</head>
<body>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe"
							,"seein"
							,"0158" -->
<%
	/* 스크립틀릿(연산)에서 바로담아도 되니 디클러레이션 생략가능  */
	MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("USER-ID"));
	m.setPassword(request.getParameter("USER-PASS"));
	MemberServiceImpl.getInstance().deleteMember(m);
		
%>
	
		<h3>삭제완료</h3>
		<h3><a href="../../main.jsp">홈으로 돌아가기</a></h3> 
</body>
</html>