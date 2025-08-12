/* 비동기 : 여러개의 흐름  --> then을 이용한 체인 형식
  http 요청을 보내고 응답을 비동기적으로 처리하는 함수 */
const func1 = () => {
     // fetch( "url" , { methode : "POST"} ) // method가 GET일 경우에는 생략이 가능!
    console.log( "[1] 비동기_fetch 전 실행" );
    // fetch(*멀티 스레드 방식 사용)가 실행되고 결과(response)가 오기전에 다음결과로 이동, JS는 응답을 기다리지 않고 자기 할 일함. 그래서 순차적으로 코드 실행되지 않음
    let option = { methode : "GET" };
    fetch("/d6/exam1", option)
        .then( response => response.json())
        .then( data => {console.log(data);
            console.log( "[2] 통신결과" ); }
            )
        .catch( e => { console.log(e) } )
        console.log( "[3] 비동기_fetch 후 실행" );
 }
/*
"async"는 프로그래밍에서 **비동기(asynchronous)**를 의미합니다. 비동기 방식은 작업이 완료될 때까지 기다리지 않고 다음 코드를 실행하는 것을 말합니다.
주로 네트워크 요청이나 파일 읽기 등 시간이 오래 걸리는 작업을 처리할 때 사용되어 프로그램의 효율성을 높입니다.
JavaScript에서는 async 키워드를 함수 앞에 붙여 비동기 함수를 정의하고, await 키워드를 사용하여 비동기 작업의 결과를 기다릴 수 있습니다.
*/
 // ★★★★★★★★ 2. 동기 fetch  : 하나의 흐름( 더 안전 ) ---> ★권장★ --> async / await 를 이용한 동기★★★
const func2 = async () => {
    /* 개별로 프로세스를 나누어줌 */
    console.log( "1. 동기 실행" );
    let option = { methode : "GET" };
    try{   //  더 안전
    const response = await fetch("/d6/exam1", option)
        console.log( "2. 동기 실행" );
        const data = await response.json();
         console.log( "3. 동기 실행" );
        console.log( data );
    } catch( error ){
        console.log(error);
    }

    console.log( "4. 동기 실행" );

 }
