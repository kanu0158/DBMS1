<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="user-login-layout">
	<h1>사용자로그인</h1>
	<form id="user-delete-form">
	ID: <input type="TEXT" name="user_id" /><br>
	PASS: <input TYPE="TEXT" name="user_pass" /><br>
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="page" value="main" />
	<input id="deleteFormBtn" type="button" value="전 송"/> 
	</form>
	</div>
	<script>
	document.getElementById('deleteFormBtn').addEventListener('click',function(){
		alert('로긴폼태그 클릭 내부');
		var form = document.getElementById('user-delete-form');
		var x = service.nullChecker([form.user_id.value,form.user_pass.value]);
		if(x.checker){
			form.action = "${context}/member.do"; /* 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. */
			form.method = "post";
			form.submit();
		}else{
			alert(x.text);
		}
	});
	</script>
</body>
</html>