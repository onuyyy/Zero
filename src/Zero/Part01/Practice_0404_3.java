package Zero.Part01;

/*
    추상 메소드 abstract
        자식 클래스에서 반드시 오버라이딩 해야하는 매소드
        선언만 하고 구현 내용은 없음
    추상 클래스
        하나 이상의 추상 메소드를 포함하는 클래스
        반드시 구현해야 하는 부분에 대해 명시적으로 표현
        추상 클래스 자체는 객체 생성 불가
            > 추상메소드는 기능 구현이 없기 때문에 불완전해서
 */

abstract class P {
    abstract void printInfo();
}

class S extends P {
    public void printInfo() {
        System.out.println("S printInfo");
    }
}

public class Practice_0404_3 {
    public static void main(String[] args) {
        System.out.println("== 추상 클래스의 사용 ==");
        // P p1 = new P(); 바로 객체로 만들 수 없음
        S s1 = new S();
        P p1 = new P() {
            @Override
            void printInfo() {
                System.out.println("Main printInfo");
                // 익명 클래스
            }
        };
    }
}
