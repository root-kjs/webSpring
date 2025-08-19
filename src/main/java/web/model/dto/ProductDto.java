package web.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
    private int pno;
    private String pname;
    private int pprice;
    private String pcomment;
    private double plat;
    private double plng;
    private int mno;

    // 1. [업로드용] 업로드에 사용할 multipartFile
    private List<MultipartFile> uploads;
    // 2. [조회용] 파일명 --> 업로드된 파일명을 String으로 조회// DB에는 파일명만 저장/ 진짜 파일은 build에 있음
    private List<String> images;
    // 3. 판매자의 아이디(join 아니면 map)
    private int pid;
    
}//class end
