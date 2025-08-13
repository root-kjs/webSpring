package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    // 멤버 변수
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String mdate;

}// class end
