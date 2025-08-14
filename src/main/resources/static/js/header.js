console.log("해더 js 시작");

// 1. 내정보 요청해서 메뉴 나누기
const myinfo = async() =>{
    // 어디에
    const logMenu = document.querySelector(".user_menu");
    // 무엇을
    let html ="";
    try{
        // 1. 옵션
        const option = { method : "GET" }
        // 2. 응답
        const response = await fetch("/member/info" , option )
        // 3. 데이터 
        const data = await response.json(); 
        console.log(data); // 로그인 회원정보 확인용!

        html += 
        `<li><span> ${data.mid} 님 100 point</span></li>
        <li><a href="/member/info.jsp">마이페이지</a></li>
        <li><a href="#" onclick="">로그아웃</a></li> `
    }catch{
       // alert("회원정보가 없습니다.")
       
        html += 
        ` <li><a href="/member/login.jsp">로그인</a></li>
        <li><a href="/member/signup.jsp">회원가입</a></li>`
    }

    logMenu.innerHTML = html;


}//func end
myinfo();

// 2. 로그아웃
const logout = async() => {
   try{ 
    // 1. 옵션
    const option = { method : "GET" }
    // 2. 응답
    const response = await fetch("/member/logout" , option )
    // 3. 데이터 
    const data = await response.json()
    if(data == true){
        alert("로그아웃되었습니다.");
    }
    }catch{

    }
}//func end