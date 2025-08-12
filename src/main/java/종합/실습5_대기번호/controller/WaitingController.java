package 종합.실습5_대기번호.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.실습5_대기번호.model.dto.WaitingDto;
import 종합.실습5_대기번호.service.WaitingService;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/waiting")
@RestController  // 역할 : [주] HTTP 통신(요청/응답) , 매개변수/반환 타입 관리 변환 , VIEW 와 SERVICE 중계
public class WaitingController {
    // @Autowired : 스프링 *컨테이너에 등록* 된 빈(객체)를 꺼내온다.
    @Autowired private WaitingService waitingService; // 싱글톤 대신에 사용 가능. Service 호출!

    // 1. 등록
    @PostMapping("/write")
    public boolean waitingWrite( @RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingWrite( waitingDto );
        return result;
    }// func end

    // 2. 전체조회
    @GetMapping("/list")
    public List<WaitingDto> waitingList(  ){
        System.out.println("WaitingController.waitingList");
        System.out.println("waitingService = " + waitingService);
        List<WaitingDto> result = waitingService.waitingList();
        return result;
    }// func end

    // 3. 특정조회
    @GetMapping("/find")
    public WaitingDto waitingFind(@RequestParam  int wno ){
        System.out.println("WaitingController.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingService.waitingFind( wno );
        return result;
    }// func end

    // 3. 특정 삭제
    @DeleteMapping("") // localhost:8080/board?wno=2, 경로 주의!!!
    public boolean waitingDelete( @RequestParam int wno ){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingService.waitingDelete(wno);
        return result;
    }// func end

    // 4. 특정 수정
    @PutMapping("") // localhost:8080/board, 경로 주의!!!
    public boolean waitingUpdate( @RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingUpdate( waitingDto );
        return result;
    }// func end

}// class end