package DailyPractice;

public class Practice_0402 {
    public static void main(String[] args) {
        String result = (1 > 0) ? "yes":"no";
        System.out.println("result = " + result);

        // 비트 연산자
        // & 둘 다 1이어야 "1" 아니면 "0" 출력
        System.out.println("== & 연산자 ==");
        int num1 = 5;
        int num2 = 3;
        int result2 = 0;
        result2 = num1 & num2;
        System.out.println("result2 = " + result2);
        // 이진수로 표현
        System.out.println(Integer.toBinaryString(result2));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(result2)));
        // printf 포맷에 맞게 출력
        // %04 -> 4개자리 수 출력(못 미치면 앞을 0으로 채워)
        // d -> 정수형 데이터를 받을 수 있는 서식 문자

        System.out.println("== OR 연산자==");
        // | 둘 중 하나라도 1이면 1
        result2 = num1 | num2;
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(result2)));

        System.out.println("== XOR 연산자==");
        // ^ 둘 다 1이면 0
        result2 = num1 ^ num2;
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(result2)));

        System.out.println("== ~ 반전 연산자 ==");
        result2 = ~num1;
        System.out.println("result2 = " + result2);
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(num1)));
        // byte 체계가 32개라 0이었던 숫자가 1로 바뀜
        System.out.printf("%s\n",Integer.toBinaryString(result2));

        System.out.println("== 비트 이동 연산자==");
        System.out.println("<< 연산자");
        // 비트를 왼쪽이로 이동 0011 > 0110
        int numA = 3;
        System.out.println("result2 바뀌기 전 : "+ result2);
        result2 = numA << 1;
        System.out.println("result2 = " + result2);
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(result2)));

        // Integer,parseInft로 한 번 더 감싸는 이유는 
        // 이진수를 정수형으로 바꿔서 printf 포맷에 맞추기 위하여
        System.out.println(Integer.toBinaryString(result2));

        System.out.println(" >> 연산자");
        // 비트를 오른쪽으로 이동 0011 > 0001
        // 기존의 비트 첫 번째가 따라온다
        System.out.println("result2 바뀌기 전 : "+ result2);
        result2 = numA >> 1;
        System.out.println("result2 = " + result2);
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(numA)));
        System.out.printf("%04d\n",Integer.parseInt(Integer.toBinaryString(result2)));

        System.out.println(" >>> 연산자");
        // 비트를 오른쪽으로 이동 : 첫 번째를 0으로 채움
        // 0011 > 0001
        System.out.println("result2 바뀌기 전 : "+ result2);
        numA = -5;
        result2 = numA >> 1;
        System.out.println("result2 = " + result2);
        System.out.printf("%s\n",Integer.toBinaryString(numA));
        System.out.printf("%s\n",Integer.toBinaryString(result2));

        result2 = numA >>> 1;
        System.out.println("result2 = " + result2);
        System.out.printf("%s\n",Integer.toBinaryString(numA));
        System.out.printf("%s\n",Integer.toBinaryString(result2));


    }
}
