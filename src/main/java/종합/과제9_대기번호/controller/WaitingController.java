package 종합.과제9_대기번호.controller;

import org.springframework.web.bind.annotation.*;
import 종합.과제9_대기번호.model.dao.WaitingDao;
import 종합.과제9_대기번호.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController
public class WaitingController {

    // 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 등록
    @PostMapping("/waiting")
    public boolean waitingAdd( @RequestBody WaitingDto waitingDto ){
        boolean result = waitingDao.waitingAdd( waitingDto );
        return result;
    }// func end

    // 2. 조회
    @GetMapping("/waiting")
    public ArrayList<WaitingDto> waitingAdd(  ){
        ArrayList<WaitingDto> waitingList = waitingDao.waitingPrint();
         return waitingList;
    }// func end

    
    // 3. 삭제
    @DeleteMapping("/waiting")
    public boolean waitingDelete( @RequestParam int wno ){
        boolean result = waitingDao.waitingDelete(wno);
        return result;
    }
    // 4. 수정
    @PutMapping("/waiting")
    public boolean waitingUpdate( @RequestBody WaitingDto waitingDto ){
        boolean result = waitingDao.waitingUpdate( waitingDto );
        return result;
    }


}// class end
