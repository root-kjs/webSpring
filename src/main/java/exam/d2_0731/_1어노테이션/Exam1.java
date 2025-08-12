package exam.d2_0731._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 
어노테이션(Annotation)
* 사전적으로는 "주석"이라는 뜻이며, 프로그래밍에서는 코드에 추가적인 정보를 제공하는 
* 메타데이터(* 추가정보(데이터) 주입, 코드를 설명하는 데이터, 사용법정의)의 한 형태
* 주로 컴파일러나 프레임워크에게 특정 동작을 지시하거나 정보를 전달하는 데 사용
* 자바에서는 @ 기호를 사용하여 어노테이션을 표시하고, 
* 스프링 프레임워크에서는 @Component, @GetMapping 등 다양한 어노테이션을 활용하여 빈 관리, 요청 매핑 등을 처리합니다. 
* 데이터 과학 분야에서는 이미지나 영상 데이터에 객체, 
* 특징 등을 표시하여 학습 데이터로 사용하는 "데이터 어노테이션"을 의미하기도 합니다
* */
class SuperClass{ // 상위 클래스 : 부모
    public void method1(){ // 메소드 = 함수 = 이벤트 = 행위 = 동작 = 기능
    }
}// class end

class SubClass extends SuperClass{ // 하위클래스 : 자식
    /*
    오버라이딩 : 부모로부터 물려받은 메소드를 커스텀/재정의하는 행위
    */
    @Override // @ 어노테이션 :오버라이딩 기능
    public void method1(){ // 메소드 = 함수 = 이벤트 = 행위 = 동작 = 기능
    }
    @Deprecated // (더 이상 사용되지 않음)해당 함수 사용하지 않음 알림 기능
    public void method2(){ // 메소드 = 함수 = 이벤트 = 행위 = 동작 = 기능
    }

}// class end

/*  2.어노테이션 만들기  */
@Retention( RetentionPolicy.RUNTIME ) // 생성주기(유지기간) 설정 / 언제? 런타임 실행중까지 유지하겠다.
@Target(ElementType.METHOD) // 적용할 수 있는 위치나 대상 설정 / 어디에? 어노테이션은 메소드에 적용하겠다.
@interface  Annotation{
    String value1(); // 추상메소드 {} (중괄호) 구현부가 없는 메소드
}//

/*  2.어노테이션 사용하기  */
class TestClass1{
    //@Annotation1( value1 = "어노테이션 주입" )//
    public void method3(){
        // 런타임(실행중)시, value1();추상메소드 같이 실행ㅡ 직접적인 주입은 아님..우웅...
    }

}

public class Exam1 {
    public static void main(String[] args) {
        // 1. 표준 어노테이션 @Override , @Deprecated
        SubClass subClass = new SubClass();
        subClass.method1(); // 오버라이딩(자식 메소드 우선) @Override
        subClass.method2(); // 메소드명에 취소선(자동완성 레이어에서 보임) @Deprecated

        // 2.

    }// main class
}// class end
