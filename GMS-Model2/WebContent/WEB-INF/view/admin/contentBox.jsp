<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl.jar 사용하기 위해 한 것 -->
<div id="content-box">
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이   름</th>
			<th>나   이</th>
			<th>성   별</th>
			<th>역   할</th>
			<th>팀아이디</th>
		</tr>
		<%-- <c:forEach begin="" end="" items="" step="" var="" varStatus=""> for-loop --%>
		<c:forEach items="${list}" var='member'> <!-- for-each -->
		<tr>
			<td>${member.userid}</td>
			<td><a class="username"  id="${member.userid}">${member.name}</a></td>
			<!-- 이렇게 살지 말자 우리 삼촌세대에서 이렇게 했다. -->
			<%-- <td><a href="${context}/admin.do?action=retrieve&page=memberDetail&user_id=${member.userid}" style="cursor:pointer;">${member.name}</a></td> --%>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamid}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script>
//눌렀을때 움직이는거면 document.get..().add('click',fx);이지만 
//오자마자 버튼클릭도 없이 바로 실행되어야하므로 자바는 값만 던지고 스크립트가 테이블도 만들고 모양을 만듬

document.getElementById('contentBoxMeta').className = 'bgColorisYellow';
var x = document.querySelectorAll('.username');//클래스 이름은 중복가능, var x에는 클래스네임이 username인 배열(Array)이담긴다. 
for(i in x){
	x[i].style.color='blue';
	x[i].style.cursor='pointer';
	x[i].addEventListener('click',function(){
		alert('클릭 : '+this.getAttribute('id')); // 콜백함수 내부의 이때의 this는 이 function을 호출한 x[i]객체를 가리킨다.
											//이파이패턴 내부 세터에서의 this와는 다르다 이때는 this가 자바와 똑같이 현재 클래스를 가리킨다. 
											//js에선 클래스가 없으니 function이라고 생각하면 될 듯
		location.href = "${context}/admin.do?action=retrieve&page=memberDetail&user_id="+this.getAttribute('id');
	});
}
</script>

