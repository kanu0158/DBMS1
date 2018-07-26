<% 
	String ctx = application.getContextPath(); //서블릿 설정값의 경로를 가지고 온다 .현재 스크립틀릿(클라)에서 서블릿(서버)으로 가기위해
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<!-- userid, ssn (800101-1),name,roll,teamid,password  -->
<jsp:include page="../common/head.jsp"/>
<body>
<script>
function sendForm() {
	alert('sendForm 진입성공');
	return true;		
}
</script>
	<div id="user-login-layout">
	<h1>회원가입</h1>
	<form id="user-join-form">
		ID: <input type="text" name="user_id" /><br>
		PASS: <input type="text" name="user_pass" /><br>
		NAME: <input type="text" name="user_name" /><br>
		SSN: <input type="text" name="user_ssn" /><br>
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
		<input id="joinFormBtn"type="button" value="전송" />
	</form>
	</div>
<script>
document.getElementById('joinFormBtn').addEventListener('click',function(){
	alert('조인폼태그 클릭 내부');
	var mem = new Member();
	var form = document.getElementById('user-join-form');
	form.action = "${context}/member.do"; /* 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. */
	form.method = "post";
	var userid = form.user_id.value;
	var userpass = form.user_pass.value;
	var username = form.user_name.value;
	var userssn = form.user_ssn.value;
	mem.setUserid(userid);
	mem.setPassword(userpass);
	mem.setName(username);
	mem.setSsn(userssn);
	if(mem.joinValidation()){
		form.submit();
	}
	
	
/* 	if( form.user_id.value == ""){
		alert('아이디써줘');
	}else if(form.user_pass.value == ""){
		alert('비밀번호써줘');
	}else if(form.user_name.value == ""){
		alert('이름써줘');
	}else if(form.user_ssn.value == ""){
		alert('주민써줘');
	}else if("${isid}" == false){
		alert('존재하는 아이디');
	}else {
		form.submit();
	}
 */
	//form.submit();
})
</script>	
</body>
</html>