console.log("공공데이터 js 시작");

// 사업자 진위 여부 
// https://www.data.go.kr/data/15081808/openapi.do#tab_layer_detail_function
//일반 인증키
// (Encoding)	
// JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D
// 일반 인증키
// (Decoding)	
// JbK3US3dccf5+z+Qig8jxLUU4s+MMlps5+xExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8/VKEBLRLv5e0Q==


const dataAPI2 = async() => {

        const b_no = document.querySelector(".b_no").value;

        let obj = { // 중복 가능한 변수 타입, 과거에 많이 사용함.최근에는 let
            "b_no":  [b_no] //6408101354
            }
        const option={
            method : "POST",
            headers : {"Content-Type":"application/json"},
            body : JSON.stringify(obj)
        }
    // 1. 요청 URL
    const serviceKey ="JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D";
    const URL ="https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey="
        const response = await fetch( URL+serviceKey, option );
        const data = await response.json();
        console.log(data.data[0]['tax_type']);// 확인 // 특수문자가 들어간 경우에는 [''] 이렇게 사용-->. 접근연산자 사용 불가능!
        alert( data.data[0]['tax_type'] );
            
    }
// 인천시 부평구 주유소 현황
//     일반 인증키
//     (Encoding)
//     JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D
//     <br/>
//     일반 인증키
//     (Decoding)	
//     JbK3US3dccf5+z+Qig8jxLUU4s+MMlps5+xExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8/VKEBLRLv5e0Q==

const dataAPI1 = async() => {
    // 1. 요청 URL
    const serviceKey ="JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D";
    const URL ="https://api.odcloud.kr/api/15102672/v1/uddi:d26dabc4-e094-463d-a4b1-cab3af66bb6d?page=1&perPage=38&serviceKey="
    // 2. fetch
    const option = { method : "GET" }
    const response = await fetch( URL+serviceKey, option);
    const data = await response.json();
    //console.log( data ); // 응답 객체
    // 요청 결과값은 콘솔 출력후 분석하여 사용한다. 
    // perPage --> 페이지당 가져올 데이터 수
    // data : 실질적인 데이터가 들어오은 속성명
     console.log( data.data ); // 진짜 데이터 , 앞의 데이터는 


    // 어디에
     const dataTbody = document.querySelector("#dataTbody");
     let html = "";

    
     data.data.forEach( (value) => {
       html+= `<tr>
        <td>${ value.연번 }</td>
        <td>${ value.상호 }</td>
        <td>${ value.업종 }</td>
        <td>${ value.전화번호 }</td>
        <td>${ value['주소'] }</td>
       </tr> 
       `
     });

     dataTbody.innerHTML = html;
}
dataAPI1();// 출력