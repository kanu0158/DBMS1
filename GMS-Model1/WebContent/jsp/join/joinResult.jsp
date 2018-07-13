<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입결과</title>
</head>
<body>
	<%
	MemberBean m = new MemberBean();
	m.setUserid(request.getParameter("USER-ID"));
	m.setPassword(request.getParameter("USER-PASS"));
	m.setName(request.getParameter("USER-NAME"));
	m.setSsn(request.getParameter("USER-SSN"));
	if(MemberServiceImpl.getInstance().findById(m)){
		%>
		<h3>회원가입실패! 아이디가 이미 존재!</h3>
		<% 
	}else if(MemberServiceImpl.getInstance().createMember(m)) {
		%>
		<h3>회원가입성공!</h3>
		<h3><a href="../login/user_login_form.jsp">로그인하기</a></h3>
		<%
	}
	%>
	
</body>
</html>