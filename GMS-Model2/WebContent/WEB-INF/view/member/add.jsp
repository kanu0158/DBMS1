<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="content">
		<div id="user-login-layout">
	<h1>회원가입</h1>
	<form id="user-join-form">
		ID: <input type="text" name="user_id" /><br>
		PASS: <input type="text" name="user_pass" /><br>
		NAME: <input type="text" name="user_name" /><br>
		SSN: <input type="text" name="user_ssn" /><br>
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
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
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
		var arr = [{name : "action" , 
					value : "join"} ,
				   {name : "page" , 
					value : "joinResult"} ,
				   {name : "gender" , 
					value : mem.getGender()},
				   {name : "age" , 
					value : mem.getAge()}];
		var i=0;
		for(i in arr){
			var node = document.createElement('input');
			node.setAttribute('type','hidden');
			node.setAttribute('name',arr[i].name);
			node.setAttribute('value',arr[i].value);
			alert('arr[i].name : ' + arr[i].name );
			alert('arr[i].value : ' + arr[i].value );
			form.appendChild(node);
		}
		
		/* node.innerHTML =   fm적인 방법
		'<input type="hidden" name="action" value="join" />'
		+ '<input type="hidden" name="page" value= "joinResult"/>'
		+ '<input type="hidden" name="gender" value= ' + mem.getGender()+ '/>'
		+ '<input type="hidden" name="age" value= ' + mem.getAge()+ '/>'; */
		form.submit();
	}else{
		alert(x.text);
	}
})
</script>	
