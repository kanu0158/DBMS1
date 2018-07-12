<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 디클러레이션 -->
<%! 
    	int a = 4;
		int b = 5;
		int c = 0;
		String s = "";
		String name = "";
%>
<!-- 스크립틀릿 -->
<%
	c = a + b;
	s = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	name = "홍길동";
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>HELLO <%=name %></title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<%=s %><!-- 익스프레션 -->
	<table id="main-tab-Layout">
		<tr class="height-80">
			<th class="align-left" ><img src="img/home/bugs.PNG"  alt="" width="150" height="150"/></th>
			<th class="width-full align-center" ><img src="img/home/serch.PNG"  alt="" width="600" height="100"/></th>
			<th><img src="img/home/post.PNG"  alt="" width="200" height="150"/></th>
		</tr>
		<tr>
			<td id="main-tab-Layout-td" colspan="2"><img src="img/home/recording.PNG"  alt="" width="990" height="390"/></td>
			<td >
				<ul>
					<li><a href="jsp/login/user_login_form.jsp"> 사용자로그인 바보야</a></li><br>
					<li><a href="jsp/login/admin_login.jsp"> 관리자로그인</a></li>
					<li><a href="jsp/join/joinForm.jsp"> 회원가입</a></li>
					<li><%=c %></li><!-- 익스프레션 -->
				</ul>
			</td>
			<!-- <td id="login-size" class="align-center"><a href="../mypage/mypage.html"><img src="../../img/home/login.PNG"  alt="" width="200" height="300"/></a></td> -->
		</tr>
		<tr>
			<td class="height-100" colspan="3">
		<ul>
			<li><a href="http://www.bugscorp.co.kr?wl_ref=M_footer_03_01" target="_blank" aria-label="새창">회사소개</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/cooperation?wl_ref=M_footer_03_01">제휴문의</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/use?wl_ref=M_footer_03_01">이용약관</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/privacy?wl_ref=M_footer_03_01">개인정보처리방침</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/rules/youth?wl_ref=M_footer_03_01">청소년보호정책</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/connect/center?wl_ref=M_footer_03_01">커넥트 센터</a><span class="bar"></span></li>
			<li><a href="http://help.bugs.co.kr?wl_ref=M_footer_03_01">고객센터</a><span class="bar"></span></li>
			<li><a href="https://music.bugs.co.kr/sitemap?wl_ref=M_footer_03_01">사이트맵</a></li>
		</ul>
			</td>
		</tr>
	</table>
</body>
</html>