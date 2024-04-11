package DailyPractice;

interface School {
    public static final int MAX_CLASS = 20;
    public static final int MAX_PERSON_PER_CLASS = 40;
    public abstract void printSchool();
}

class Student_0405 implements School {
    @Override
    public void printSchool() {
        System.out.println("00 university");
    }
}

class Person_0405 {
    public String name;
    public void printName() {
        System.out.println("name = " + name);
    }
}

class Student2 extends Person_0405 implements School {
    Student2(String name) {
        this.name = name;
    }
    @Override
    public void printSchool() {
        System.out.println("11 unviersity");
    }
}

public class Practice_0405 {
    public static void main(String[] args) {
        /*
            인터페이스 inplements
            다중 상속처럼 사용할 수 있는 기능
            추상 메소드와 상수만으로 이루어짐
         */

        System.out.println("== 인터페이스 기본 사용 ==");
        Student_0405 s1 = new Student_0405();
        s1.printSchool();
        System.out.println(s1.MAX_CLASS);
        System.out.println(s1.MAX_PERSON_PER_CLASS);

        System.out.println("== 다중 상속처럼 사용하기 ==");
        Student2 s2 = new Student2("A");
        s2.printSchool();
        s2.printName();

    }
}
