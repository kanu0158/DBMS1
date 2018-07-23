<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl , c는 core의 약자-->
<c:set var="context" value="<%=application.getContextPath() %>" />
<!doctype html>
<html lang="en">
	<jsp:include page="common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/titleBox.jsp"/>
		<jsp:include page="common/loginBox.jsp"/>
		<jsp:include page="common/menuBox.jsp"/>
	</div> 	<!-- header end -->
	<div id="content">
		<jsp:include page="common/contentBox.jsp"/>
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="common/footerBox.jsp"/>
	</div>
</div>
</body>
</html>