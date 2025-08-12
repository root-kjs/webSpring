console.log("등록");
// 동기식 fetch
const add = async() => {
    //1. 입력값 가져오기
    const wphoneInput = document.querySelector(".wphone");
    const wcountInput = document.querySelector(".wcount");

    const wphone = wphoneInput.value;
    const wcount = wcountInput.value;

    //2. 입력값 객체 저장
    const object = { wphone, wcount };

    //3. 입력값 전송(동기식FETCH)
    //1. fetch option
    const option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( object )
    }

    //2. response 응답대기
    const response = await fetch("/waiting/add" , option );

    //3. 데이터 전송 결과 
    const data = await response.json( );
    
    //4. 화면 결과 출력
    if( data == true ){
        alert("대기등록 성공!");
        location.href ="/waiting/list.jsp"
    }else{ alert(" 대기등록 실패"); }

}// func end