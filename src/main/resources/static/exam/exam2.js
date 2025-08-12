console.log("어서와...exam2.script");

//talendAPI 없이 실제로 통신 함수 만들어보기

// fetch 라이브러리 내장함수
// - 외부 주소로부터 요청과 응답을 지원하는 함수
//  Fetch API는 HTTP 파이프라인을 구성하는 요청과 응답 등의 요소를 JavaScript에서 접근하고 조작할 수 있는 인터페이스를 제공
// fetch는 자바의 controller 와 통신, Dao 와는 안함!
// 자바와의 통신 : 자바에서 선언된 메소드를 가져오기 위해 람다식 함수로 저장하여 가져옴(통신 방법 정의 메소드)

const func1 = () => {
     // fetch( "url" , { methode : "POST"} ) // method가 GET일 경우에는 생략이 가능!
    console.log( "func1실행" );
    fetch( "/d4/exam1" );

 }

 // 2.
const func2 = () => {
    console.log( "func2실행" );
    // fetch( "url" , { methode : "POST"} ) // method가 GET일 경우에는 생략이 가능!
    fetch( "/d4/exam2" , {  method : "POST" } );

 }

 // 3.
 const func3 = () => {
    console.log( "func3실행" );
    // fetch( "url" , { methode : "POST"} ) // method가 GET일 경우에는 생략이 가능!
    fetch( "/d4/exam3" , {  method : "PUT" } );

 }

// 4.
 const func4 = () => {
    console.log( "func4실행" );
    // fetch( "url" , { methode : "POST"} ) // method가 GET일 경우에는 생략이 가능!
    fetch( "/d4/exam4" , {  method : "Delete" } );

 }

 // 5.
 const func5 = () => {
    console.log("func5");
    const name ="충향이";
    const age = 20;
    // 쿼리스트링
    //  fetch( "url" , { methode : "POST"} ) 
    //      .then( 응담매개변수 => 응답매개변수.jason() )
    //      .then( data => { 실행문; } )
    //      .catch( error => { 실행문; } )  --> 통상적으로 사용
    // .then( 응담매개변수 => 응답매개변수.jason() );응답자료를 JSON 타입으로 변환
    // 타입변환된 자료를 매개변수로 받아 시랭문 처리 .then( data => { 실행문; } )

    // 비동기 통신 지원!( fetch _ 순수 JS 내장 / 아작스는 jQuery(안씀) axios( REACT )--> 페이스북 개발/직관적 )
    fetch(`/d4/exam5?name=${name}&age=${age}`,{ method : "GET" }) // 자바 메소드 경로 지정( XXXMapping) 
        .then( responde => responde.json() )       //
        .then( data => { console.log( data ); } ) //
        .catch( errror => { console.error(); } ) // 

 }

 // 6. 
 const func6 = () => {  // PUT/POST는 @RequestBody라서 매개변수를 아래에 제이슨으로 변환하여 보냄.
    const name ="천재";  // 매개변수 선언
    const age = 22;
    // fetch 함수를 이용한 
    const option ={       // 옵션 선언
        method : "POST", // http 메소드( xxxMapping )
        headers : { "Content-Type" : "application/json" }, // 절대 안바뀜! POST, PUT 이 옵션 정보가 많다. ==> @RequestBody ==> headers, body 
        body : JSON.stringify({  name : name, age : age } ) // 타입변환하여 자바에세 전송할 객체 전송 (JSON 타입으로 변환 )
        // JSON.stringfy(); 제이슨 객체를 문자열 타입으로 변환
        // JSON.parse(); 문자열 타입 JS객체(JSON) 변환
    }
    fetch("/d4/exam6" , option )
        .then( Response => Response.json() ) // 타입변환
        .then( data => { console.log ( data ); } )
        .catch( error => { console.log( error) } )

 }

 // 7.
 const func7 = () =>{
    const name = "홍길동";
    const age = 7;
    
    const option ={
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( { name:name, age:age} )
    }
    fetch( "/d4/exam7", option )
        .then( response => response.json()  )
        .then( data => {  console.log( data ) } )
        .catch( e => { console.log(e)} )

 }


 // 8.
const func8 = () =>{
    const name = "홍길동2";  // 클라이언트 단에서 자바로 넘겨주는 매개변수
    const age = 10;

    fetch( `/d4/exam8?name=${name}&age=${age}` , { method : "DELETE" }   )
        .then( r => r.json() )  // 자바에서 넘어오는 반환값(리턴)
        .then( d => { console.log( d );} )
        .catch( e => { console.log(e); } )
}

