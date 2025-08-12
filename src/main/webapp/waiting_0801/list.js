console.log("대기조회");

// 동기식 fetch
const list = async() =>{
    console.log("대기조회 실행");

    //1. 데이터 가져오기(비동기 http통신)
    const response = await fetch( "/waiting/list" ,  { method : "GET"} );

    //2. fetch data
    const data = await response.json();

    //3. 어디에 
    const waitingTbody = document.querySelector("#waitingTbody");

    //4. 무엇을
    let html ="";

    //5. 출력 포문
    for( let i = 0; i < data.length; i++ ){
        const waiting = data[i];
        html += `<tr>
            <td>${waiting.wno}</td>
            <td>${waiting.wphone}</td>
            <td>${waiting.wcount}</td>
        </tr>
        ` 
    }
    waitingTbody.innerHTML = html;
}// func end
list();