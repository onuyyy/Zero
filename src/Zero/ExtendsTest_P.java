package Zero;// 아래 상속 관계에서 code 수정하지 않고
// Zero.Dog 클래스 내에서 super 또는 super() 이용하여
// "강아지 입니다" 출력될 수 있도록 해보자

class Animal_0325 {
    String desc;
    Animal_0325() {
        this.desc = "동물 클래스 입니다.";
    }
    Animal_0325(String desc) {
        this.desc = desc;
    }
    public void printInfo() {
        System.out.println(this.desc);
    }
}

class Dog extends Animal_0325 {
    String desc;
    Dog() {
       // super.desc = "강아지 입니다.";
        super("강아지입니다");
    }
}
public class ExtendsTest_P {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.printInfo();
    }
}
