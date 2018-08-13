<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl.jar 사용하기 위해 한 것 -->
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="../common/loginBox.jsp"/>
		<jsp:include page="../common/menuBox.jsp"/>
	</div> 	<!-- header end -->
	<div id="content">
	이동페이지 : ${pagename}
	<c:choose>
		<c:when test="${pagename eq 'add'}">
			<jsp:include page="add.jsp"></jsp:include>
		</c:when>
		<c:when test="${pagename eq 'login'}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:when>
		<c:when test="${pagename eq 'search'}">
			<jsp:include page="search.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="retrieve.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
<script> 
member.main('${context}');
</script>
</body>
</html>