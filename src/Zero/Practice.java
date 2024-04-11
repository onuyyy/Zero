/*package Zero;

// import car.CarTest;

class Car {
    String name,type;

    public void carInfo() {
        System.out.println("Zero.Car Info");
        System.out.println("name = " + name);
        System.out.println("type = " + type);
    }

    public void carInfo(String date) {
        this.carInfo();
        System.out.println("date = " + date);
    }

    public void carInfo(int price) {
        this.carInfo();
        System.out.println("price = " + price);
    }

    public void carInfo(String date,int price) {
        this.carInfo();
        System.out.println("date = " + date);
        System.out.println("price = " + price);

    }
    public void move() {
        System.out.println("이동");
    }

    public void break1() {
        System.out.println("정지");
    }



}
class Car2 {
    String name,type;

    Car2(String name,String type) {
        this.name=name;
        this.type=type;
        // this는 자기 객체를 가리킨다
        System.out.println("생성자 출력");
    }

    public void carInfo() {
        System.out.println("Zero.Car Info");
        System.out.println("name = " + name);
        System.out.println("type = " + type);
    }
    public void load() {
        System.out.println("짐을 줘");
    }
    public void horn() {
        System.out.println("빵");
    }

}

class CarStatic {
    static String name="None";
    String type;

    CarStatic (String name, String type) {
        this.name=name;
        this.type=type;
    }

    public void carInfo() {
        System.out.println("Zero.Car Info");
        System.out.println("name = " + name);
        System.out.println("type = " + type);
    }

    public static void getName() {
        System.out.println("Zero.Car Name : "+name);
    }

}

public class Practice {
    public static void main(String[] args) {
        Car c = new Car();
        c.name="sorento";
        c.type="suv";
        c.carInfo();
        c.move();
        c.break1();

        System.out.println("==오버로딩 사용==");
        c.carInfo("2022");
        c.carInfo(1234);
        c.carInfo("2022",1234);

        System.out.println("==오버로딩 끝");

        // C2
        Car2 c2 = new Car2("avante","sedan");
        c2.carInfo();
        c2.load();
        c2.horn();


        System.out.println("== 접근 제어자 ==");
        CarTest c3 = new CarTest("a","b","c","d");
        System.out.println(c3.name1);
/*        System.out.println(c3.name2);
        System.out.println(c3.name3);
        System.out.println(c3.name4);*/

/*        System.out.println("== Static ==");
        CarStatic.getName();
        // Static 메서드로 되어있으면 안에서 사용하는 변수도
        // Static이어야 한다

        // Static 객체 만들어보기
        CarStatic ct = new CarStatic("a","sedan");
        CarStatic ct2 = new CarStatic("b","suv");
        CarStatic ct3 = new CarStatic("c","rv");

        ct.carInfo();
        ct2.carInfo();
        ct3.carInfo();
        // name 변수가 Static이라 객체가 name을 공유한다
        // 마지막에 바꿔준 name이 공유된다

    }
}
*/