package exam.d7_0807;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@(어노테이션) : 추가적인 정보를 제공하는 메타데이터 역할, 실질적인 기능(스프링) 제공,
//              인터페이스, 실질 기능을 처리하는 아이는 다운로드 받은 라이브러리에서 제공됨.
//@Conponent --> 스프링 컨테이너 메모리에 빈(객체) 등록, 싱글톤과 비슷한 역할
//@Cotroller --> http 요청과 응답 매칭/연결
//@ResponseBody --> http 응답 자료의 "자동"(json)타입 변환
//Rest : json, html 파일을 주고 받음
@RequestMapping("/student")
// @RequestMapping(")지정한 클래스 내 모든 메소드들의 공통 URL
@RestController //@Controller , @Conponent, @ResponseBody
public class StudentController {

    // 0. DAO 싱글톤 불러오기
    private StudentDao studentDao = StudentDao.getInstance();

    // 저장
    @PostMapping("/save")
    // http method가 Post인 요청 매핑
    public boolean save(@RequestBody StudentDto studentDto){
        System.out.println("StudetController.save");
        System.out.println("studentDto = " + studentDto);
        boolean result = studentDao.save( studentDto );
        return true;
    }

    // 조회
    @GetMapping("/find")
    public List<StudentDto> find(){
        System.out.println("StudentController.find");
        List<StudentDto> result = studentDao.find();
        return result;
    }

}// class end