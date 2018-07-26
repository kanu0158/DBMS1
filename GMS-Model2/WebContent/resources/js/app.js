(()=>{})();

//single thread model임 , 세미콜론은 이제 꼭 붙여야해
var router = (()=>{ //파라미터 없을때를 표시하기위해 소괄호 쳐준거고 밑에 x는 소괄호 생략, 파라미터는 무조건 하나만 보낸다 
		return {move : x =>{ // new가 아니라 이게 진짜 객체의 모습이다.  스칼라모양
			console.log('console:클릭 테스트성공!!${context}');
			alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
			alert('domain =' + x[1] + 'action ='+x[2] +'page ='+x[3]);
			//location은 객체 href는 속
			location.href = ("common" === x[1])?x[0]+"/"+x[1]+".do" : x[0]+"/"+x[1] +".do?action="+x[2]	+"&page="+x[3];
		}};  /*이게 클로저다 프라이빗의 공간을 퍼블릭으로 열어주는 것, */
								/*표기법은 JSON  move : move =='move' : move	 같다고 처리해주자 디폴트로 */
})();  



/*var move = (()=>{  
	return x =>{ 
		console.log('console:클릭 테스트성공!!${context}');
		alert('move:클릭 테스트 성공!!${context}'); 
		alert('domain =' + x[1] + 'action ='+x[2] +'page ='+x[3]);
		
		location.href = ("common" === x[1])?x[0]+"/"+x[1]+".do" : x[0]+"/"+x[1] +".do?action="+x[2]	+"&page="+x[3];
	};  
})(); 
*/

var service = (()=>{
	return {
		loginValidation : x=>{
			if(x.getUserid()===''){
				alert('아이디입력해');
				document.getElementById('user-login-form').user_id.focus();
				return false;
			}else if(x.getPassword()===''){
				alert('pass입력해');
				document.getElementById('user-login-form').user_pass.focus();
				return false;
			}else{
				return true;
			}
		},
		joinValidation : x=>{
			if(x.getUserid() === ''){
				alert('아이디써줘');
				document.getElementById('user-join-form').user_id.focus();
				return false;
			}else if(x.getPassword() ===''){
				alert('비밀번호써줘');
				document.getElementById('user-join-form').user_pass.focus();
				return false;
			}else if(x.getName() ===''){
				alert('이름써줘');
				document.getElementById('user-join-form').user_name.focus();
				return false;
			}else if(x.getSsn() ===''){
				alert('주민써줘');
				document.getElementById('user-join-form').user_ssn.focus();
				return false;
			}else {
				return true;
			}
		}
	  };
})();

/*var service = (()=>{
	return {validation : x=>{}};
})(); // 기본 폼
*/
/*function Common(){
		this.move = function (t,domain,action,page){
			console.log('console:클릭 테스트성공!!${context}');
			alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
			alert('domain =' + domain + 'action ='+action +'page ='+page);
			//location은 객체 href는 속
			location.href = ("common" === domain)?t+"/"+domain+".do" : t+"/"+domain +".do?action="+action	+"&page="+page;
		}
};*/
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
function Member() { // 객체로만들어질 펑션이구나(첫글자 대문자)
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