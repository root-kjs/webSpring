package exam.d7_0807;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    @Getter // 해당하는 멤버변수만 제공받을 수 있다
    private static final StudentDao studentDao = new StudentDao();
    private StudentDao(){ connect(); }
    public static StudentDao getInstance(){return  studentDao; }

    private String db_url = "jdbc:mysql://localhost:3306/spring07";
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

    // 1. 저장
    public boolean save( StudentDto studentDto ){
        try {
            String sql ="insert into student(sname, skor, smath) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentDto.getSname());
            ps.setInt(2, studentDto.getSkor());
            ps.setInt(3, studentDto.getSmath());
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
            //else return false;
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
        return false;
    }// func end

    // 2. 조회
    public List<StudentDto> find(){
        List<StudentDto> list = new ArrayList<>();
        try {
            String sql ="select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next()) {
                // DB 하나의 레코드를 DTO에 대입( 객체 생성 )하여 읽을 준비!
                StudentDto studentDto = new StudentDto(
                    rs.getInt(1),
                    rs.getString("sname"),
                    rs.getInt("skor"),
                    rs.getInt("smath"),
                    rs.getString("sdate")
                );
                list.add( studentDto );
            }
        }catch ( Exception e ){
            System.out.println("[예외발생]" + e);
        }
        return list;
    }// func end

}//class end