package exam.d1_0730;

import exam.d1_0730.controller.BoardController;
import exam.d1_0730.model.dto.BoardDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        System.out.println("hi");
        // 1. 20250723 등록 테스트
        boolean result = BoardController.getInstance().boardWrite("테스트내용","강사");
        System.out.println( result );

        // 2. 20250723 전체조회 테스트
        ArrayList<BoardDto> result2 = BoardController.getInstance().boardPrint();
        System.out.println( result2 );

        /* Spring */
        SpringApplication.run( AppStart.class );

    }//main end
}// class end
