console.log("상세조회");
// 1. 상세 조회 출력
const viewWaiting = async() => {
    console.log("상세조회 실행");
    // 1. url 경로상의 웹주소 가져오기http://localhost:8080/waiting/view.jsp?wno=2
    const url = new URLSearchParams(location.search);
    // 2. 웹주소에서 쿼리스트링 값 가져오기 wno=2
    const wno = url.get('wno');
    // 3.  쿼리스트링 값 wno를 fetch로 통신하기 , 백틱 이용한 쿼리스트링 사용
    const response = await fetch(`/waiting/view?wno=${wno}`);
    const data = await response.json();

    //4. 응답 끝났다면 html 어디에 해당 값 넣을지
    const wphoneBox = document.querySelector(".wphoneBox");
    const wcountBox = document.querySelector(".wcountBox");

    //5. 무엇을(fetch 응답 데이터)
    const wphone = data.wphone;
    const wcount = data.wcount;

    // 6. 이제 출력!
    wphoneBox.innerHTML = wphone;
    wcountBox.innerHTML = wcount;
}
viewWaiting();

// 2. 수정 페이지 이동
const updateView = () =>{
    // 1. 수정할 게시물 번호 가져오기
    const wno = new URLSearchParams( location.search  ).get("wno");
    // 2. 수정페이지에 wno 쿼리스트링값 전달하기
    location.href = `/waiting/update.jsp?wno=${wno}`;
}


// 3. 삭제
const deleteWaiting = async() => {
    // 1. 삭제할 게시물 번호 가져오기
    const wno = new URLSearchParams(location.search).get("wno");
    // 2.  삭제 실행
    let check = confirm("정말 삭제하시겠습니까?");
    if( check == true ){
        //1. 옵션
        const option = {  method : "DELETE"  }
        //2. 응답(비동기) fetch
        const response = await fetch( `/waiting?wno=${wno}`, option );
        //3. 데이터
        const data = await response.json();

        if(data == true){
            alert("삭제 성공");
            location.href="/waiting/list.jsp"
        }else{
         alert("삭제 실패!");
        }

    }// if end

}// fund end