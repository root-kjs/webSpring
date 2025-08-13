package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.util.Map;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {

    @Autowired private MemberDao memberDao; // DI 주입, @Autowired : 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내오기)

    // 1. 회원가입
    public int signUp( MemberDto memberDto ){
        System.out.println("memberDto = " + memberDto);
        int result = memberDao.signUp( memberDto );
        return result;
    }// func end


    // 2. 로그인
    public int login( MemberDto memberDto){
        System.out.println("MemberService.login");
        int result = memberDao.login( memberDto );
        return result;
    }//func end

    // 3. 로그아웃

    // 4. 내정보
    public MemberDto info( int mno ){
        System.out.println("MemberService.info");
        MemberDto result = memberDao.info( mno );
        return result;
    }//func end

    // 5. 중복 검사
    public boolean check( String type, String data ){
        boolean result = memberDao.check(type,data );
        return result;
    }//func end


    // 6. 회원정보 수정
    public boolean update( MemberDto memberDto ){
        boolean result = memberDao.update(memberDto);
        return result;
    }//func end

    // 7. 비밀번호 수정
    public boolean updatePassword( int mno,  Map<String , String> map ){
        boolean result = memberDao.updatePassword( mno , map );
        return result;
    }

    // 8. 회원탈퇴
    public boolean delete( int mno, String oldpwd ){
        boolean result = memberDao.delete(mno, oldpwd);
        return result;
    }//func end


}// class end
