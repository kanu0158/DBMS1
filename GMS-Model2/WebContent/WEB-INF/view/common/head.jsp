<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- session에 담았으니 이제 필요없게 됌 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl , c는 core의 약자-->
<c:set var="context" value="<%=application.getContextPath() %>" />
 --%>
<head>
	<meta charset="UTF-8" />
	<title>adminMain</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
	<script>
	
	var common = new function (){
		this.move = function (domain,action,page){
			console.log('console:클릭 테스트성공!!${context}');
			alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
			alert('domain =' + domain + 'action ='+action +'page ='+page);
			//location은 객체 href는 속
			location.href = ("common" === domain)?"${context}/"+domain+".do" : "${context}/"+domain +".do?action="+action	+"&page="+page;
		}
	};
	/* function Common(){
		this.move = function (domain,action,page){
			console.log('console:클릭 테스트성공!!${context}');
			alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
			alert('domain =' + domain + 'action ='+action +'page ='+page);
			//location은 객체 href는 속
			location.href = ("common" == domain)?"${context}/"+domain+".do" : "${context}/"+domain +".do?action="+action	+"&page="+page;
		}
	}
 */	
	//anonymous function
	var mem = new function () { // 객체로만들어질 펑션이구나(첫글자 대문자)
		/* userid, ssn, name, age, roll, teamid, password; */ 
		var userid, ssn, name, password; /* 유효성체크가 필요한 속성들 , 중복된 id,...는 미리 처리하겠다. 시간낭비이므로*/
		this.setName = function(x){
			this.name = x;
		}
		this.getName = function(){
			return this.name;
		}
		this.setUserid = function(x){
			this.userid = x;
		}
		this.setSsn = function(x){
			this.ssn = x;
		}
		this.setPassword = function(x){
			this.password = x;
		}
		this.getUserid = function(){
			return this.userid;
		}
		this.getSsn = function(){
			return this.ssn;
		}
		this.getPassword = function(){
			return this.password;
		}
		this.loginValidation = function (){
			if(this.userid===''){
				alert('아이디입력해');
				document.getElementById('user-login-form').user_id.focus();
				return false;
			}else if(this.password===''){
				alert('pass입력해');
				document.getElementById('user-login-form').user_pass.focus();
				return false;
			}else{
				return true;
			}
	};
	
	this.joinValidation = function(){
		if(this.userid === ''){
			alert('아이디써줘');
			document.getElementById('user-join-form').user_id.focus();
			return false;
		}else if(this.password===''){
			alert('비밀번호써줘');
			document.getElementById('user-join-form').user_pass.focus();
			return false;
		}else if(this.name===''){
			alert('이름써줘');
			document.getElementById('user-join-form').user_name.focus();
			return false;
		}else if(this.ssn===''){
			alert('주민써줘');
			document.getElementById('user-join-form').user_ssn.focus();
			return false;
		}else {
			return true;
		}
	}
 }
	
	
	//function Member() { // 객체로만들어질 펑션이구나(첫글자 대문자)
		/* userid, ssn, name, age, roll, teamid, password; */ 
		//this.loginValidation = loginValidation;
	//}
	//var loginValidation = function (){
		//return ;  /* void도 반드시 리턴으로 처리해야함  프로그래밍쪽에서 함수는 리턴값이 있어야하고 프로시저는 리턴하면 안된다.*/
					/* 즉 프로시저는 setter고 함수는 getter이다. */
	//}
	
	
	/* function Member() { // 객체로만들어질 펑션이구나(첫글자 대문자)
		/* userid, ssn, name, age, roll, teamid, password; */ 
		//this.loginValidation = loginValidation;
	//}
	//var loginValidation = function loginValidation(){
		//return ;  /* void도 반드시 리턴으로 처리해야함  프로그래밍쪽에서 함수는 리턴값이 있어야하고 프로시저는 리턴하면 안된다.*/
					/* 즉 프로시저는 setter고 함수는 getter이다. */
	//} */
	</script>
</head>