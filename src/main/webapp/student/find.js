console.log("성적조회");

// 1. 전체 조회 fetch
const find = async() => {
    console.log("성적조회 실행");
    // fetch 옵션 선언
    const option = { method : "GET"}
    // 응답이 올때까지 js 는 기다림==> 동기화 통신(await)
    const response = await fetch( "/student/find" , option  )
    // 4. 응답객체를 json 반환
    const data = await response.json();

    // 1. 어디에
    const StudentBody = document.querySelector("#studentTbody")
    // 2. 무엇을 : fetch로 받은 리스트를 html로 구성
    let html = "";
    // 3. 출력
    for( let i = 0; i < data.length; i++ ){
        const student = data[i];
        html += `<tr>
            <td>${student.sno}</td>
            <td>${student.sname}</td>
            <td>${student.skor}</td>
            <td>${student.smath}</td>
        </tr>
        `
    }
    // 테이블 #studentBody에 반복되는 html을 대입
    StudentBody.innerHTML = html;

}// func end
find();