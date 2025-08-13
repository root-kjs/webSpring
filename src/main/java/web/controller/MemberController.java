package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.MemberDto;
import web.service.MemberService;

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

}// class end
