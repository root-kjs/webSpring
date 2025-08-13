package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository // 스프링 컨테이너 빈 등록
public class MemberDao extends Dao{
    // 1. 회원가입
    public int signUp( MemberDto memberDto ){
        try {
            String sql = "insert into member(mid, mpwd, mname, mphone) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // auto_increment(자동PK) 결과 반환 설정
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());
            int count = ps.executeUpdate();
            if ( count == 1 ) {
                ResultSet rs = ps.getGeneratedKeys(); //// auto_increment(자동PK) 가져오기
                if (rs.next()){
                    int mno = rs.getInt(1);
                    return mno;
                }
            }else return 0;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
        return 0; // 회원 가입 실패
    }// func end

    // 2. 로그인
    
    // 3. 로그아웃

    //


}// class end
