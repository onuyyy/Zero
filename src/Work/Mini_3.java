package Work;

import java.util.Scanner;

public class Mini_3 {
    public static void main(String[] args) {
        System.out.println("[입장권 계산]");
        Scanner scan = new Scanner(System.in);

        System.out.println("나이를 입력해주세요.(숫자) : ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("입장 시간을 입력해주세요.(숫자) :");
        int time = scan.nextInt();
        scan.nextLine();
        System.out.println("국가유공자 여부를 입력해 주세요.(y/n)");
        String temp1 = scan.nextLine();
        System.out.println("복지카드 여부를 입력해 주세요.(y/n)");
        String temp2 = scan.nextLine();

        int ticket = 10000;

        if (temp1.equals("y") || temp2.equals("y")) {
            ticket = 8000;
        }
        if(age < 13) {
            ticket = 4000;
        }
        if(time > 17) {
            ticket = 4000;
        }
        if(age < 4) {
            ticket = 0;
        }

        System.out.println("입장료 " + ticket + "원");

    }
}
