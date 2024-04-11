package Zero;

class Ani {
    String name,classfication;
    double weight;

    Ani(String name,String classfication,double weight) {
        this.name=name;
        this.classfication=classfication;
        this.weight=weight;
    }

    public void print() {
        System.out.println("name = " + name);
        System.out.println("classfication = " + classfication);
        System.out.println("weight = " + weight);
    }

    public void eat() {
        System.out.println("냠냠");
    }
    public void sleep() {
        System.out.println("잠");
    }
    public void walk() {
        System.out.println("걷기");
    }
    public void run() {
        System.out.println("뛰어");
    }

}
public class Animal2 {
    public static void main(String[] args) {
        Ani a1 = new Ani("강아지","포유류",8.7);
        a1.print();
        a1.eat();
        a1.run();
        a1.sleep();
        a1.walk();
    }
}
