package exam.d3_0801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // 스프링기본셋팅 + 컴포넌트 실행 + 내장톰캣(서버) 실행
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class ); // AppStart 1개만 실행 할 것!
    }//main end
}//class end
