<%@page import="domain.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<MemberBean> lst = (List<MemberBean>)request.getAttribute("list");
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원리스트</title>
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
				<li><a href="${context}/member.do?action=move&page=searchIDForm"">SEARCH_ID</a></li>
				<li><a href="${context}/member.do?action=move&page=searchTeamForm">SEARCH_TEAM</a></li>
			</ul>
		</div>
	</div> 	<!-- header end -->
	<div id="content">
		<div id="content-box">
			<h3>전체 회원수 <%=lst.size() %> 명</h3>
<table>
	<tr id="list-layout">
	<th>Name</th>
	<th>Userid</th>
	<th>Password</th>
	<th>Teamid</th>
	<th>SSN</th>
	<th>Roll</th>
	</tr>

<%
for(MemberBean e : lst){
	%>
		<tr id="list-layout">
			<td><%=e.getName()%> </td>
			<td><%=e.getUserid()%> </td>
			<td><%=e.getPassword()%> </td>
			<td><%=e.getTeamid()%> </td>
			<td><%=e.getSsn()%> </td>
			<td><%=e.getRoll()%> </td>
		</tr>
<%	
}
%>
</table> 	
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



<%-- 

<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원목록</title>
<link rel="stylesheet" href="../../css/tableStyle.css" /> 
</head>

<h3>리스트</h3>

<%
		List<MemberBean> lst = (List<MemberBean>)request.getAttribute("list");		
%>

<body>
<h3>전체 회원수 <%=lst.size() %> 명</h3>
<table>
	<tr id="list-layout">
	<th>Name</th>
	<th>Userid</th>
	<th>Password</th>
	<th>Teamid</th>
	<th>SSN</th>
	<th>Roll</th>
	</tr>

<%
for(MemberBean e : lst){
	%>
		<tr id="list-layout">
			<td><%=e.getName()%> </td>
			<td><%=e.getUserid()%> </td>
			<td><%=e.getPassword()%> </td>
			<td><%=e.getTeamid()%> </td>
			<td><%=e.getSsn()%> </td>
			<td><%=e.getRoll()%> </td>
		</tr>
<%	
}
%>
</table> 
<h3>멤버전체리스트 출력 성공!</h3>
<h3><a href="<%=application.getContextPath()%>/index.jsp">홈으로 가기</a></h3>
</body>
</html> --%>