console.log("성적등록");
const save = async () => {
    console.log("성적등록 실행");


    // 1. 입력받을 값을 가져오기
    const snameInput = document.querySelector(".sname");
    const skorInput = document.querySelector(".skor");
    const smathInput = document.querySelector(".smath");

    const sname = snameInput.value;   
    const skor = skorInput.value;   
    const smath = smathInput.value;    

    // 2. 입력받은 값을 객체화
    const object = {  sname : sname, skor : skor, smath : smath  } // 속성명과 속성값이 같다면 생략가능!

    // 동기식 fetch
    const option ={
        method : "POST",
        headers : { "Content-Type":"application/json" },
        body : JSON.stringify( object )
    }

    const response = await fetch("/student/save" , option );
    const data = await response.json( );
    if( data == true ){ 
        alert("등록 성공"); 
        location.href="/student/find.jsp"
    }else{
        alert("등록실패");
    }

}//func end
