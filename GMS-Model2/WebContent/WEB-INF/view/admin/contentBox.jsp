<%@page import="domain.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl.jar 사용하기 위해 한 것 -->
<div id="content-box">
	<div id="searchBox">
		<input id="searchBtn" name="searchBtn"  type ="button" value="검색" />
		<input id="searchWord" name="searchWord" type="text" placeholder="검색어 입력"/>
		<select name="searchOption" id="searchOption">
			<option value="none">검색조건</option>
			<option value="user_id">아이디</option>
			<option value="name">이  름</option>
			<option value="team_id">팀  명</option>
		</select>
	

	</div>

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
		<c:forEach items='${list}' var='member'> <!-- for-each -->
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
admin.main('${context}');

//눌렀을때 움직이는거면 document.get..().add('click',fx);이지만 
//오자마자 버튼클릭도 없이 바로 실행되어야하므로 자바는 값만 던지고 스크립트가 테이블도 만들고 모양을 만듬


/* 
document.getElementById('contentBoxSearch').style.width = '80%';
document.getElementById('contentBoxSearch').style.margin = '0 auto';
document.getElementById('contentBoxTab').style.width = '80%';
document.getElementById('contentBoxTab').style.margin = '0 auto';
document.getElementById('contentBoxMeta').className = 'bgColorisYellow'; */
</script>

