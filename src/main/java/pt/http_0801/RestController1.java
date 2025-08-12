package pt.http_0801;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class RestController1 {

    @PostMapping("/board")
    public boolean boardWrite( @RequestBody BoardDto boardDto ){;
        System.out.println("boardDto = " + boardDto);
        System.out.println("RestController1.boardWrite");
        return true;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        BoardDto boardDto = new BoardDto();
        ArrayList<BoardDto> boardDtos = new ArrayList<>();
        boardDtos.add( boardDto );
        System.out.println();
        System.out.println("RestController1.boardPrint");
        return boardDtos;
    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        System.out.println("bno = " + bno);
        System.out.println("RestController1.boardDetail");
        BoardDto boardDto = new BoardDto();
        return boardDto;
    }

    @DeleteMapping("/board")
    public boolean boardDelete( @RequestParam int bno){
        System.out.println("bno = " + bno);
        System.out.println("RestController1.boardDelete");
        return true;
    }

    @PutMapping("/board")
    public boolean boardUpdate( @RequestParam int bno, String bcontent){
        System.out.println("RestController1.boardUpdate");
        System.out.println("bno = " + bno);
        return true;
    }



}// class end
