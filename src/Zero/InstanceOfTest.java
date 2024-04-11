package Zero;

// 다형성
class Person_0325 {
    public void print() {
        System.out.println("Zero.Person.print");
    }
}

class Man extends Person_0325 {
    public void print() {
        System.out.println("Zero.Man.print");
    }
    public void print2() {
        System.out.println("Zero.Man.print2");
    }
}

class CollegeMan extends Person_0325 {
    public void print() {
        System.out.println("Zero.CollegeMan.print");
    }
}

public class InstanceOfTest {
    public static void main(String[] args) {

        System.out.println("== 다형성 ==");
        Person_0325 p1 = new Person_0325();
        Man m1 = new Man();

        // Person이 Man을 가리킨다 = 다형성
        Person_0325 p1_2 = new Man();
        // 자식이 부모를 가리키는 건 안 됨
        // Zero.Man m1_2 = new Zero.Person_0325();
        p1.print();
        m1.print();
        m1.print2();
        // p1_2의 대상은 Zero.Man 객체이므로 tpye이 person이지만 man 출력
        p1_2.print();
        /*
            p1_2가 Zero.Person type이기 때문에 Person이 알고 있는
            한해서 출력이 된다, 때문에 p1_2.print2();는 불가
         */

        System.out.println("== 타입 변환 ==");
        Person_0325 pp1 = null;
        Man mm1 = null;

        Person_0325 p2 = new Person_0325();
        Man m2 = new Man();

        Person_0325 p2_2 = new Person_0325();
        Man m2_2 = new Man();
        Person_0325 p2_3 = new Man(); // 업캐스팅

        pp1 = p2;
        pp1 = m2_2;
        mm1 = m2;
        // mm1 = p2; 불가능
        // 실객체는 Man이기 때문에 형변환 하면 가능
        mm1 = (Man) p2_3;    // 다운캐스팅

        System.out.println("== InstanceOF ==");
        Person_0325 pe1 = new Person_0325();
        Man st1 = new Man();
        Person_0325 pe2 = new Man();
        Person_0325 pe3 = new CollegeMan();

        System.out.println(pe1 instanceof Person_0325);
        System.out.println(pe1 instanceof Man);

        System.out.println(st1 instanceof Man);
        System.out.println(st1 instanceof Person_0325);

        System.out.println(pe2 instanceof Person_0325);
        System.out.println(pe2 instanceof Man);

        System.out.println(pe3 instanceof Person_0325);
        System.out.println(pe3 instanceof CollegeMan);

    }
}
