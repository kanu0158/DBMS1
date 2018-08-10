<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<body>

	<div id="content">
		<div id="user-login-layout">
		<h1>사용자로그인</h1>
		<form id="user-login-form">
		ID: <input type="TEXT" name="user_id" /><br>
		PASS: <input TYPE="TEXT" name="user_pass" /><br>
		<input id="loginFormBtn" type="button" value="전 송"/> 
		</form>
		</div>
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>

<script>
	document.getElementById('loginFormBtn').addEventListener('click',function(){
		alert('로긴폼태그 클릭 내부');
		var form = document.getElementById('user-login-form');
		var x = service.nullChecker([form.user_id.value,form.user_pass.value]);
		if(x.checker){
			form.action = "${context}/member.do"; /* 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. */
			form.method = "post";
			var node = document.createElement('input');
			node.innerHTML = '<input type="hidden" name="action" value="login" />';
			form.appendChild(node);
			form.submit();
		}else{
			alert(x.text);
		}
	});
</script>
</body>
</html>

