package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    // DB연동 정보
    private String db_url = "jdbc:mysql://localhost:3306/springweb";
    private String db_user = "root";
    private String db_password = "1234";

    // [DB연동 멤버변수] * 하위클래스를 사용할수 있게 public 으로 사용.
    public Connection conn; // DB 연동결과를 조작하는 인터페이스

    // DB연동 함수 실행할 수 있는 생성자 작성
    public Dao(){ connectDB(); }

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
}