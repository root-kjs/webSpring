// 람다식 함수선언
// const 함수명 = () => {}

// 1. 등록
const boardWrite = () => {
    console.log("등록함수 실행");
    let data = { "bcontent" : "하이" , "bwriter":"김진숙" }
    let option ={
        // 1. method
        method : "POST",
        // 2. headers
        headers : { "Content-Type" : "application/json" },
        // 3. body
        body : JSON.stringify( data ) //{ "bcontent" : "징징금지", "bwriter" : "김진숙" }
    }
    fetch( "/board", option )
        .then( response => response.json()) // 결과물 
        .then( data => { console.log( data ) } )
        .catch( error => { console.log( error ) } );
        
}

// 2. 조회
const boardPrint = () => {
    console.log("목록조회 실행");
    let option ={ 
        method : "GET"
    }
    fetch( "/board", option )
        .then( response => response.json() )
        .then( data => { console.log(data) } )
        .catch( e => { console.log(e)} )
}

// 3. 삭제
const boardDelete = () => {
    console.log("삭제실행")
    let bno = 3;
    option = {
        method : "DELETE"
    }
    fetch( `/board?bno=${bno}`, option )
        .then( response =>{ response.json()} )
        .then( data => {console.log( data )} )
        .catch( e => { console.log( e )} )
}

// 4. 수정
const boardUpdate = () =>{
    console.log( "수정실행" );
    let data = { "bno": 2 , "bcontent" : "열심히 잘!! 해야 한다!!" };
    // let bcontent = "열심히 잘!! 해야 한다!!";
    // let bwriter = "온달이";
    option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( data )
    }
    fetch( "/board" , option )
        .then( response => response.json() )
        .then( data => { console.log( data ) } )
        .catch( e => { console.log( e ) } )
}