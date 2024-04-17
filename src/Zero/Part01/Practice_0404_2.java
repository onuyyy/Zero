package Zero.Part01;

/*
    다형성 : 한 객체가 여러 가지 타입을 가질 수 있는 것
        부모 클래스 타입의 참조 변수로 자식 클래스 인스턴스 참조
        Person p = enw Student();
        반대는 불가능
 */

class Fruit {
    public void print() {
        System.out.println("fruit.print");
    }
}

class Banana extends Fruit {
    public void print() {
        System.out.println("banana.print");
    }
    public void print2() {
        System.out.println("banana.print2");
    }
}

class Orange extends Fruit {
    public void print() {
        System.out.println("orange.print");
    }
}

public class Practice_0404_2 {
    public static void main(String[] args) {
        System.out.println("== 다형성 ==");
        Fruit f1 = new Fruit();
        Banana b1 = new Banana();

        // 대상은 Banana 객체이기 때문에 banana가 출력된다
        Fruit f2 = new Banana();
        // Banana b2 = new Fruit(); 이건 안 됨
        f1.print();
        b1.print();
        b1.print2();
        f2.print();
        // f2.print2(); 이건 안 됨 > 타입은 Fruit이기때문에
        // Fruit가 알고 있는 부분까지만 접근 가능

        Fruit f3 = new Orange();
        f3.print();
        // Orange 01 = new Banana();
        // 같은 부모 상속했다고 하더라고 이건 안 됨

        System.out.println("== 타입 변환 ==");
        Fruit ff1 = null;
        Banana bb1 = null;

        Fruit ff2 = new Fruit();
        Banana bb2 = new Banana();
        Fruit ff3 = new Banana(); // 업캐스팅
        // 자식 클래스의 객체가 부모 클래스의 타입으로
        // 형변환되는 것 > 다형성

        ff1 = ff2;
        ff1 = bb1;
        bb1 = bb2;
        // bb1 = ff2;
        bb1 = (Banana)ff3; // 실 객체는 바나나이기때문에
            // 업 캐스팅 된 객체를 다운캐스팅 (자기 객체로)
            //

        System.out.println("== instanceOf ==");
        // 해당 객체의 인스턴스가 맞는지 확인
        // 해당 클래스를 상속받는 하위 클래스의 인스턴지인지 확인
        Fruit fr1 = new Fruit();
        Banana ba1 = new Banana();
        Fruit fr2 = new Banana();
        Fruit fr3 = new Orange();

        // fr1이 Fruit의 인스턴스인지
        System.out.println(fr1 instanceof Fruit);
        System.out.println(fr1 instanceof Banana);
        System.out.println(ba1 instanceof Banana);
        // ba1는 fruit를 상속받았기 때문에 true
        System.out.println(ba1 instanceof Fruit);

        System.out.println(fr2 instanceof Fruit);
        // fr가 fruit의 인스턴스이거나 fruit를 상속받는
        // 어떤 클래스의 인스턴스인지 검사
        // fr2는 fruit 타입으로 선언되었지만 실제로는
        // banana 객체를 참조하기 때문에 fruit와 banan 모두의 인스턴스로 간주
        System.out.println(fr2 instanceof Banana);

        System.out.println(fr3 instanceof Fruit);
        System.out.println(fr3 instanceof Orange);

        if(fr1 instanceof Banana) {
            Banana bbb = (Banana)fr1;
        }

        if(ba1 instanceof Fruit) {
            Fruit fff = (Fruit)fr1;
        }
        /*
            참조 변수란?
                객체를 가리키는 변수, 객체의 주소를 저장하여 접근
                Fruit f = new Banana();
                f는 Fruit 클래스의 참조 변수이며
                new Banana()로 생성된 Banana 객체를 가리킨다
         */
    }
}
