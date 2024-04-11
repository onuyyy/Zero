package Work;

import java.util.Scanner;

public class Mini_4 {
    public static void main(String[] args) {
        System.out.println("[주민등록번호 계산]");
        Scanner scan = new Scanner(System.in);
        System.out.println("출생년도를 입력해 주세요.(yyyy):");
        int year = scan.nextInt() % 100;
        scan.nextLine();
        System.out.println("출생월을 입력해 주세요.(mm)");
        int month = scan.nextInt();
        scan.nextLine();
        System.out.println("출생일을 입력해 주세요.(dd)");
        int day = scan.nextInt();
        scan.nextLine();
        System.out.println("성별을 입력해 주세요.(m/f)");
        String sex = scan.nextLine();

        String birth = String.format("%d%02d%02d",year,month,day);

        int first = 3;
        if(sex.equals("f")) {
            first=4;
        }

        int random = (int)(Math.random() * 899999) + 100000;
        System.out.println(birth + "-" + first + random);
    }
}
