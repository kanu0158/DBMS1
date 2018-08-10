//single thread model임 , 세미콜론은 이제 꼭 붙여야해
"use strict";
var router = (()=>{ //파라미터 없을때를 표시하기위해 소괄호 쳐준거고 밑에 x는 소괄호 생략, 파라미터는 무조건 하나만 보낸다 
		return {move : x =>{ // new가 아니라 이게 진짜 객체의 모습이다.  스칼라모양
			console.log('console:클릭 테스트성공!!${context}');
			alert('move:클릭 테스트 성공!!${context}'); // java의 sysout과 비슷
			location.href = ("common" === x.context)?x.context+"/"+x.domain+".do" : x.context+"/"+x.domain +".do?action="+x.action	+"&page="+x.page;
		}
		};  
})();  

var member = (()=>{
	return{
		main : x=>{
			document.getElementById('moveLogin').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
				alert('클릭로그인 이벤트 체크!!');
				router.move({context : x,
					domain : 'member',
					action : 'move',
					page : 'login'});
				//배열말고 JSON으로 만들어서 보냄
			});
			document.getElementById('moveAdd').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
				alert('클릭조인 이벤트 체크!!');
				router.move({context : x,
					domain : 'member',
					action : 'move',
					page : 'add'});
			});
		}
	};
})();

var common = (()=>{
	return {
		main : x=>{
			document.getElementById('moveAdminMain').addEventListener('click',()=>{//콜백함수(연이어서 호출되는 함수)
				alert('클릭어드민메인 이벤트 체크!!');
				var isAdmin = confirm('관리자입니까?');//confirm은 window의 객체이다. window.confirm 
				if(isAdmin){
					var password = prompt('관리자비번을 입력바랍니다.');//BOM의 메소드
					if(password == 1){
						router.move({
							context : x,
							domain : 'admin',
							action : 'search',
							page : 'main'});
					}
				}else{
					alert('관리자만 접근이 허용됩니다.');
				}
				
			});
			
			document.getElementById('moveLogin').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
				alert('클릭로그인 이벤트 체크!!');
				router.move({context : x,
					domain : 'member',
					action : 'move',
					page : 'login'});
				//배열말고 JSON으로 만들어서 보냄
			});
			document.getElementById('moveAdd').addEventListener('click',function() {//콜백함수(연이어서 호출되는 함수)
				alert('클릭조인 이벤트 체크!!');
				router.move({context : x,
					domain : 'member',
					action : 'move',
					page : 'add'});
			});
		}
	};
})();

var admin = (()=>{
	return {
		main : x=>{
			service.addClass(
					document.getElementById('searchBox'),
					'width80pt center'
				);
				service.addClass(
						document.getElementById('searchWord'),
						'width100px floatRight'
				);
				service.addClass(
						document.getElementById('searchOption'),
						'floatRight '
				);
				service.addClass(
						document.getElementById('searchBtn'),
						'floatRight '
				); 
				service.addClass(
						document.getElementById('contentBoxTab'),
						'width90pt center marginTop30px '
				);
				service.addClass(
						document.getElementById('contentBoxMeta'),
						'bgColorisYellow '
				);

				document.getElementById('searchBtn').addEventListener('click',()=>{
					alert('안녕 친구들~');
					var so = document.getElementById('searchOption');
					var sw = document.getElementById('searchWord');
					alert('so.value : '+ so.value);
					alert('sw.value : '+sw.value);
					location.href =  x+'/admin.do?action=search&searchOption='+so.value +'&searchWord='+sw.value;
				});
				
				for(var i of document.querySelectorAll('.pageNum')){
					service.addClass(
							i,
							'cursor '
					);
					i.addEventListener('click',function(){ //this 있는 녀석은 ()=>이 불가능함
						alert('pageNum 클릭 : '+this.getAttribute('id'));
						location.href = x+"/admin.do?action=search&pageNum="+this.getAttribute('id');
					});
				}
				
				for(var i of document.querySelectorAll('.username')){
					service.addClass(
							i,
							'cursor fontColorBlue'
					);
					i.addEventListener('click',function(){
						alert('username 클릭 : '+this.getAttribute('id')); // 콜백함수 내부의 이때의 this는 이 function을 호출한 x[i]객체를 가리킨다.
															//이파이패턴 내부 세터에서의 this와는 다르다 이때는 this가 자바와 똑같이 현재 클래스를 가리킨다. 
															//js에선 클래스가 없으니 function이라고 생각하면 될 듯
						location.href = x+"/admin.do?action=retrieve&user_id="+this.getAttribute('id');
					}); 
				}
		}
	};})();

var service = (()=>{
	return {
		nullChecker : x=>{
			alert('널체커 인');
			var i=0; // 아무것도 안주면 undefined(에러), 시작부터 인트로 타입 잡아준 것
			var json = { //json 객체다 다만 이건 메소드가 없으니 개체다.
					checker : true,
					text : '필수입력값이 없습니다.'
			};
			for(i in x){
				if(x[i] === '' ){
					json.checker = false;
				}
			}
			return json;//json으로 값을 던져라
		},
		passChecker : x=>{
			alert('패스체커 인');
			 // 아무것도 안주면 undefined(에러), 시작부터 인트로 타입 잡아준 것
			var json = { //json 객체다
					checker : true,
					text : '필수입력값이 없습니다.',	
			};
			alert('new : ' + x.newPass);
			alert('old : ' + x.pass);
			
			if(x.newPass === x.pass ){
				json.checker = true;
				json.text = '비밀번호가 같습니다.';
			}else{
				json.checker = false;
				json.text = '비밀번호가 다릅니다.';
			}
			return json;
			},
		addClass : (dom,cName) =>{
			var arr = cName.split(" "); //cName에서 공백으로 토큰을 만든다.
			//alert("dom : " + dom);
			//alert("cName : " + cName);
			//dom.className += " " +cName;
			//alert("끝!");
			if(arr.indexOf(cName) == -1){
				dom.className += " " +cName;
			}
		}
	  };
})();

	//anonymous function
var mem = (()=>{ // 객체로만들어질 펑션이구나(첫글자 대문자)
		/* userid, ssn, name, age, roll, teamid, password; */ 
		var _userid, _ssn, _name, _password, _age,_roll,_teamid,_gender; //_ 펑션사이의 공유하는 값이다라는 의미, 없으면 로컬변수다
		
		var setAge = x=>{
			var res = 0;
			res = new Date().getFullYear() -1899 - x[3].substr(0,2);
			this._age = res;
			alert('_age: ' + this._age);
			};
		var getAge = ()=>{return this._age;};
		var setGender = x=>{
			var flag = x[3].substr(7,1);
			alert('flag : '+flag);
			switch(flag){
			case '1':
			case '3':
			case '5':
			case '7':
				this._gender = 'man';
				break;
			case '2':
			case '4':
			case '6':
			case '8':
				this._gender = 'woman';
				break;
			}
			alert('_gender: ' + this._gender);
			};
		var getGender = ()=>{return this._gender;};
		var setRoll = (roll)=>{this._roll = roll;};
		var getRoll = ()=>{return this._roll;};
		var setTeamid = (teamid)=>{this._teamid = teamid;};
		var getTeamid = ()=>{return this._teamid;};
		var setName = (name)=>{this._name = name;};
		var getName = ()=>{return this._name;};
		var setUserid = (userid)=>{this._userid = userid;};
		var setSsn = (ssn)=>{this._ssn = ssn;};
		var setPassword = (password)=>{this._password = password;};
		var getUserid = ()=>{return this._userid;};
		var getSsn = ()=>{return this._ssn;};
		var getPassword = ()=>{return this._password;};
		return {
			setAge : setAge,
			getAge : getAge,
			setRoll : setRoll,
			getRoll : getRoll,
			setTeamid : setTeamid,
			getTeamid : getTeamid,
			setGender : setGender,
			getGender : getGender,
			setUserid : setUserid,
			setSsn : setSsn,
			setPassword : setPassword,
			setName : setName,
			getName : getName,
			getUserid : getUserid,
			getSsn : getSsn,
			getPassword : getPassword,
			join : x=>{
				mem.setAge(x);
				mem.setGender(x);
			} 
		};		
 })();