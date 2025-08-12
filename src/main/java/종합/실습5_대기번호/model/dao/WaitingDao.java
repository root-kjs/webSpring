package 종합.실습5_대기번호.model.dao;

import org.springframework.stereotype.Repository;
import 종합.실습5_대기번호.model.dto.WaitingDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// 역할 : 저장소( 실질적인 저장소/엔티티 를 조작코드 ) , DAO , ** JPA, myBatis **
// @Repository : 데이터를 저장하거나 조회, 수정, 삭제하는 작업을 담당하는 클래스에 붙여주는 꼬리표 역할
@Repository // 데이터베이스에 접근하는 클래스를 나타내는 어노테이션
public class WaitingDao extends Dao { // extends Dao : DB연동 Dao 상속

    // 1. 등록
    public boolean waitingWrite( WaitingDto waitingDto ){
        try {
           String sql = "insert into waiting ( wphone, wcount) values (? , ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, waitingDto.getWphone());
           ps.setInt(2, waitingDto.getWcount());
           int count = ps.executeUpdate();
           if( count == 1 ) return true;
           else return false;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
       return false;
    }// func end

    // 2. 전체 조회
    public List<WaitingDto> waitingList( ){
        List<WaitingDto> waitingList = new ArrayList<>();
        try {
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                WaitingDto waitingDto = new WaitingDto( );
//                int wno = rs.getInt("wno");
//                String wphone = rs.getString("wphone");
//                int wcount = rs.getInt("wcount");
//                WaitingDto waitingDto = new WaitingDto( wno, wphone, wcount );
                waitingDto.setWno(rs.getInt("wno"));
                waitingDto.setWphone(rs.getString("wphone"));
                waitingDto.setWcount(rs.getInt("wcount"));
                waitingList.add( waitingDto );
            }//
        }catch ( Exception e ){ System.out.println("[예외발생]" + e ); }
        return waitingList;
    }//func end
    
    // 3. 특정대기 조회(개별조회)
    public WaitingDto waitingFind( int wno ){
        WaitingDto waitingDto = new WaitingDto();
        try{
            String sql ="select * from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            ResultSet rs = ps.executeQuery();
            if( rs.next()){
                waitingDto.setWno(rs.getInt("wno"));
                waitingDto.setWphone(rs.getString("wphone"));
                waitingDto.setWcount(rs.getInt("wcount"));
            }
        }catch (Exception e){
            System.out.println("[예외발생]" + e);
        }
        return waitingDto;
    }

    // 4. 특정대기 삭제
    public boolean waitingDelete( int wno ){
       try{
           String sql ="delete from waiting where wno = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, wno);
           int count = ps.executeUpdate();
           if( count == 1 ) return true;
           else return false;
       }catch ( Exception e ){
           System.out.println("[예외발생]" + e);
       }
       return false;
    }// func end


    // 5. 특정대기 수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
      try {
        String sql = "update waiting set wphone = ?, wcount = ? where wno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, waitingDto.getWphone());
        ps.setInt(2, waitingDto.getWcount());
        ps.setInt(3, waitingDto.getWno());
        int count = ps.executeUpdate();
        if ( count == 1 ) return true;
        else return false;
      }catch ( Exception e ){
          System.out.println("[예외발생]" + e);
      }
      return false;
    }//func end


}// class end
