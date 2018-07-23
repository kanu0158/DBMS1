<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl , c는 core의 약자-->
<c:set var="context" value="<%=application.getContextPath() %>" />
<div id="menu-box">
			<ul id="menu">
				<li><a href="${context}/common.do">HOME</a></li>
				<li><a href="">ABOUT</a></li>
				<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li>
			</ul>
</div>