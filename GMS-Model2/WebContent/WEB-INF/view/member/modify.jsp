<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content">
<div>
<form id="modify-form">
<table id="retrieve-table">
	<tr>
		<td rowspan="3"><img src="${img}${profile}" alt="" /> </td>
		<td>ID</td>
		<td colspan="2">${user.userId}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td colspan="2">${user.name}</td>
	</tr>
	<tr>
		<td>비번</td>
		<td colspan="2"><input id="userPass" type="text" name="userPass" placeholder="new password"/></td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀(현재 소속팀: ${user.teamId})</td>
		<td>
		<select name="teamId" id="teamId">
			<option value="${user.teamId}">없음</option>
			<option value="ATEAM">걍놀자</option>
			<option value="HTEAM">지은이네</option>
			<option value="STEAM">왕거북이</option>
			<option value="CTEAM">코딩짱</option>
		</select>
		</td>
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
<input type="button" id="modifyConfirmBtn" value="수정확인" />
</form>
</div>
</div> <!-- content end -->
<form method="POST" enctype="multipart/form-data" action="${context}/member.do?action=fileUpload&userId=${user.userId}">
    파일업로드: <input type="file" name="upfile"><br/>
  <input type="submit" value="파일업로드">
</form>
