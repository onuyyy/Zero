package Zero;

class Outer {
    public void print() {
        System.out.println("Outer.print");
    }
    class Inner {
        public void innerPrint() {
            // Outer에 접근하여 사용
            // 내부에선 외부 클래스 접근 가능
            Outer.this.print();
        }
    }
    //
    static class InnerStaticClass {
        void InnerPrint() {
            // Outer.this.print();
            // static이 붙어 정적 특성이 있기 때문에 메모리에 바로 올라감
            // Outer 쪽은 static이 아니라서 바로 사용할 수 있는
            // 형태가 아니라서 사용 불가
        }
    }
}

abstract class PersonInner {
    public abstract void printInfo();
}

class StudentInner extends PersonInner {
    @Override
    public void printInfo() {
        System.out.println("Student.print");
    }
}

public class InnerClassTest {
    public static void main(String[] args) {

        // 외부 클래스
        Outer o1 = new Outer();

        // 내부 클래스 - 인스턴스
        // 접근 방법 : 외부객체 만들고 -> 내부객체 접근
        Outer.Inner i1 = new Outer().new Inner();

        // 내부 클래스 - 정적
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();
        // static이기 때문에 객체 생성없이 바로 접근하여 생성

        // 익명 클래스
        // 구현되지 않은 메서드를 만들어서
        PersonInner p1 = new PersonInner() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };
    }
}
