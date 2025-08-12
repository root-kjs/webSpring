package exam.d2_0731._실습1_REST;
/*
Spring 실습1 : 게시판 RestController 만들기_250731(목)
    1. AppStart 클래스 생성    2. BoardController 클래스 생성
    3. 각 URL 매핑 만들기
        1. 글쓰기           POST       "/exam1/board"
        요청자료 : x , 응답자료 : true/false

        2. 전체 글 조회      GET        "/exam1/board"
        요청자료 : x , 응답자료 : 임의의 List 타입 ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ] , 아래 참고

        3. 개별 글 조회      GET        "/exam1/board/view"
        요청자료 : x , 응답자료 : 임의의 MAP  타입  ,  {bno:'',btitle:''} , 아래 참고

        4. 개글 글 수정      PUT        "/exam1/board"
        요청자료 : x , 응답자료 : true 또는 false

        5. 개별 글 삭제      DELETE     "/exam1/board"
        요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3
제출 :
   1. 카카오톡방에 ip 제출 ( 강사가 체크 할때 까지 서버 켜주세요 )
   2. itdanja.com에 과제 코드 git 링크 제출

 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    //1.글쓰기           POST       "/exam1/board"
    @PostMapping("/exam1/board")
    @ResponseBody
    public boolean write(){
        System.out.println("BoardController.write");
        return true;
    }

//    2. 전체 글 조회      GET        "/exam1/board"
//    요청자료 : x , 응답자료 : 임의의 List 타입 ,  [ {bno:'',btitle:''} ,  {bno:'',btitle:''}  ] , 아래 참고

    @GetMapping("/exam1/board")
    @ResponseBody
    public List< BoardDto > print(){
        System.out.println("BoardController.print");
        List<BoardDto> list = new ArrayList<>();
        list.add( new BoardDto() );
        list.add( new BoardDto() );
        return list;
    }
//        3. 개별 글 조회      GET        "/exam1/board/view"
//    요청자료 : x , 응답자료 : 임의의 MAP  타입  ,  {bno:'',btitle:''} , 아래 참고
//    @GetMapping("/exam1/board/view")
//    @ResponseBody
//    public Map< String, BoardDto > view(){
//        System.out.println("BoardController.view");
//        Map< String, BoardDto > map = new HashMap<>();
//        map.put( "bno", new BoardDto());
//        map.put( "btitle", new BoardDto());
//        return map;
//    }

    @GetMapping("/exam1/board/view")
    @ResponseBody
    public Map< String, String > view(){
        System.out.println("BoardController.view");
        Map< String, String > map = new HashMap<>();
        map.put( "bno", "" );
        map.put( "btitle", "" );
        return map;
    }



//        4. 개글 글 수정      PUT        "/exam1/board"
//    요청자료 : x , 응답자료 : true 또는 false
    @PutMapping("/exam1/board")
    @ResponseBody
    public boolean upadte() {
        System.out.println("BoardController.upadte");
        return false;
    }




//            5. 개별 글 삭제      DELETE     "/exam1/board"
//    요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3

    @DeleteMapping("/exam1/board")
    @ResponseBody
    public int deledt(){
        System.out.println("BoardController.deledt");

        return 3;
    }


}// class end
