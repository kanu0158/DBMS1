<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="moveLoginForm">LOGIN</a>&nbsp;&nbsp;&nbsp;
	<a id="moveJoinForm">JOIN</a>
</div>

<!--js에서는 기능으로 쪼갬, a태그 주지말고  -->
<script>
/* var moveLoginForm = document.getElementById('moveLoginForm'); */
document.getElementById('moveLoginForm').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭로그인 이벤트 체크!!');
	router.move(['${context}','member','move','user_login_form']);
});
document.getElementById('moveJoinForm').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭조인 이벤트 체크!!');
	router.move(['${context}','member','move','joinForm']);
});

</script>