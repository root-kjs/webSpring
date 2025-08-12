package exam.d2_0731._2REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 메인 클래스에 선언 : 스프링부트 환경설정
public class AppStart {
    public static void main(String[] args) {
        /*
        .run() --> static 선언된 스프링 실행 함수
         */
        SpringApplication.run( AppStart.class );
    }
}//  class end
