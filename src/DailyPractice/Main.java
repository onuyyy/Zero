package DailyPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {

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

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("숫자 입력 : ");
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            System.out.println(solution(s));
        }

    }
}
