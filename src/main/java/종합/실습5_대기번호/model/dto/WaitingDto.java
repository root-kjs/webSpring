package 종합.실습5_대기번호.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WaitingDto {
    // 멤버변수
    private int wno;
    private String wphone;
    private int wcount;

}// class end
