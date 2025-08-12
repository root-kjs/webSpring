package exam.d4_0804;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // @Controller + @ReponseBody --> HTTP(클라이언트) 요청과 응답 처리 담당
public class FetchController {

    // TalendAPI : http://localhost:8080/d4/exam1
    // 1, HTTP 정의 , Method : Get (통신의 방법) / url : /d4/exam1
    @GetMapping("/d4/exam1")
    public void m1(){
        System.out.println("FetchController.m1"); // 메소드명 출력 soutm
    }
    
    // 2,
    @PostMapping("/d4/exam2")
    public void m2(){
        System.out.println("FetchController.m2");
    }
    
    // 3.
    @PutMapping("/d4/exam3")
    public void m3(){
        System.out.println("FetchController.m3");
    }
    
    // 4.
    @DeleteMapping("/d4/exam4")
    public void m4(){
        System.out.println("FetchController.m4");
    }

    // 5.매개변수(쿼리스트링) 반환타입(JSON)
    @GetMapping("/d4/exam5")
    // response : 200 / true
    public boolean m5(@RequestParam String name, @RequestParam int age ){
        System.out.println("FetchController.m5");
        System.out.println("name = " + name + ", age = " + age);// 매개변수 자동완성 soutp
        boolean result = true;
        System.out.println("result = " + result); // 가장 가까운 지역변수 출력
        return result;
    }

    // 6.
    @PostMapping("d4/exam6")
    public int m6(@RequestBody Map<String, String> map){
        // taledAPI Body에 입력{ "name":"유재석", "age":"32" } 매개변수로 자바에 들어옴.
        System.out.println("FetchController.m6");
        System.out.println("map = " + map);
        int result = 20; // http Response : body에 20을 반환
        return result;
    }

    // 7.
    @PutMapping("d4/exam7")
    public TaskDto m7(@RequestBody TaskDto taskDto){
        System.out.println("taskDto = " + taskDto);
        System.out.println("FetchController.m7");
        TaskDto taskDto1= new TaskDto("신동엽",50); // Response Body {"name": "신동엽","age": 50}
        return taskDto1;
    }
    //8.
    @DeleteMapping("d4/exam8")
    public List<TaskDto> m8(@RequestParam String name, int age ){ // http에서 매개변수 입력
        System.out.println("FetchController.m8");
        System.out.println("name = " + name + ", age = " + age);
        List<TaskDto> taskDtos = new ArrayList<>();
        taskDtos.add( new TaskDto("콩쥐",10)); // Response Body 출력 
        taskDtos.add( new TaskDto("팥쥐",20));
        return taskDtos;
    }
    
}// class end
