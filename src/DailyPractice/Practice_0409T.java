package DailyPractice;

import java.util.stream.IntStream;

public class Practice_0409T {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
        for(int n : arr) {
            sum+=n;
        }
        System.out.println("sum = " + sum);

        System.out.println("== Stream으로 구현 ==");
        int sum2 = IntStream.range(1,11).sum();
        System.out.println("sum2 = " + sum2);
    }
}
