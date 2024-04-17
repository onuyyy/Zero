package Zero.Part01;

interface ComputerTool {
    public abstract int compute(int x, int y);
}

public class Practice_0408_3 {
    public static void main(String[] args) {
        /*
            람다식 (익명 함수)
                메소드 대신 하나의 식으로 표현하는 것
                코드가 간결해지고 가독성, 생산성이 높아짐
                재사용이 불가능하며 디버깅이 어렵다
                재귀함수로는 맞지 않다

                (매개변수) -> {실행문}
                (int x,int y)->{return x+y;}
         */

        ComputerTool c1 = new ComputerTool() {
            @Override
            public int compute(int x, int y) {
                return x+y;
            }
        };
        System.out.println(c1.compute(1,2));

        ComputerTool c2 = (x,y) -> {return x+y;};
        System.out.println(c2.compute(1,2));

        // 추상메서드가 두 개인 경우에는 람다식 사용 불가
    }
}
