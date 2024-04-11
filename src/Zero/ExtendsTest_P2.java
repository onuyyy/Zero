package Zero;// 아래 클래스와 상속 관계에서 아래와 같이 출력하도록 오버라이딩
// 빵빵
// 위이잉
// 삥삥
// 삐뽀삐뽀

class Car_0325 {
    Car_0325(){}
    public void ppang() {
        System.out.println("빵빵");
    }
}
class FireTruck extends Car_0325 {
    public void ppang() {
        super.ppang();
        System.out.println("위이잉");
    }
}
class Ambulance extends Car_0325 {
    public void ppang() {
        super.ppang();
        System.out.println("삐뽀삐뽀");
    }
}
public class ExtendsTest_P2 {
    public static void main(String[] args) {
        FireTruck f = new FireTruck();
        f.ppang();

        Ambulance a = new Ambulance();
        a.ppang();
    }
}
