package Zero.Part04;

public class OOP {

    public static class Cola {
        // 명시적 초기화
        // 변수 선언시 값을 할당
        private static int 용량 = 20;
        private int 제조일자 = 1;

        // 초기화 블럭 { }
        // static의 유무로 다른 초기화 블럭

        static {
            System.out.println("static 초기화 = 클래스 초기화 블럭");
            용량 = 20;
            // 제조일자 = 50; -- 불가
            System.out.println("용량 = " + 용량);
        }

        {
            System.out.println("인스턴스 초기화 블럭");
            용량 = 30;
            System.out.println("용량 = " + 용량);
            제조일자 = 30;
        }
        public Cola() {
            System.out.println("생성자 호출");
            용량 = 60;
            System.out.println("용량 = " + 용량);
            제조일자 = 60;
            System.out.println("제조일자 = " + 제조일자);
        }
    }
    public static void main(String[] args) {
        Cola co = new Cola();
        // Cola co2 = new Cola();
    }
}



