// 이메일 중복 체크
const input = document.getElementById("email");

const p = document.getElementById("result");
// change : input 태그의 값이 변했을 때
// input : input 태그에 입력이 발생했을 때
input.addEventListener("input", request );

function request() {
	
	let url = "check";
	
	let email = input.value;
	
	axios.get(url + "?email=" + email)
		 .then( function(res){
			
			console.log(res.data);
			
			if(res.data == 't'){
				p.innerHTML="사용가능한 이메일 입니다.";
				p.style="color : green";
			}else{
				p.innerHTML="중복된 이메일 입니다.";
				p.style="color : red";
			}
			
			
		 });
	
}









