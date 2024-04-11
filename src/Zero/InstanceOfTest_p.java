package Zero;

// 아래의 클래스와 상속 관계에서 다형성을 이용하여
// Zero.Car_p 객체를 통해 아래와 같이 출력될 수 있도록 해라
// 빵빵
// 위이잉
// 삐뽀삐뽀
class Car_p {
    Car_p(){}
    public void ppang() {
        System.out.println("빵빵");
    }
}
class FireTruck_p extends Car_p {
    public void ppang() {
        System.out.println("위이잉");
    }
}
class Ambulance_p extends Car_p {
    public void ppang() {
        System.out.println("삐뽀삐뽀");
    }
}
public class InstanceOfTest_p {
    public static void main(String[] args) {
        // 다형성을 이용하기
        Car_p car = new Car_p();
        car.ppang();
        car = new FireTruck_p();
        car.ppang();
        car = new Ambulance_p();
        car.ppang();

        Car_p car2[] = {new Car_p(), new FireTruck_p(), new Ambulance_p()};
        for(Car_p i:car2) {
            i.ppang();
        }
    }
}
