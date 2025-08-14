console.log("회원가입 js");

// ********** 유효성 검사 체크리스트 **********
const signPass = [ false, false ]; // 초기값 , 0 --> 아이디 중복검사 / 1 --> 휴대폰번호 중복검사

// 1. 회원가입
const signUp = async() => {
console.log("회원가입 js 실행"); 

    // 만약에 유효성 검사 체크리스트에 false 가 있다면, 회원가입 안되게 처리해야 함
    // **************** js함수 배열 내 요소찾기 : .indexOf() / .includes()--> 존재 하면**************** **************** **************** 
    if( signPass.includes(false) ){ //signPass[0] == false 
        alert(" 올바른 정보 입력 후, 회원가입 가능합니다. ");
        return;
    }

    // 어디서
    const idInput = document.querySelector(".idInput");
    const pwdInput = document.querySelector(".pwdInput");
    const nameInput = document.querySelector(".nameInput");
    const phoneInput = document.querySelector(".phoneInput");

    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;

    // 무엇을 : 입력받은 값을 객체화
    const obj = { mid, mpwd, mname, mphone  };

    // fetch 동기 요청/응답/예외발생(에러) 처리
    try{
        const option = {
            method : "POST",
            headers : {"Content-Type":"application/json"},
            body : JSON.stringify( obj ) 
        }
        const response = await fetch("/member/signup" , option )
        const data = await response.json()

        if( data > 0 ){
            alert("회원가입 성공");
            location.href = "/member/login.jsp";
        }else{
            alert("회원가입 실패");
        }
    }catch( error ){
        console.log( error );
    }

}//func end


// 2. 아이디 중복검사 : 인풋에 입력할 때 발동
const idCheck = async() => {
    console.log("아이디 중복검사 실행");

    // 아이디 값을 가져오기
    const idInput = document.querySelector(".idInput");
    const idCheck = document.querySelector(".idCheck");
    const mid = idInput.value;

    // !유효성 검사 : 입력한 아이디 6글자 미만
     if( mid.length < 6 ){
        idCheck.innerHTML = "아이디는 6글자 이상으로 입력해주세요."
        signPass[1] = false; // 유효성 검사의 상태 변경
        return;
     }

    // fetch 요청/응답/에러처리
    try{
        const option = {method : "GET" }
        const response = await fetch( `/member/signup?type=mid&data=${mid}` , option )
        const data = await response.json();
        // !유효성 검사 : 중복검사
        if( data == true ){
            idCheck.innerHTML = "사용중인 아이디입니다."
            signPass[0] = false; // 유효성 검사의 상태 변경
        }else{
            idCheck.innerHTML = "사용가능한 아이디입니다."
            signPass[0] = true; // 유효성 검사의 상태 변경(성공)
        }
    }catch( error ){ console.log(error);}

}// func end

// 3. 휴대폰번호 중복검사
const phoneCheck = async() => {
    console.log("휴대폰번호 중복검사 실행");

    const phoneCheck = document.querySelector(".phoneCheck");
    const mphone = document.querySelector(".phoneInput").value;

    // !.유효성 검사 : 길이 (휴대폰 번호 13글자 -(하이픈) 포함 )
    if( mphone.length != 13 ){
        phoneCheck.innerHTML="-(하이픈)포함한 13자리 연락처를 입력하세요"
        signPass[1] = false;
        retunrn;
    }
    try{
        // !. fetch
        const option = { method : "GET" }
        const response = await fetch(`/member/signup?type=mphone&data=${mphone}`, option ) //경로는 http 메소드 경로를 적어야 함. .jsp 넣으면 안됨!!!!! 
        const data = await response.json()

        if( data == true ){
            phoneCheck.innerHTML = "이미 사용중인 휴대폰번호입니다.";
            signPass[1] = false;
        }else{
            phoneCheck.innerHTML = "사용가능한 휴대폰 번호입니다. "
            signPass[1] = true;
        }
    }catch(e){
        console.log( e );
    }


}//func end

