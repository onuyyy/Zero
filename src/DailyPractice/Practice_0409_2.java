package DailyPractice;

import java.util.Scanner;

public class Practice_0409_2 {

    public static void solution(int num) {

        // 입력한 숫자 거꾸로 출력하기
        int numReverse = 0; // 결과 변수
        boolean isMinus = false; // -일 때 체크할 변수

        if(num < 0) {
            isMinus = true;
            num *= -1;
        }

        while(num > 0) {
            int r = num % 10; // 나머지를 구하면 한 자리씩 떼어올 수 있음
            num /= 10; // 10으로 나눈 몫을 다시 세팅
            numReverse = numReverse * 10 + r;
        }

        System.out.println(isMinus ? numReverse * -1 : numReverse);
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }
    public static void solution2() {
        // 아스키 코드 중 알파벳에 대해서 대소문자를 변경하는 프로그램 작성
        // 알파벳 외의 값 예외처리
        Scanner sc = new Scanner(System.in);
        System.out.println("알파벳 입력 : ");
        char input  = sc.nextLine().charAt(0);
        int output = 0;

        int step = (int)'a' - 'A'; // 숫자 사이 간격을 알면 대소문자 변경 가능

        if(input >= 'a' && input <= 'z') {
            output = (int) input - step;
            System.out.println("대문자 변환 : " + (char)output);
        } else if (input >= 'A' && input <='Z') {
            output = (int) input + step;
            System.out.println("소문자 변환 : " + (char)output);
        } else {
            System.out.println("입력하신 값이 알파벳이 아닙니다");
        }
    }

    public static String solution3(char[] str, char[] find, char[] to) {
        // replace, indexOf,contains 사용하지 않고 문자열 바꾸기
        // POP > P , W > WOW

        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone(); // 임시로 사용할 배열

        do {
            idx = findIndex(replaceBucket, find);

            if(idx != -1) {
               // idx 전까지는 원래 있던 데이터를 채워 넣는다
                for (int i = 0; i < idx; i++) {
                    // find 전까지 원래 데이터 넣기
                    replaceStr += replaceBucket[i];
                }
                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }
                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }
                // 두 번째 바꿀 단어는 그대로이기 때문에 엎어놓고 다시 반복문 돌림
                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }
        } while (idx != -1); {
            // idx = -1 findIndex 호출시 매칭되는 게 없으면 -1이 return됨
            replaceStr = new String(replaceBucket);
            return replaceStr;
        }
    }

    public static int findIndex(char[] str, char[] find) {
        // 문자열에서 해당 위치 찾는 함수
        int idx = -1; // 초기화
        boolean isMatch = false;

        for (int i = 0; i < str.length; i++) {
            if(str[i] == find[0] && str.length - i >= find.length) {
                // 첫글자가 같은지 비교 && find와 str 길이가 같은지 비교
                isMatch = true;
                for (int j = 1; j < find.length; j++) {
                    if(str[i+j] != find[j]) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if(isMatch) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        solution(7640);
        reference();
        solution2();

        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 replace
        System.out.println(str.replace("Java","자바"));

        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution3(strExArr, findArr, toArr));
    }
}
