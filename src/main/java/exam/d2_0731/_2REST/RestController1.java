package exam.d2_0731._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class RestController1 {
    //싱글통 생략 : @Controller --> @Component 포함되서 자동으로 싱글톤처럼 하나의 객체를 생성해준다.
    
    // Spring REST ?  CRUD 기능을 HTTP로 제공하는 아키텍처/기술/구조
    /*
    1) 등록 : CREATR --> @PostMapping
    
    2) 조회 : Read --> @GetMapping
    
    3) 수정 : Update --> @PutMapping
    
    4) 삭제 : Delete --> @DeleteMapping
    
    Scheme :// Host [ ":" Port ] [ Path [ "?" Query ]]
     */
    @PostMapping  //Scheme :// Host [ ":" Port ] [ Path [ "?" Query ]]
    public void 등록하기(){
        System.out.println("RestController1.등록하기");
    }
    @GetMapping
    public void 조회하기(){
        System.out.println("RestController1.조회하기");
    }
    @PutMapping
    public void 수정하기(){
        System.out.println("RestController1.수정하기");
    }
    @DeleteMapping
    public void 삭제하기(){
        System.out.println("RestController1.삭제하기");
    }


}
