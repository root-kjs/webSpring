package 종합.실습5_대기번호.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.실습5_대기번호.model.dao.WaitingDao;
import 종합.실습5_대기번호.model.dto.WaitingDto;

import java.util.List;

// @Service : CRUD , 데이터 검증 , 연산 , 알고리즘 , *트랜잭션* 등 , SQL 제외한 실질적인 로직
@Service // 역할 : 비지니스로직( 기능에 있어서 실질적인 중요 코드)
public class WaitingService {

    @Autowired private WaitingDao waitingDao; // 싱글톤 대신 사용

    // 1. 등록 // 매개변수 DTO
    public boolean waitingWrite( WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingWrite( waitingDto );
        return result;
    }//func end
    
    // 2. 전체조회
    public List<WaitingDto> waitingList(){
        System.out.println("WaitingService.waitingList");
        System.out.println("waitingDao = " + waitingDao);
        List<WaitingDto> result = waitingDao.waitingList();
        return result;
    }//func end
    
    // 3. 특정조회
    public WaitingDto waitingFind( int wno ){
        System.out.println("WaitingService.waitingView");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingDao.waitingFind(wno);
        return result;
    }//func end
    
    // 4. 특정삭제
    public boolean waitingDelete( int wno ){
        System.out.println("WaitingService.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingDao.waitingDelete( wno );
        return result;
    }//func end
    
    // 5. 특정수정  // 매개변수 DTO
    public boolean waitingUpdate( WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingUpdate( waitingDto );
        return result;
    }//func end

}// class end
