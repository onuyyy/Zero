package Zero.Part01;

class Outer {
    public void print() {
        System.out.println("Outer print");
    }

    class Inner {
        public void innerPrint() {
            // 내부에선 외부클래스 접근 가능
            Outer.this.print();
        }
    }

    static class InnterStaticClass {
        void innerPrint() {
            // Outer.this.print();
            // Outer는 static이 아니라서 메모리에 안 올라감
            // 사용 불가
        }
    }
}

abstract class Person_0405_2 {
    public abstract void printInfo();
}

class Student_0405_2 extends Person_0405_2 {
    @Override
    public void printInfo() {
        System.out.println("Student printInfo");
    }
}

public class Practice_0405_2 {
    public static void main(String[] args) {
        /*
            내부 클래스 : 클래스 in 클래스
                외부 클래스에서 내부 클래스 접근 불가
                내부에선 외부 접근 가능
            1. 인스턴스 클래스
                클래스 in 클래스
            2. 정적 클래스
                static 키워드 붙어서 메모리에 상주되는 클래스
            3. 지역 클래스
                클래스 내에 메서드 내에 있는 클래스
            4. 익명 클래스
                이름을 가지지 않는 클래스이며
                선언과 동시에 객체 생성되는 일회성 클래스
         */

        // 외부 클래스
        Outer o1 = new Outer();

        // 내부 클래스 - 인스턴스
        Outer.Inner i1 = new Outer().new Inner();
        // 객체 생성시 외부 클래스부터 만든다

        // 내부 클래스 - 정적
        Outer.InnterStaticClass is1 = new Outer.InnterStaticClass();
        // static이기 때문에 객체 생성 안 하고 접근 가능

        // 익명 클래스
        Person_0405_2 p1 = new Person_0405_2() {
            @Override
            public void printInfo() {
                System.out.println("Main printInfo");
            }
        };
    }
}
