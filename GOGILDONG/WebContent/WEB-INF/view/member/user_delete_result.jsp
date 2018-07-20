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
		<h3>계정탈퇴성공</h3>
		<h3><a href="<%=application.getContextPath()%>/index.jsp">홈으로 가기</a></h3>
</body>
</html>