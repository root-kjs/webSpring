package exam.d10_0813_session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // setter/getter/toString 3개 포함한 어노테이션
public class LoginDto {
    private int mno;
    private String mid;
    private String mpw;

    
}// class end
