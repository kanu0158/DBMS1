<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*"%>
<%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>사용자로그인결과</title>
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
	if(MemberServiceImpl.getInstance().login(m) == true){
		MemberBean x = MemberServiceImpl.getInstance().session();
		%>
	
		<h3>사용자 ID : <%=x.getUserid() %></h3>
		<h3>사용자 PASS : <%=x.getPassword() %></h3>
		<h3>사용자 이름 : <%=x.getName() %></h3>
		<h3>사용자 나이 : <%=x.getSsn() %></h3>
		<h3>사용자 직책 : <%=x.getRoll() %></h3>
		<%
	}else{
		%>
		<h3>아이디나 비밀번호가 틀립니다.</h3>
		<%
	}
%>



</body>
</html>