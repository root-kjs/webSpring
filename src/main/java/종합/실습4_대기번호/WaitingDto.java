package 종합.실습4_대기번호;

import lombok.*;

@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체 생성자
@Getter // 게터
@Setter // 세터
@ToString // 투스트링
public class WaitingDto {
    // 멤버 변수
    private int wno;
    private String wphone;
    private int wcount;
    
}// class end
