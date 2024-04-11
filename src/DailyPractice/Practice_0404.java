package DailyPractice;

class Person_0404 {
    String name;
    int age;
    public int a1;
    private int a2;

    Person_0404(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Person.printInfo");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}

class Student extends Person_0404 {
    String name;
    int stdID;
    Student(String name, int age,int stdID) {
        super(name, age);
        this.stdID = stdID;
        // super.name = name;
        // 이렇게 하면 부모클래스의 초기화이므로
        // name 출력하면 null이 나온다
    }
    public void printInfo() {
        System.out.println("Student.extends.printInfo");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("stdID = " + stdID);
    }
}


public class Practice_0404 {
    public static void main(String[] args) {
        /*
            * 상속 : 기존 클래스에 기능 추가 및 재정의하여
            새로운 클래스를 정의
                부모 클래스 : 상속 대상이 되는 기존 클래스
                자식 클래스 : 기존 클래스를 상속하는 클래스
                - 부모 클래스의 필드와 메소드가 상속됨
                - 생성자, 초기화 블록은 상속되지 않음
                - 다중 상속은 불가능
                - private, default 멤버는 자식 클래스에서 접근 불가
                             ㄴ 내부 패키지의 자식 클래스느 ㄴ가능

             super : 부모 클래스와 자식 클래스의 멤버 이름이 같을 때 구분하는 키워드
             super() : 부모 클래스의 생성자 호출

             * 오버라이딩 : 부모 클래스의 메소드를 자식 클래스에서 재정의
                - 메소드의 선언부는 부모 클래스의 메소드와 동일
                - 반환 타입에 한해, 부모클래스의 타입으로 변환 가능
                - 접근제어자를 더 좁은 범위로 변경 불가
                - 더 큰 범위의 예외 선언 불가
         */

        System.out.println("== 상속 & 오버라이딩 ==");
        Student s1 = new Student("a",25,233);
        s1.printInfo();



    }
}
