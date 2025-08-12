console.log("대기수정");
//1.  수정할 내용 html화면에 보이기
const updateWaiting = async() => {

    console.log("대기수정 실행");
    // 1. 게시물 url 쿼리스트링 값 가져오기 
    const wno = new URLSearchParams(location.search).get("wno");
    // 2. fetch 이용한 해당 게시물 정보 요청
    const response = await fetch(`/waiting/view?wno=${wno}`);
    const data = await response.json();

    // 3. 전달받은 게시물 데이터 해당 html에 출력

     //1. 입력값 가져오기

   document.querySelector(".wphoneInput").value.innerHTML = data.wphone;
   document.querySelector(".wcountInput").value.innerHTML = data.wcount;

}// func end
updateWaiting();