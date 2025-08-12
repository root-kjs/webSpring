package exam.d2_0731._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller //@Conponent 포함됨
public class RestController2 {


    // 반환타입 있는 REST

    /* http://localhost:8080/d2_0731/task"*/
    @GetMapping("/d2_0731/task") // @xxxMapping("주소정의") http 메소드 주입됨!
    @ResponseBody // 자바는 int를 알지만 웹은 int 몰라요..
    public int method1(){
       System.out.println("RestController2.method1");
        return 100;
    }


    @GetMapping("/d2_0731/task1") // @xxxMapping("주소정의") http 메소드 주입됨!
    @ResponseBody // 자바는 String를 알지만 웹은 String 몰라요..
    public String method2(){
        System.out.println("RestController2.method2");
        return "hhhi";
    }

    @PostMapping("/d2_0731/task2") // 어노테이션이 다르면 주소같아도 됨
    @ResponseBody // 자바는 Map<String, Integer> 알지만 웹은 Map<String, Integer> 몰라요..
    public Map<String, Integer> method3(){
        System.out.println("RestController2.method3");
        Map<String, Integer> map = new HashMap<>();
        map.put("유재석", 100);
        map.put("강호동", 50);
        return map;
    }

    @PutMapping("/d2_0731/task") // Talend CRUD 메소드가 다르면 주소같아도 됨
    @ResponseBody// 자바는 Map<String, Integer> 알지만 웹은 Map<String, Integer> 몰라요..
    public boolean method4(){
        System.out.println("RestController2.method4");
        return true;
    }

    //
    @DeleteMapping("/d2_0731/task")
    @ResponseBody  //없으면 웹통신 안됨
    public TaskDto method5(){
        System.out.println("RestController2.method5");
        TaskDto taskDto = new TaskDto();
        return taskDto;
    }

    @GetMapping("/d2_0731/task3")
    @ResponseBody
    public ArrayList<TaskDto> method6(){
        System.out.println("RestController2.method6");
        ArrayList<TaskDto> list = new ArrayList<>();
        list.add( new TaskDto() );
        list.add( new TaskDto() );
        return list;
    }


}// class end
