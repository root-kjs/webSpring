package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    // 1. 회원가입
    @PostMapping("/signup")
    public int signUp( @RequestBody MemberDto memberDto ){
        System.out.println("memberDto = " + memberDto);
        int result = memberService.signUp( memberDto );
        return result;
    }// func end


    // 2. 로그인
    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpServletRequest request){
        System.out.println("memberDto = " + memberDto);
        HttpSession session = request.getSession(); // 세션 정보 가져오기
        int result = memberService.login( memberDto );
        if( result > 0  ){
            session.setAttribute("loginMno", result );
        }
        return result;
    }//func end

    // 3. 로그아웃
    @GetMapping("/logout") // 세션은 서버를 재시작하면 초기화 됨. 
    public boolean logout( HttpServletRequest request ){
        System.out.println("MemberController.logout");
        HttpSession session = request.getSession(); // 서버 내 저장소
        // 유효성 검사 진행
        if( session == null || session.getAttribute("loginMno") == null ){
            return false; // 비로그인 상태
        }
        session.removeAttribute("loginMno"); // 로긴 상태이면 속성값 제거
        return true;
    }//func end

    // 4. 내정보
    @GetMapping("/info")
    public MemberDto info( HttpServletRequest request ){
        HttpSession session = request.getSession();
        if ( session == null || session.getAttribute("loginMno") == null){
            return null;
        }
        Object object = session.getAttribute("loginMno");// 세션 속성값 호출
        // Object 최상위 클래스로서 모든 자료를 저장한다. 세션은 Object로 저장한다.
        // 세션은 모든 자료의 타입을 저장 할 수 있다.
        int loginMno = (int) object; // 강제 타입변환. 세션값의 원래 타입으로 변경(mno)
        MemberDto result = memberService.info( loginMno ); // 서비스에게 전달하고 리턴값 받음
        System.out.println("result = " + result);
        return result;
    }//func end

    // 5. 중복 검사
    @GetMapping("/check")
    public boolean check(@RequestParam String type, @RequestParam String data ){
        boolean result = memberService.check( type,data );
        return result;
    }//func end

    // 6. 회원정보 수정
    @PutMapping("/update")
    public boolean update( @RequestBody MemberDto memberDto, HttpServletRequest request ){
        HttpSession session = request.getSession();
        if( session == null || session.getAttribute("loginMno") == null ){
            return false;
        }
        Object object = session.getAttribute("loginMno");
        int loginMno = (int) object;
        memberDto.setMno( loginMno ); // dto에 담아주기!
        boolean result = memberService.update(memberDto);
        return result;
    }//func end


    // 7. 비밀번호 수정
    @PutMapping("/update/password")
    public boolean updatePassword( @RequestBody Map<String , String> map, HttpServletRequest request ){
        HttpSession session = request.getSession(); // mno 를 세션으로 매개변수 받기 때문에.
        if( session == null || session.getAttribute("loginMno") == null){
            return false;
        }
        Object object = session.getAttribute("loginMno");
        int loginMno = (int) object;
        boolean result = memberService.updatePassword( loginMno , map );
        return result;
    }//func end

    // 8. 회원탈퇴
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String oldpwd , HttpSession session){
        if( session  == null || session.getAttribute("loginMno") == null ) return false;
        int loginMno = (int) session.getAttribute("loginMno");
        return memberService.delete( loginMno, oldpwd);
    }//func end

}// class end
