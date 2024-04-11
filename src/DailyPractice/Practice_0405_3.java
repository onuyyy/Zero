package DailyPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Practice_0405_3 {
    public static void referInputStream() throws IOException {
        System.out.println("== System.in ==");
        System.out.print("입력 : ");
        int a = System.in.read() - '0';
        // char 값 1개 받아 옴
        System.out.println("a = " + a);
        System.in.read(new byte[System.in.available()]);

        System.out.println("== InputStreamReader ==");
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] c = new char[3];
        // 받을 사이즈를 미리 알고 배열에 넣어둬야 함
        System.out.print("입력 : ");
        reader.read(c);
        System.out.println("c = " + c);

        System.out.println("== BufferedReader");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력 : ");
        String s1 = br.readLine();
        System.out.println("s1 = " + s1);
    }

    public static void main(String[] args) throws IOException {
        // referInputStream();

/*        System.out.println("== Scanner ==");
        Scanner scan = new Scanner(System.in);
        System.out.println("입력 : ");
        System.out.println(scan.next());
        scan.nextLine();

        System.out.println("입력2 : ");
        System.out.println(scan.nextInt());
        scan.nextLine();

        System.out.println("입력3 : ");
        System.out.println(scan.nextLine());

        // 참고, 정수 - 문자열 변환
        int num = Integer.parseInt("12345");
        String str = Integer.toString(12345);*/


        System.out.println("== 출력 ==");
        System.out.println("Hello");
        System.out.print("Hello");
        System.out.printf("Hello ");
        System.out.println();

        // printf
        String s = "java";
        int number = 3;

        System.out.println(s + "는 언어 선호도 " + number + "입니다.");
        System.out.printf("%s는 언어 선호도 %d입니다.",s,number);

        // 서식 문자
        System.out.printf("%d\n",10); // 정수
        System.out.printf("%o\n",10); // 8진수
        System.out.printf("%x\n",10); // 16진수

        System.out.printf("%f\n",5.2f); // 실수
        System.out.printf("%c\n",'A'); // 문자값
        System.out.printf("%s\n","ABC"); // 문자열

        System.out.printf("%5d\n",123);
        // 5개의 정수형 공간을 확보하고 123 출력
        System.out.printf("%-5d\n",123);
        // 왼쪽으로 정렬
        System.out.printf("%.2f\n",1.12645);
        // 소수 2번째자리까지 출력 (반올림)


    }
}
