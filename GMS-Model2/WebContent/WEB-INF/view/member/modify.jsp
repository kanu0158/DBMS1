<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
<div>
<form id="update-form">
<table id="mypage-table">
	<tr>
		<td rowspan="3"><img src="${img}/home/bugs.PNG" alt="" /> </td>
		<td>ID</td>
		<td colspan="2">${user.userid}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td colspan="2">${user.name}</td>
	</tr>
	<tr>
		<td>비번</td>
		<td colspan="2"><input id="password" type="text" name="password" placeholder="new password"/></td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀(현재 소속팀: ${user.teamid})</td>
		<td><select name="teamid" id="teamid">
			<option value="${user.teamid}">없음</option>
			<option value="ATEAM">걍놀자</option>
			<option value="HTEAM">지은이네</option>
			<option value="STEAM">왕거북이</option>
			<option value="CTEAM">코딩짱</option>
	</select></td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>직책(현재 직책: ${user.roll})</td>
		<td><select name="roll" id="roll">
			<option value="leader" selected="selected">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select></td>
	</tr>
</table>
<input type="button" id="updateConfirmBtn" value="수정확인" />
</form>
</div>
	
	</div> <!-- content end -->
	<div id="footer">
		<jsp:include page="../common/footerBox.jsp"/>
	</div>
</div>
<script>
var form = document.getElementById('update-form'); //DOM(다큐먼트가 만든 객체)객체
//(window.생략가능,이 윈도우는 브라우져를 의미)location.href (돔객체)
var team = document.getElementById('teamid');
for(var i=0;i<team.options.length;i++){
	if(team.options[i].value==='${user.teamid}'){
		alert('userteamid : ' + '${user.teamid}');
		team.options[i].setAttribute("selected","selected");
	}
}
alert('form.teamid : '+form.teamid.value + 'form.roll : ' + form.roll.value);

var roll = document.getElementById('roll');
for(var i=0;i<roll.options.length;i++){
	if(roll.options[i].value==='${user.roll}'){
		alert('userroll : ' + '${user.roll}');
		roll.options[i].setAttribute("selected","selected");
	}
}

document.getElementById('updateConfirmBtn').addEventListener('click',function(){
	alert('수정확인버튼 클릭함!!');
	//업데이트 실행 하세요...
	var x = service.nullChecker([form.password.value]);
	if(x.checker){
	form.action = "${context}/member.do";
	form.method = "get";
	var node = document.createElement('input');
	node.innerHTML =
	'<input type="hidden" name="action" value="update" />'
	+ '<input type="hidden" name="userid" value= "${user.userid}"/>';
	form.appendChild(node); // 객체(node)로 만든 다음에 form에 자식으로 붙여 넣는것!
	//정적코딩은 static 준것(html들...) 에서 처리한것(메모리 잡아먹는것)
	//동적코딩은 메소드에 의한(function(){}내부) 처리, 수행 전까지는 메모리를 잡아먹지 않고 이게 끝나면 메모리 잡아먹던 리소스가 제거된다.
	form.submit();
	}else{
	alert(x.text);
	}
	});
</script>
</body>
</html>






	


<%-- 
	<div id="user-login-layout">
	<h3>비밀번호변경</h3>
	<form id="passUpdate" action="${context}/member.do">
	ID : <input type="text" name="user_id"></input><br>
	PASS : <input type="text" name="user_pass"></input><br>
	NEW_PASS : <input type="text" name="new_pass"></input>
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="page" value="update_result" />
	<input type="button" value="전송"></input>
	</form>
	 --%>

