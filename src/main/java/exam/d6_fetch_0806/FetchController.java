package exam.d6_fetch_0806;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchController {

    @GetMapping("/d6/exam1")
    public boolean m1(){
        return true;
    }

}//class end
