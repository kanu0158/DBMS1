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

<%
		List<MemberBean> lst = MemberServiceImpl.getInstance().findByAll();		
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
</body>
</html>