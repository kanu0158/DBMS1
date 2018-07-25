<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script> /* 바디 안에 넣음, 전역메소드로 처리한 것 */
/* function move(domain,action,page){
	console.log('console:클릭 테스트성공!!${context}');
	alert('alert:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
	alert('domain =' + domain + 'action ='+action +'page ='+page);
	//location은 객체 href는 속
	location.href = ("common" == domain)?"${context}/"+domain+".do" : "${context}/"+domain +".do?action="+action	+"&page="+page;
} */


</script>
</body>
</html>