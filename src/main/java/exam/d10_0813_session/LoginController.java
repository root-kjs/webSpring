package exam.d10_0813_session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/d10") // 공통 url
@RestController// http 통신 콘트롤러
public class LoginController {

    // 1. 로그인 : 아이디와 패스워드가 일치하면 회원번호 저장
    // 과거 console
    @PostMapping("/login") // 비밀번호 중요데이터가 있으니쿼리 스트링보다 body사용
    public boolean login(@RequestBody LoginDto loginDto, HttpServletRequest request ){
        // HttpServletRequest : http 요청정보를 갖는 객체
        System.out.println( request.getRemoteAddr() ); // 통신을 요청한 클라이언트의 IP 확인
        System.out.println( request.getRemotePort()); // 통신을 요청한 클라이언트의 port 확인
        System.out.println( request.getHeader("User-Agent")); // 통신을 요청한 클라이언트의 브라우저 정보 확인

        // ********* 세션 정보 가져오기 -> 톰캣 서버내 저장소 MAP 컬렉션 사용
        HttpSession session = request.getSession();
        System.out.println( session.getId() ); // 세션의 식별번호 : 브라우저마다 PC마다 다르게 할당된다.
        // 자동 로그아웃 활용(세션 접속 시간 기록을 확인하여)
        System.out.println( session.getCreationTime() ); // 세션의 생성시간(ms) : 최초 요청한 시간
        System.out.println( session.getLastAccessedTime() ); // 세션의 마지막 접근 시간(ms)
        System.out.println( session.getMaxInactiveInterval()); // 세션의 최대 유효시간(초)

        // **** 세션 속성 추가하기 : 속성이란? 키와 값으로 구성된 메모리 공간
        session.setAttribute( "loginMno" , 3 ); // setAttribute("속성명", 속성값); // 로그인은 set

        return true;
    }
    
    @GetMapping("/info")
    public  boolean info(HttpServletRequest request){
        HttpSession session = request.getSession(); // 요청 서블릿에서 세션정보 꺼내기, 로그인은 get(정보를 가져와야 하니까)
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj; // 타입변환 필요// 톰캣은 재시작하면 모든 세션정보는 초기화
        if( obj == null ){
            System.out.println("로그인 전 상태");
            return false;
        }
        System.out.println( loginMno );
        return true;
    }

    // 로그아웃 : 세션 정보내 속성 제거하기
    @GetMapping("/logout")
    public boolean logout( HttpServletRequest request){
        HttpSession session = request.getSession(); // 세션 정보 가져오기
        session.removeAttribute("loginMno"); // 특정한 속성 제거하기
        return true;
    }

}// class end
