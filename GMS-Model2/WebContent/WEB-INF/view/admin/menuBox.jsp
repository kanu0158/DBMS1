<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="menu-box">
	<ul id="menu">
	<li><a onclick="common.move('common','','')">HOME</a></li>
	<li><a onclick="common.move('admin','list','memberList')">USER_LIST</a></li>
	<li><a onclick="common.move('member','move','searchIDForm')">SEARCH_ID</a></li>
	<li><a onclick="common.move('member','move','searchTeamForm')">SEARCH_TEAM</a></li>
	</ul>
</div> 


<%-- <div id="menu-box">
	<ul id="menu">
	<li><a href="${context}/common.do">HOME</a></li>
	<li><a href="${context}/admin.do?action=list&page=memberList">USER_LIST</a></li>
	<li><a href="${context}/member.do?action=move&page=searchIDForm">SEARCH_ID</a></li>
	<li><a href="${context}/member.do?action=move&page=searchTeamForm">SEARCH_TEAM</a></li>
	</ul>
</div> --%>