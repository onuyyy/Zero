package Zero;

// 추상클래스
abstract class Person_0326 {
    abstract void printInfo();
}

// 추상 클래스 상속
class Student_0326 extends Person_0326 {
    public void printInfo() {
        System.out.println("Zero.Student.printInfo");
    }
}

public class AbstractTest {
    public static void main(String[] args) {

        // Zero.Person_0326 s = new Zero.Person_0326();
        // 추상클래스를 바로 객체로 만드는 것은 불가능
        // 기능 구현된 부분이 없기 때문에
        Student_0326 s = new Student_0326();
        s.printInfo();

        // 추상클래스를 생성하면 자동으로 오버라이드 해야 할 것이 나타남
        Person_0326 p2 = new Person_0326() {
            @Override
            void printInfo() {
                System.out.println("Main.printInfo");
            }
        };
        p2.printInfo();
    }
}
