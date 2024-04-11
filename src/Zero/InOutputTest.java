package Zero;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InOutputTest {

    public static void referInputStream() throws IOException {
        System.out.println("== System.in ==");
        System.out.print("입력 : ");
        int a =System.in.read() - '0';
        System.out.println("a = " + a);
        // char 값 1개 받을 수 있음
        // 아스키 코드 값에 매핑 받는데 그만큼 빼서 변환해줌
        System.in.read(new byte[System.in.available()]);
        // 엔터키가 스트림에 남아있어서 엔터키가 reader.read에 걸려서
        // 남아있는 데이터를 소진해서 없애야 한다

        System.out.println("== InputStreamReader ==");
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] c = new char[3];
        System.out.println("입력 : ");
        reader.read(); // 데이터 읽기
        System.out.println(c);

        System.out.println("== BufferedReader ==");
        // InputStream은 읽고자 하는 개수만큼 배열을 만들어야 하는데
        // BufferedReader는 마음대로 사용 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("입력 : ");
        String s1 = br.readLine();
        System.out.println("s1 = " + s1);
    }

    public static void main(String[] args) throws Exception {
        // referInputStream();

        // Scanner
        System.out.println("== Scanner ==");
        Scanner sc = new Scanner(System.in);
        System.out.println("입력 : ");
        System.out.println(sc.next());
        sc.nextLine();

        System.out.println("입력2 : ");
        System.out.println(sc.nextInt()); // Integer값만 입력 해야 함
        sc.nextLine();

        System.out.println("입력3 : ");
        System.out.println(sc.nextLine());

        // 정수, 문자열 변환
        int num = Integer.parseInt("1234");
        String str = Integer.toString(1234);

        // 출력
        System.out.println("== 출력 ==");
        System.out.println("Hello");
        System.out.println("No 줄 바꿈");
        System.out.println();

        System.out.printf("war"); // 포맷 지정
        System.out.println();

        String s = "Java";
        int number = 3;
        System.out.println(s + "는 언어 선호도" + number + "입니다");
        System.out.printf("%s는 언어 선호도 %d위 입니다.\n",s,number);

        // 정수형
        System.out.printf("%d\n",10);
        // 8진수
        System.out.printf("%o",10);
        // 16진수
        System.out.printf("%x\n",10);
        // 실수
        System.out.printf("%f\n",10.0f);
        // 문자값
        System.out.printf("%c\n",'A');
        // 문자열
        System.out.printf("%s\n","안녕하세요");

        //  %5d -> 5개의 공간을 확보하고 123 출력한다
        System.out.printf("%5d\n",123);
        System.out.printf("%-5d\n",1234);
        System.out.printf("%5d\n",1235);

        // 소수점 몇 번째에서 반올림
        System.out.printf("%.2f\n", 1.1264567);

    }
}
