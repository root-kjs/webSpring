console.log("마이페이지 js 시작");

//1. 내정보 조회
const onInfo = async() => {
    console.log("내정보 조회 js 실행");
  
    try{
        const option = { method : "GET" }
        const response = await fetch( "/member/info" , option );
        const data = await response.json();
       
        document.querySelector(".mno").innerHTML=data.mno;
        document.querySelector(".mid").innerHTML=data.mid;
        document.querySelector(".mname").innerHTML=data.mname;
        document.querySelector(".mphone").innerHTML=data.mphone;
        document.querySelector(".mdate").innerHTML=data.mdate;
    
    }catch(e){ 
        console.log(e); //location.href="/member/login.jsp";// 비로그인 경우 로그인 페이지로, 에러 발생시 로케이션 주석 처리하고 확인!
    }

}// func end

onInfo();

//2. 회원탈퇴
const deleteUser = async() => {
    console.log("회원탈퇴 js 실행");
     let result = confirm("정말 탈퇴하시겠습니까?");
     if( result == false ) return; // 취소 버튼 누르면 함수 종료
     // 
     let oldpwd = prompt(" 현재 비번 입력 : ")
     try{
        const option = { method : "DELETE" };
        const response = await fetch( `/member/delete?oldpwd=${oldpwd}` , option );
        const data = await response.json(); 
        if( data == true ){ alert("회원 탈퇴 성공!"); location.href="/index.jsp"; }
        else{ alert("회원 탈퇴 실패 : 비번 불일치");  }

     }catch(e){
        console.log(e); 

     }

}// func end
