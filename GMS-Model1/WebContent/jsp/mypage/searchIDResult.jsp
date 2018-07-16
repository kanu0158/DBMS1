<%@page import="service.MemberServiceImpl"%>
<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ID찾기결과</title>
	<link rel="stylesheet" href="../../css/tableStyle.css" />
</head>
<body>
	<%
		String userid = request.getParameter("USER-ID");
		MemberBean mem = MemberServiceImpl.getInstance().findById(userid);
		
	%>
	<table>
	<tr>
			<th>ID</th>
			<th>Pass</th>
			<th>Name</th>
			<th>SSN</th>
			<th>TEAM</th>
			<th>ROLL</th>
	</tr>
	<tr>
			<td><%=mem.getUserid()%></td>
			<td><%=mem.getPassword()%></td>
			<td><%=mem.getName()%></td>
			<td><%=mem.getSsn()%></td>
			<td><%=mem.getTeamid()%></td>
			<td><%=mem.getRoll()%></td>
	</tr>
	</table>

</body>
</html>