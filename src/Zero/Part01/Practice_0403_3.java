package Zero.Part01;

// import car.CarTest;

/*class Car {
    // 객체가 만들어지기 전부터 이미 name이라는 공간이 생김
    static String name;
    String type;

    public static void getName() {
        System.out.println(name);
        // static 메소드이면 안에서 사용하는 변수도 static이어야 한다.
        // 객체가 생성되기 전부터 메모리에 올라가기 때문에
        // 변수도 미리 만들어져야 한다.
        // System.out.println(type); // 이건 안 됨
    }
    Car(String name) {
        this.name = name;
    }
    void printCar() {
        System.out.println("print car info");
        System.out.println("name = " + name);
    }

    void printCar(int age) {
        System.out.println("print car info : 오버로딩");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }
}


public class Practice_0403_3 {
    public static void main(String[] args) {
        // class를 통해서 만들어진 객체
        // 클래스로부터 객체를 선언한다(인스턴스화)

        System.out.println("== 오버 로딩 ==");
        // 한 클래스 내에 같은 이름의 메소드를 여러 개 정의
        // 이름 동일, 매개변수의 개수 또는 타입 달라야 함
        Car car = new Car("sedan");
        car.printCar();
        car.printCar(2);

        System.out.println("== 접근 제어자 ==");
        // private : 해당 클래스 내에서만 접근
        // public : 어디서든 접근 가능
        // default : 해당 패키지 내에서 접근 가능
        // protected : 해당 패키지 및 상속 받은 클래스에서 접근 가능
        CarTest car2 = new CarTest("a","b","c","d");
        System.out.println(car2.name1);
        // System.out.println(car2.name2); // private
        // System.out.println(car2.name3); // protected
        // System.out.println(car2.name4); // default

        System.out.println("== static ==");
        // 변수, 메소드의 특성을 바꾼다
        // 메모리에 한 번만 할당됨 -> 공유되는 특성을 가짐
        // static 변수 : 객체들이 값 공유
        // static 메서드 : 객체 생성하지 않아도 호출 가능

        Car car3 = new Car("suv");
        System.out.println("car3 print");
        car3.printCar();
        car3.getName();

        Car car4 = new Car("suv2");
        System.out.println("car4 print");
        car4.printCar();
        car4.getName();
    }
}
*/