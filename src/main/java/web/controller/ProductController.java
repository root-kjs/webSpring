package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;
import web.service.FileService;
import web.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired private ProductService productService;
    @Autowired private FileService fileService;

    // 1. 제품 등록
    @PostMapping("/create")
    public int createProduct(@ModelAttribute ProductDto productDto, HttpServletRequest request ){ // @ModelAttribute
        // 1. 로그인상태 확인
        HttpSession session = request.getSession();
        if( session == null  || session.getAttribute("loginMno") == null ){
            System.out.println("로그인이 필요합니다.");
        }
        Object object = session.getAttribute("loginMno");
        // 2. 제품 정보 DB 처리
        int liginMno = (int) object;
        productDto.setMno( liginMno );// dto에 mno(로그인한 회원번호) 포함
        int result = productService.createProduct( productDto );
        // 3. 만약에 업로드 파일이 존재하면 업로드 파일 처리
            // 3. 만약에
        if( result > 0 && !productDto.getUploads().isEmpty() && !productDto.getUploads().get(0).isEmpty()  ){
            for( MultipartFile multipartFile: productDto.getUploads() ){
                String fileName = fileService.fileUpload( multipartFile );
                if ( fileName == null) return 0;
                boolean result2 = productService.createProductImage( result, fileName );
                if( result2 == false ) return 0;
            }
        }//if end
        // 4. 업로드 된 파일명 DB 처리
        return result;
    }
    
    // 2. 전체 제품 조회

    // 3. 제품 상세 조회

}// class end