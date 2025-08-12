package exam.d7_0807;

import lombok.*;
// 롬복이란 : 설계에서 자주 사용되는 코드를 자동 생성
// 롬복 설치 : 인텔리제이 환경에서 설치
// (프로젝트) 그레이들 설치
@NoArgsConstructor // 빈생성자 (컴파일시/실행) 자동 생성
@AllArgsConstructor // 전체 매개변수(컴파일시/실행) 생성자
@Getter // 모든 멤버변수에 대해서 getter 메소드
@Setter // 모든 멤버변수에 대해서 setter 메소드 생성 + 생략시 VO(읽기모드?, 조회할때 많이 사용된다는데 모르겠다...)
@ToString // 객체 조회시 주소값 대신에 모든 멤버변수들을 String 문자열로 출력해주는 메소드
public class StudentDto {
    // 멤버 변수
    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private String sdate;
    // 생성자(기본/전체) : 빈생성자, 풀(모든매개변수)생성자
    // setter/getter/toString
}//class end
