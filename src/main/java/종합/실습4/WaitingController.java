package 종합.실습4;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/waiting")
@RestController
public class WaitingController {
    // 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    //1. 등록
    @PostMapping("/add")
    public boolean waitingAdd( @RequestBody WaitingDto waitingDto ){
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingAdd( waitingDto );
        return result;
    }
    
    //2. 조회
    @GetMapping("/list")
    public List<WaitingDto> waitingList(){
        System.out.println("waitingDao = " + waitingDao);
        List<WaitingDto> result = waitingDao.waitingList();
        return result;
    }

}// class end

