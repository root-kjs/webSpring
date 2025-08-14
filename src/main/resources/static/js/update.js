console.log("내 정보수정 js 시작");

//1. 내정보 수정
const updateUser = async() => {
    console.log("내정보 수정 js 실행");

    try{
        const option = { method : "GET" }
        const response = await fetch( "/member/info" , option );
        const data = await response.json();
       
        document.querySelector(".mno").innerHTML=data.mno;
        document.querySelector(".mid").innerHTML=data.mid;
        document.querySelector(".mnameInput").value=data.mname;
        document.querySelector(".mphoneInput").value=data.mphone;
        document.querySelector(".mdate").innerHTML=data.mdate;
    
    }catch(e){ 
        console.log(e); //location.href="/member/login.jsp";// 비로그인 경우 로그인 페이지로
    }

    const mname = document.querySelector(".mnameInput").value;
    const mphone = document.querySelector(".mphoneInput").value;

    const obj = { mname, mphone }
  
    try{
        const option = { 
            method : "PDST" ,
            headers : { "Content-Type":"application/json"},
            body : JSON.stringify(obj)

        }
        const response = await fetch( "/member/update" , option );
        const data = await response.json();
       
       if( data == true ){
        alert("회원 정보수정되었습니다.");
       }else{
        alert("올바른 정보를 입력하세요");
       }
    
    }catch(e){ 
        console.log(e); location.href="/member/login.jsp";// 비로그인 경우 로그인 페이지로
    }

}// func end
updateUser();

