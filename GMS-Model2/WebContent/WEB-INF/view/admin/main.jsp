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
<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="menuBox.jsp"/>
	</div> 	<!-- header end -->
	<div id="content">
		<jsp:include page="contentBox.jsp"/>
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
</body>
</html>