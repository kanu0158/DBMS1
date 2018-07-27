<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="user-login-layout">
	<h1>회원가입</h1>
	<form id="user-join-form">
		ID: <input type="text" name="user_id" /><br>
		PASS: <input type="text" name="user_pass" /><br>
		NAME: <input type="text" name="user_name" /><br>
		SSN: <input type="text" name="user_ssn" /><br>
		<input type="hidden" name="action" value="join" />
		<input type="hidden" name="page" value="joinResult" />
		<input type="hidden" name="gender" />
		<input type="hidden" name="age" />
		<br/>
		소속팀:
		<input type="radio" name="teamid" value="" checked="checked"/>없음
		<input type="radio" name="teamid" value="ATEAM" checked="checked"/>걍놀자
		<input type="radio" name="teamid" value="HTEAM" checked="checked"/>지은이네
		<input type="radio" name="teamid" value="STEAM" checked="checked"/>왕거북이
		<input type="radio" name="teamid" value="CTEAM" checked="checked"/>코딩짱
		<br/>
		프로젝트역할
		<select name="roll" id="roll">
			<option value="leader">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select>
		<br/>
		수강과목
		<input type="checkbox" name="subject" value="java" checked="checked" />Java 
		<input type="checkbox" name="subject" value="clang" />C언어 
		<input type="checkbox" name="subject" value="jsp" />JSP 
		<input type="checkbox" name="subject" value="php" />PHP 
		<input type="checkbox" name="subject" value="nodejs" />NodeJS 
		<input type="checkbox" name="subject" value="linux" />Linux
		<input type="checkbox" name="subject" value="html" />HTML
		<input type="checkbox" name="subject" value="spring" />Spring
		<br/>
		<input id="joinFormBtn"type="button" value="전송" />
	</form>
	</div>
<script>
document.getElementById('joinFormBtn').addEventListener('click',function(){
	alert('조인폼태그 클릭 내부');
	var form = document.getElementById('user-join-form');
	var x = service.nullChecker([form.user_id.value,form.user_pass.value,form.user_name.value,form.user_ssn.value]);
	if(x.checker){
		form.action = "${context}/member.do"; /* 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. */
		form.method = "post";
		mem.join([form.user_id.value,form.user_pass.value,form.user_name.value,form.user_ssn.value]);
		form.gender.value = mem.getGender();
		form.age.value = mem.getAge();
		alert('form.gender' + form.gender.value);
		alert('form.age'+form.age.value);
		form.submit();
	}else{
		alert(x.text);
	}
})
</script>	
</body>
</html>