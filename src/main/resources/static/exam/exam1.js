console.log("나야 자바스크립트..");

// 1. JS 자료/값
console.log( 3 );
console.log( "메롱" );
console.log( '히히' );
console.log( `안녕` );
console.log( undefined );
console.log( false );
console.log( [2, 3.14, true, '하하hi'] ); // 배열
console.log( function 함수명(){} ); // func end
console.log( {"속성명" : 3, "속성명2" : "속성값2"} ); 객체 = JSON

// 2. 변수/상수 선언 키워드 : let , const
let var1 = 15; // let 변수
const var2 = "상수"; // const 상수

 // 3. 함수 작성
function func1(a, b){
    console.log(" func1 실행 ");
    let c = a + b;
    return console.log(" func1 실행 " + c );;
}// func end

// 4. 함수 실행 1번
let result = func1(2, 3);
console.log( result );

// 5. 함수 실행2. html onclick


// 6. 익명함수
const func2 = function( a , b ){ // 함수명은 없으나 주로 상수나 변수에 저장되어 사용
    console.log( a + b );
}; 

func2( 100 , 200 ); // 익명함수 함수 실핼

// 7. 람다식
const func3 = ( a , b ) => { // 1회성 함수 ( 함수명이 없다 보니.. 람다수(화살표) 함수 )
    console.log( a + b );
}

func3( 50 , 50 ); // 람다수 함수 실핼



