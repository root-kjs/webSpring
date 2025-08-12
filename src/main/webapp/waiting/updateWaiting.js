console.log("대기수정");
//1.  수정할 내용 html화면에 보이기
const waitingView = async() => {

    console.log("대기수정 실행");
    // 1. 게시물 url 쿼리스트링 값 가져오기 
    const wno = new URLSearchParams(location.search).get("wno");
    // 2. fetch 이용한 해당 게시물 정보 요청
    const response = await fetch(`/waiting/view?wno=${wno}`);
    const data = await response.json();

    // 3. 전달받은 게시물 데이터 해당 html에 출력

    //1. 입력값 가져오기
    document.querySelector(".wphoneInput").value = data.wphone;
    document.querySelector(".wcountInput").value = data.wcount;

}// func end
waitingView();

//2. 수정
const updateWaiting = async () =>{
    console.log( "수정 실행");
    //1. 현재 수정할 쿼리 스트링 가져오기
    const wno = new URLSearchParams(location.search).get("wno");
    //2. 수정할 입력받은 html 가져오기
    const wphone = document.querySelector(".wphoneInput").value;
    const wcount = document.querySelector(".wcountInput").value;
    //3. 입력값 객체화
    const obj = { wno , wphone, wcount }
    //4. fetch 통신(option/response/data)
    const option = {
        method : "PUT",
        headers : { "Content-Type": "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch("/waiting", option );
    const data = await response.json();
    //5. fetch 데이터 결과 처리
    if (data == true){
        alert("수정 성공");
        location.href = `/waiting/view.jsp?wno=${wno}`
    }else {
        alert("수정 실패")
    }

}// func end