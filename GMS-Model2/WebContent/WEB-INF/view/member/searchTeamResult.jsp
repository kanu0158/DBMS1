<%@page import="service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.*" %>
<%@page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀검색완료</title>
</head>
<body>
	<%-- <%
		String teamid = request.getParameter("TEAM-ID");
		List<MemberBean> lst = MemberServiceImpl.getInstance().findByName(teamid);
	
	%>
		<h3>팀 : <%=teamid %></h3>
		<table>
			<th>ID</th>
			<th>Pass</th>
			<th>Name</th>
			<th>SSN</th>
			<th>TEAM</th>
			<th>ROLL</th>
			<%
			for(MemberBean m : lst){
				%>
				<tr>
					<td><%=m.getUserid()%></td>
					<td><%=m.getPassword()%></td>
					<td><%=m.getName()%></td>
					<td><%=m.getSsn()%></td>
					<td><%=m.getTeamid()%></td>
					<td><%=m.getRoll()%></td>
				</tr>
			<% 
			}
			%>
		
		</table>
		 --%>
		 <h3>팀검색성공</h3>
		<h3><a href="<%=application.getContextPath()%>/index.jsp">홈으로 가기</a></h3>
</body>
</html>