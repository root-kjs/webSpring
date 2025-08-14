console.log("로그인 js 시작");

// 1. 로그인
const login = async() => {

    console.log("로그인 js 실행");
    // 어디에 : 입력받은 마크업 가져오기
    const idInput = document.querySelector(".idInput"); // 지정한 선택자의 마크업을 DOM 객체로 가져오기
    const pwdInput = document.querySelector(".pwdInput");

    // 입력받은 value 값 가져오기
    const mid = idInput.value;
    const mpwd = pwdInput.value;

    // 무엇을/ 입력받은 값을 객체화 
    const obj = { mid, mpwd } // 객체내 속성명과 속성값이 변수명이 동일하다면 생략 가능! 자바의 DTO랑 동일하게 이름을 맞추는게 졸음!

    // fetch
    try{
        const option ={
            method : "POST",
            headers : { "Content-Type":"application/json" },
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/login" ,  option ) // login API 요청
        const data = await response.json()
        // fetch 응답결과( 데이터 연동 결과 ) // 
        if( data > 0  ){
            alert(" 로그인 성공!");
            location.href="/index.jsp"
        }else{
            alert("로그인 실패! 아이디나 비밀번호를 확인하세요");
        }

    }catch{}

}// func end