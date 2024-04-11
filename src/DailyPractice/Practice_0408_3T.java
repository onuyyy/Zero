package DailyPractice;

interface CompareTool {
    public abstract int getMaxNum(int num1, int num2);
}
public class Practice_0408_3T {
    public static void main(String[] args) {
        CompareTool c = new CompareTool() {
            @Override
            public int getMaxNum(int num1, int num2) {
                return num1 > num2? num1 :  num2;
            }
        };
        System.out.println(c.getMaxNum(10,22));

        System.out.println("== 람다식 변환 ==");
        CompareTool c2 = (x,y) -> { return x > y ? x : y; };
        System.out.println(c2.getMaxNum(3,4));
    }
}
