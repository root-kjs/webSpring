package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

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
            }
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
        return 0; // 회원 가입 실패
    }//func end

    // 2. 로그인
    public int login( MemberDto memberDto){
        try {
            String sql = " select * from member where mid = ? and mpwd = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getMid());
            ps.setString(2,memberDto.getMpwd());
            ResultSet rs = ps.executeQuery(); // 조회는 ResultSet , executeQuery()
            if( rs.next()){
                int mno = rs.getInt("mno");
                return mno;
            }
        }catch (Exception e){
            System.out.println("[예외발생]" + e);
        }
        return 0;
    }//func end

    // 3. 로그아웃

    // 4. 내정보
    public MemberDto info( int mno ){
        MemberDto memberDto = new MemberDto();
        try {
            String sql = "select * from member where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ResultSet rs = ps.executeQuery();
            if ( rs.next()){
                memberDto.setMno(rs.getInt("mno"));
                memberDto.setMid(rs.getString("mid"));
                memberDto.setMname(rs.getString("mname"));
                memberDto.setMphone(rs.getString("mphone"));
                memberDto.setMdate(rs.getString("mdate"));
               // return memberDto;
            }
        }catch (Exception e){
            System.out.println("[예외발생33]" + e);
        }
        return memberDto;
    }// func end
    // 5. 중복검사
    public boolean check( String type, String data ){
        try {
            // String sql = "select * from member where mid = ? ";
            // String sql = "select * from member where mphone = ? ";
            String sql = "select * from member where "+type+"=?"; // 띄어쓰기 주의!
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            if( rs.next()) return true;

        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }// func end


    // 6. 회원정보 수정
    public boolean update( MemberDto memberDto ){
        try {
            String sql="update member set mname = ? , mphone = ? where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();
            if ( count == 1 ) return true;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }//func end


    // 7. 비밀번호 수정
    public boolean updatePassword( int mno,  Map<String , String> map ){
        try {
            String sql="update member set mpwd = ? where mno = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, map.get("newpwd"));
            ps.setInt(2, mno);
            ps.setString(3, map.get("oldpwd"));
            int count = ps.executeUpdate();
            if( count == 1 ){ return true; }
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }//func end

    // 8. 회원탈퇴
    public boolean delete( int mno, String oldpwd ){
        try {
            String sql ="delete from member where mno = ? AND mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ps.setString(2, oldpwd);
            return ps.executeUpdate() == 1;
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return false;
    }//func end


}// class end
