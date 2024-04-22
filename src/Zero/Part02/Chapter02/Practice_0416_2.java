package Zero.Part02.Chapter02;

import java.util.Stack;

/*
    문자열 뒤집기
    입력 : Hello
    출력 : olleH
 */
public class Practice_0416_2 {
    public static String reverseString(String str) {
        Stack stack = new Stack<>();
        String result = "";

        // 한 글자씩 뜯어서 넣기
        for (String s: str.split("")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("12345");
        System.out.println("result = " + result);
    }
}
