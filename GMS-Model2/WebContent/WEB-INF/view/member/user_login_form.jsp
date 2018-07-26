<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<script>
function sendForm() {
	alert('sendForm 진입성공');
	return true;		
}
</script>
	<div id="user-login-layout">
	<h1>사용자로그인</h1>
	<form id="user-login-form">
	ID: <input type="TEXT" name="user_id" /><br>
	PASS: <input TYPE="TEXT" name="user_pass" /><br>
	<input type="hidden" name="action" value="login" />
	<input type="hidden" name="page" value="mypage" />
	<input id="loginFormBtn" type="button" value="전 송"/> 
	</form>
	</div>
	<script>
	//mem.setUserid('아이디유효성 체크할 아이디는 hong 이야');
	//alert('login_form에 유효성 체크값:' + mem.loginValidation());
	document.getElementById('loginFormBtn').addEventListener('click',function(){
		alert('로긴폼태그 클릭 내부');
		var mem = new Member();
		var form = document.getElementById('user-login-form');
		form.action = "${context}/member.do"; /* 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. */
		form.method = "post";
		var userid = form.user_id.value;
		var userpass = form.user_pass.value;
		mem.setUserid(userid);
		mem.setPassword(userpass);
		
		if(service.loginValidation(mem)){
			form.submit();
		}
		
		
		/* .equals == === */
		/* if( form.user_id.value === ""){ 
			alert('아이디써줘');
		}else if(form.user_pass.value === ""){
			alert('비밀번호써줘');
		}else if("${match}" == false){
			alert('잘못된 아이디');
		}else {
			form.submit();
		} */ 
		//form.submit();
	})
	</script>
</body>
</html>