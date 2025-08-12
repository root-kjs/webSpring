package 종합.실습5_대기번호.model.dao;

import 종합.과제9_대기번호.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {
    // 싱글톤
    private WaitingDao(){ connectDB(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){ return instance; }

    // DB연동 정보
    private String db_url = "jdbc:mysql://localhost:3306/waitingDB_9";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn; // DB 연동결과를 조작하는 인터페이스
    
    // DB연동 함수
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 가져오기
            conn = DriverManager.getConnection( db_url, db_user, db_password );
        }catch ( ClassNotFoundException e ){
            System.out.println("[경고] DB 드라이버 연동 실패!" + e);
        }catch ( SQLException e ){
            System.out.println("[경고] DB연동 실패!" + e );
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
    }//func end

    // 1. 등록
    public boolean waitingAdd( WaitingDto waitingDto ){
        try {
            // 1. SQL 작성
            String sql = "insert into waiting( wphone, wcount ) values( ?,? )";
            // 2. SQL 게시
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setString(1, waitingDto.getWphone());
            ps.setInt(2,waitingDto.getWcount());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 실행결과에 대한 로직/출력
            if ( count == 1) return true;
            else return false;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e );
        }// catch end
        return false;
    }// func end

    // 2. 조회
    public ArrayList<WaitingDto> waitingPrint( ){
        ArrayList<WaitingDto> waitingList = new ArrayList<>();
        try {
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                int wno = rs.getInt("wno");
                String wphone = rs.getString("wphone");
                int wcount = rs.getInt("wcount");
                WaitingDto waitingDto = new WaitingDto( wno,wphone, wcount );
                waitingList.add( waitingDto );
            }//
        }catch ( Exception e ){ System.out.println("[예외발생]" + e ); }
        return waitingList;
    }//func end

    // 3. 삭제
    public boolean waitingDelete( int wno ){
        try {
            String sql ="delete from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, wno);
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
            else return false;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }// catcj end
        return false;
    }// func end


    // 4. 수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try {
            String sql ="update waiting set wcount = ? where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, waitingDto.getWcount());
            ps.setInt(2, waitingDto.getWno());
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
            else return false;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e );
        }//catch end
        return false;
    }//func end


}// class end
