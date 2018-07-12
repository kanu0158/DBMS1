<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe"
							,"seein"
							,"0158" -->
<%!
	String userid = "";
	String password = "";
	/* 스크립틀릿(연산)에서 바로담아도 되니 디클러레이션 생략가능  */
%>
<%
	userid = request.getParameter("USER-ID");
	password = request.getParameter("USER-PASS");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
			,"seein"
			,"0158");
	String sql =String.format("SELECT " 
		     + "   MEM_ID USER_ID, "
		     + "   PASSWORD USER_PASS, "
		     + "   NAME USER_NAME,   "
		     + "   AGE USER_AGE,    "
		     + "   ROLL USER_ROLL   "
		    + "   FROM   "
		     + "   MEMBER   "
		    + "   WHERE    " 
		     + "   MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'  ",userid,password);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	List<String> list = null;
	if(rs.next()){ // rs.next() 한번 수행 (true나옴)
		list = new ArrayList<>();
		do{
			list.add(rs.getString("USER_ID"));
			list.add(rs.getString("USER_PASS"));
			list.add(rs.getString("USER_NAME"));
			list.add(rs.getString("USER_AGE"));
			list.add(rs.getString("USER_ROLL"));
		}while(rs.next()); // rs.next()를 또 수행하면 그 뒤에껄 참조하게되나봐 값이 없으니 와일문실행안하게돼
    %>
	<h3>사용자가 입력한 ID : <%=list.get(0) %></h3>
	<h3>사용자가 입력한 PASS :<%=list.get(1) %> </h3>
	<h3>사용자 이름 : <%=list.get(2)%></h3>
	<h3>사용자 나이 : <%=list.get(3)%></h3>
	<h3>사용자 직책 : <%=list.get(4)%></h3>
	<%
	}else{
		%>  <!-- 닫아버리면 -->
		<!-- html 영역 -->
		<h3>아이디나 비번이 틀립니다</h3>
		<%	
	}
%>
</body>
</html>