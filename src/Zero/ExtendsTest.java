package Zero;

class Person {
    String name;
    int age;
    public int a1;
    private int a2;

    Person(){}
    Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Zero.Person.printInfo");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}

class Student extends Person {
    // Zero.Student 안에 아무 정의 안 해도 Zero.Person 사용 가능

    // 접근제어자에 따른 test
    Student() {
        a1 = 1;
        //  a2 = 1; private이라 불가능
    }
}

class Student2 extends Person {
    String name;
    int stdid;

    Student2(String name, int age, int stdid) {
       // this.name = name; // 자신 객체
       // super.name = name; // 부모 객체
        super(name,age);
        this.age = age; // 상속 받은 age
        this.stdid = stdid; // 자신 객체
    }
    
    public void printInfo() {
        System.out.println("Zero.Student2.printInfo");
        System.out.println("name = " + name);
        System.out.println("stdid = " + stdid);
        System.out.println("age = " + age);
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        System.out.println("== 상속 ==");
        Student s1 = new Student();
        s1.name = "a";
        s1.age = 25;
        s1.printInfo();

        System.out.println("== super, super(), 오버라이딩 ==");
        Student2 s2 = new Student2("b",32,1);
        // name =null 이유 : super.name 사용하여 부모 객체 name 정의했기 때문
        s2.printInfo();

    }
}
