<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호변경결과</title>
</head>
<body>
	<%MemberBean m = new MemberBean();
	  m.setUserid(request.getParameter("USER-ID"));
	  m.setPassword(request.getParameter("USER-PASS") + "/" + request.getParameter("NEW-PASS"));
	  if(request.getParameter("USER-PASS").equals(request.getParameter("NEW-PASS"))){
		  %>
		  <h3>비밀번호가 똑같아요</h3>
		  <h3><a href="update_form.jsp">다시입력하기</a></h3>
		  <%
	  }else if(MemberServiceImpl.getInstance().updateMemberPass(m)){
		  %>
		  <h3>비번변경 완료</h3>
		  <h3><a href="../../main.jsp">홈으로가기</a></h3>
		  <%
	  }else{
		  %>
		  <h3>비번변경 실패! 시스템 down</h3>
		  <%
	  }
	%>
	<h3><a href="<%=application.getContextPath()%>/index.jsp">홈으로 가기</a></h3>
</body>
</html>
