package Cotest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class CodingTest_0425 {

    public static String solution6(String[] BJ, String[] one, String[] two) {
        String answer = "";

        answer = Arrays.stream(BJ)
                .filter(str -> !Arrays.asList(one).contains(str) && !Arrays.asList(two).contains(str))
                .collect(Collectors.joining(" "));

        return "1350만원"+(answer);
    }

    public static int solution5(String S) {
        int answer = 0;
        // -3+26-7
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int temp = 1;
        for(char c : S.toCharArray()) {
            // 첫 번째 부호 넣기
            if(i == 0) {
                if(c == '-') {
                    temp *= -1;
                } else {
                    temp = 0;
                }
            } else {
                // 두 번째 글자부터
                if(c == '-') {
                    temp *= -1;
                } else if(c == '+') {
                    temp = 0;
                } else {

                }
            }
            i = 1;

        }


        return answer;
    }
    public static int solution4(String S) {
        int answer = 0;
        Stack stack = new Stack();

        int i = 0;
        for(char c : S.toCharArray()) {
            if (i == 0) {
                stack.push(c);
            } else {
                char top = (char)stack.peek();
                if(top == c) {
                    stack.pop();
                    answer = 1;
                }
                stack.push(c);
            }
            i = 1;
        }
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
    public static int solution3(String s) {
        int answer = 0;

        Stack stack = new Stack();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '<' || c == '['|| c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) answer = 0;

                char top = (char)stack.pop();

                if((c == ')' && top != '(') || (c == '>' && top != '<') || (c == ']' && top != '[' || c == '}' && top != '{')) {
                    return answer;
                }
            }

        }

        if(stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }

    public static String solution2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // 스택에 남은 문자들을 역순으로 문자열로 변환하여 반환
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString(); // 결과를 뒤집어서 반환
    }


    public static String solution(String ss) {

        String result = "YES";

        Stack<String> stack = new Stack();
        for(String c : ss.split("")) {
            if(c.equals("(")) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            result = "NO";
        }
        return result;
    }
    public static void main(String[] args) throws IOException {

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("숫자 입력 : ");
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            System.out.println(solution(s));
        }*/

/*        String a = "aacddefg";

        System.out.println(solution2(a));

        String b = "(())<{}>[]";
        System.out.println(solution3(b));

        String c = "({)}<[>]";
        System.out.println(solution3(c));*/

        System.out.println("= 3번 =");
        String d = "ABBA";
        System.out.println(solution4(d));

        String e = "ABA";
        System.out.println(solution4(e));
    }
}
