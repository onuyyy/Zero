package Work;

import java.util.Scanner;

public class Mini_2 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        Scanner scan = new Scanner(System.in);
        System.out.println("결제 금액을 입력해주세요. (금액) : ");
        int cash = scan.nextInt();
        int cashBack=0;

        cashBack = (int)Math.round((cash / 100) * 0.1) * 100;

        if(cashBack >= 300) {
            cashBack = 300;
        }

        System.out.println(String.format("결제 금액은 %d이고, 캐시백은 %d입니다.",cash,cashBack));
    }
}
