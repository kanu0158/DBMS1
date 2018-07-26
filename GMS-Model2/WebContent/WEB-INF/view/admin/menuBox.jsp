<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="menu-box">
	<ul id="menu">
	<li><a id="moveMain">HOME</a></li>
	<li><a id="moveList">USER_LIST</a></li>
	<li><a id="moveRetrieve">SEARCH_ID</a></li>
	<li><a id="moveSearch">SEARCH_TEAM</a></li>
	</ul>
</div> 
<script>
document.getElementById('moveMain').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭홈메인 이벤트 체크!!');
	router.move(['${context}','common','','']);
});

document.getElementById('moveList').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭리스트 이벤트 체크!!');
	router.move(['${context}','admin','list','memberList']);
});

document.getElementById('moveRetrieve').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭홈메인 이벤트 체크!!');
	router.move(['${context}','member','move','searchIDForm']);
});

document.getElementById('moveSearch').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
	alert('클릭홈메인 이벤트 체크!!');
	router.move(['${context}','member','move','searchTeamForm']);
});
	
</script>

<%-- <div id="menu-box">
	<ul id="menu">
	<li><a href="${context}/common.do">HOME</a></li>
	<li><a href="${context}/admin.do?action=list&page=memberList">USER_LIST</a></li>
	<li><a href="${context}/member.do?action=move&page=searchIDForm">SEARCH_ID</a></li>
	<li><a href="${context}/member.do?action=move&page=searchTeamForm">SEARCH_TEAM</a></li>
	</ul>
</div> --%>