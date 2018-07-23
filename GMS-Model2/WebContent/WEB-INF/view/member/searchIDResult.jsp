<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl , c는 core의 약자-->
<c:set var="context" value="<%=application.getContextPath() %>" />
<%-- 
<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>

 --%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ID찾기결과</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />

</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="title-box">
			<h1> GRADE MANAGEMENT SYSTEM</h1>
		</div>
		<div id="menu-box">
			<ul id="menu">
				<li><a href="${context}/admin.do?action=list&page=memberList">USER_LIST</a></li>
				<li><a href="${context}/member.do?action=move&page=searchIDForm">SEARCH_ID</a></li>
				<li><a href="${context}/member.do?action=move&page=searchTeamForm">SEARCH_TEAM</a></li>
			</ul>
		</div>
	</div> 	<!-- header end -->
	<div id="content">
		<div id="content-box">
			<h3><%=request.getAttribute("member") %></h3>		
		</div>
	</div> <!-- content end -->
	<div id="footer">
		<div>
		<ul>
			<li><a href="http://www.bugscorp.co.kr?wl_ref=M_footer_03_01" target="_blank" aria-label="새창">회사소개</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/cooperation?wl_ref=M_footer_03_01">제휴문의</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/use?wl_ref=M_footer_03_01">이용약관</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/privacy?wl_ref=M_footer_03_01">개인정보처리방침</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/youth?wl_ref=M_footer_03_01">청소년보호정책</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/connect/center?wl_ref=M_footer_03_01">커넥트 센터</a><span class="bar"></span></li>
			<li><a href="http://help.bugs.co.kr?wl_ref=M_footer_03_01">고객센터</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/sitemap?wl_ref=M_footer_03_01">사이트맵</a></li>
		</ul>
		</div>
	</div>
</div>
	
</body>
</html>
