// 1. 대기등록
const waitingAdd = () => {
    console.log("대기등록 실행");
    let data = { "wphone" : "1234" , "wcount" : 100 };
    let option = {
       method : "POST",
       headers : { "Content-Type" : "application/json" },
       body : JSON.stringify( data )
    };
    fetch( "/waiting", option )
        .then( response => response.json() )
        .then( data => { console.log(data)} )
        .catch( e => { console.log(e)} );
}

// 2. 조회
const waitingPrint = () => {
    console.log("대기조회 실행");
    fetch( "/waiting" , { method : "GET" }  )
    .then( response => response.json() )
    .then( data => { console.log( data ) })
    .catch( e => { console.log(e)})
}

// 3. 삭제
const waitingDelete = () => {
    console.log("대기 삭제 실행");
    let wno = 5;
    option = {
        method : "DELETE",
    };
    fetch( `/waiting?wno=${wno}`, option )
        .then( response => response.json() )
        .then( data => { console.log(data)} )
        .catch( e => { console.log( e )} )
}

// 4. 수정
const waitingUpdate = () => {
    console.log( "대기수정" );
    let data = { "wno" : 1, "wphone" : "dddd" , "wcount" : 10000 }
    option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(data)
    }
    fetch( "/waiting" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)} )
        .catch( e => { console.log(e)})
}