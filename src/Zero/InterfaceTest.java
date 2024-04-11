package Zero;// Interface

interface School {
    // interface 상수와 추상메서드로 이루어짐
    public static final int MAX_CLASS = 20;
    public static final int MAX_PERSON_PER_CLASS = 40;
    public abstract void printSchool();
}

class Student_0326_2 implements School {
    // 인터페이스 구현
    public void printSchool() {
        System.out.println("Zero.School.print");
    }
}

class Person_0326_2 {
    public String name;
    public void printName() {
        System.out.println("Name : " + name);
    }
}

class Student_0326_3 extends Person_0326_2 implements School{
    Student_0326_3(String name) {
        super.name = name;
    }
    @Override
    public void printSchool() {
        System.out.println("11 Zero.School");
    }
}


public class InterfaceTest {
    public static void main(String[] args) {

        System.out.println("== 기본 인터페이스==");
        Student_0326_2 s1 = new Student_0326_2();
        s1.printSchool();
        System.out.println(s1.MAX_CLASS);
        System.out.println(s1.MAX_PERSON_PER_CLASS);

        System.out.println("== 다중 상속처럼 사용 ==");
        Student_0326_3 s2 = new Student_0326_3("name");
        s2.printName();
        s2.printSchool();
    }
}
