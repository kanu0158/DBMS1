<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
			<ul id="menu">
				<li><a id="moveMain">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a id="moveAdminMain">ADMIN</a></li>
			</ul>
</div>
<script>
document.getElementById('moveMain').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭홈메인 이벤트 체크!!');
	router.move(['${context}','common','','']);
});

document.getElementById('moveAdminMain').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭어드민메인 이벤트 체크!!');
	router.move(['${context}','admin','move','main']);
});
</script>

<!-- <script>
	//var common = new Common();
</script> -->
<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
			<ul id="menu">
				<li><a href="${context}/common.do">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li>
			</ul>
</div> 
--%>