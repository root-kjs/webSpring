package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {

    @Autowired private MemberDao memberDao; // DI 주입, @Autowired : 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내오기)

    // 1. 회원가입
    public int signUp( MemberDto memberDto ){
        System.out.println("memberDto = " + memberDto);
        int result = memberDao.signUp( memberDto );
        return result;
    }// func end

}// class end
