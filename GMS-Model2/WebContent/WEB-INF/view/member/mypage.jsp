<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp"/>
<h1>마이페이지 진입</h1> 
<div>
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
		<td colspan="2">********</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀명</td>
		<td>${user.teamid}</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>직책</td>
		<td>${user.roll}</td>
	</tr>
</table>
</div>
<div>
<a><button>로그아웃</button></a>
<a id="myPageMoveToUpdate"><button>정보수정</button></a>
<a id="myPageMoveToDelete"><button>계정탈퇴</button></a>
</div>
<script>
document.getElementById('myPageMoveToUpdate').addEventListener('click',function(){
	router.move({context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'update_form'});
});

document.getElementById('myPageMoveToDelete').addEventListener('click',function(){
	router.move({context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'delete_form'});
});

</script>
