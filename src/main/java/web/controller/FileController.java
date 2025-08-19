package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired // 스프링  컨테이너에서
    private FileService fileService;

    // 1. 파일 업로드
    @PostMapping("/upload")
    public String fileUpload( MultipartFile multipartFile ){
        System.out.println("multipartFile = " + multipartFile);
        System.out.println("FileController.fileUpload");
        String result = fileService.fileUpload( multipartFile );
        return result;
    }//fund end


    // 2. 파일 다운로드
    @GetMapping("/download")
    public void fileDownload(@RequestParam String filename , HttpServletResponse response ){
        fileService.fileDownload( filename, response );
    }//func end

    // 3. 파일 삭제
    @DeleteMapping("/delete") // @GetMapping ---> 브라우저 테스트만 가능함
    public boolean fileDelete(@RequestParam String filename ){
        System.out.println("FileController.fileDelete");
        System.out.println("filename = " + filename);
        boolean result = fileService.fileDelete( filename );
        return result;

    }//func end

}// class end
