package 종합.실습4_대기번호;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    // 싱글톤
    @Getter
    private static final WaitingDao instance = new WaitingDao();
    private WaitingDao(){ connect(); }

    //DB연동
    private String db_url = "jdbc:mysql://localhost:3306/waiting10";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
    }
    
    // 1.등록
    public boolean waitingAdd( WaitingDto waitingDto){
        try {
            String sql = "insert into waiting (wphone, wcount) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getWphone());
            ps.setInt(2, waitingDto.getWcount());
            int count = ps.executeUpdate();
            if( count ==1 ) return true;
            else return false;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }// func end
    
    // 2.조회
    public List<WaitingDto> waitingList(){
        List<WaitingDto> list = new ArrayList<>();
        try{
            String sql ="select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next()){
            WaitingDto waitingDto = new WaitingDto(
                rs.getInt("wno"),
                rs.getString("wphone"),
                rs.getInt("wcount")
                );
            list.add( waitingDto );
            }
        }catch ( Exception e ){
            System.out.println(e);
        }
        return list;
    }// func end

}// class end
