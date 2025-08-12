package exam.d3_0801;

// AppStart --> 스프링 실행과 동시에 같은 패키지/하위 패키지 내 모든 컴포넌트 스캔 자동 빈(객체) 등록
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller // 스프링에게 Controller 알림, 택배상자의 내용물이 아닌 라벨 역할
@RestController
public class RestController1 {

    @GetMapping( "/d3" ) // http(웹통신 규약) 중에서 'Get' method 사용, base url 뒤에 자원 url 정의
    // URL : http://localhost:8080/d3
    // Whitelabel Error Page: 요청은 정상이지만 , 응담은 없다.
    // @ResponseBody // http 요청에 따른 처리 후 응답을 자바타입에서 http
    // Talend API : 브라우저 주소탕에선 Get 방식만 가능하여 ,  CRUD 테스트릉 지원하기 위해
    // @ResponseBody 안붙이면 --> Whitelabel Error Page:
    public String m1(){
        return "자바에서 보내온 메시지~";
    }//class end

    // 메소드에서
    @GetMapping("/d3/param1")
    public boolean m2( @RequestParam( name = "name" ,/*defaultValue = "홍길동",*/ required = true) String name ){
        System.out.println("RestController1.m2"); // 현재 메소드명 출력
        System.out.println("name = " + name); // 현재 매개변수 출력
        return true;
    }

    @GetMapping("/d3/param2")
    public int m3( String name, int age ){
        System.out.println("RestController1.m3");
        System.out.println("name = " + name + ", age = " + age);
        return 3;
    }

    @DeleteMapping("/d3/param3")
    public int m5( @ModelAttribute TaskDto taskDto ){ // @RequestParam  --> 안되는게 맞아... @ModelAttribute
        System.out.println("RestController1.m5");
        System.out.println("taskDto = " + taskDto);
        return 4;
    }
    @PostMapping("/d3/param4")
    public boolean m6( @RequestBody TaskDto taskDto ){
        System.out.println("taskDto = " + taskDto);
        System.out.println("RestController1.m6");
        return true;
    }


    @PutMapping("/d3/param2")
    public int m7( @RequestBody Map<String, String > map){
        System.out.println("RestController1.m7");
        System.out.println("map = " + map);
        return 3;
    }

    /*
    * 1) 쿼리스트링이란 ? URL경로상의 매개변수 표현 , 매개변수 노출O , 보안 위험 ,  URL?매개변수=값&매개변수=값
    * 2) BODY(본문)이란 ? HTTP본문에 매개변수 표현 , 매개변수 노출X , 보안 안전 , POST/PUT 에서 JSON타입으로 객체 지원

                    @RequestParam                           vs        @ModelAttribute                           vs    @RequestBody
    역할            단일 파라미터에 변수 바인딩                           복수 파라미터에 객체 바인딩                         본문(body) 객체 바인딩
    생략기준         변수명이 일치할경우(쿼리스트링의매개변수명)             DTO 타입일때 기본적용(+생성자,+Setter)              DTO
    주요타입         기본형:int/String/List/Map                         DTO(개발자가만든객체)                              DTO/List/Map
    처리가능요청     쿼리스트링, <form:첨부파일x>                         쿼리스트링,<form:첨부파일o>                        본문(body)
    HTTP메소드      GET/POST/PUT/DELETE                                GET/POST/PUT/DELETE                             POST/PUT

    */

}//class end
