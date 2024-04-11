package Work;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Mini_5 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner scan = new Scanner(System.in);

        System.out.print("달력의 년도를 입력해 주세요.(yyyy) : ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.print("달력의 월을 입력해 주세요.(mm) : ");
        int month = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < 3; i++) {
            LocalDate date = LocalDate.of(year,month+i,1);

            int first = date.getDayOfWeek().getValue();
            // 해당 월의 첫 번째 날짜가 무슨 요일인지 알아내기
            // 해당 날짜의 요일을 1~7 정수로 매핑해줌 1: 월요일 ~

            int totalDay = date.lengthOfMonth();
            // 해당 월의 전체 일수 알아내기

            System.out.printf("[%d년 %02d월]\n",year,month-1+i);
            System.out.print("일\t월\t화\t수\t목\t금\t토\n");

            for(int j = 1; j < first; j++) {
                System.out.print("\t");
            }
            for(int day = 1; day <= totalDay; day++) {
                System.out.printf("%02d\t", day);

                // 줄바꿈 처리 (토요일마다)
                if((day +  first - 1) % 7 == 0 || day == totalDay) {
                    System.out.println();
                }
            }

        }


    }
}
