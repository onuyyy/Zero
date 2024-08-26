package DailyPractice;

import java.util.Stack;

public class StackPractice2 {
    public static boolean stringCompare(String s1, String s2) {
        /*
            두 문자열 비교
            단. #은 backspace로 바로 이전의 문자를 삭제하는 기능이라고 가정

            입력 : s1 = "tree" / s2 = "th#ree"
            출력 : true
         */
        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);

        return s1After.equals(s2After);
    }

    public static String doBackspace(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }

    public static double calculate(String str) {
        /*
            후위표기법 연산 [전위 +22 / 중위 2+2 / 후위 22+]

            입력 : 2 2 +
            출력 : 4

            입력 : 2 2 -
            출력 : 0
         */
        Stack<Double> stack = new Stack();

        for (String s : str.split(" ")) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(s));
            }
        }

        return stack.pop();
    }
    public static void checkParenthesis(String str) {
        /*
            괄호 짝 검사
            입력 : (
            출력 : Fail

            입력 : ()
            출력 : Pass
         */
        Stack stack = new Stack();
        boolean checkFlag = true;

        for(String s : str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    checkFlag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if(checkFlag && stack.isEmpty()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
    public static String reverseString(String str) {
        /*
            문자열 뒤집기
            입력 : Hello
            출력 : olleH
        */
        Stack stack = new Stack();
        String result = "";

        for(String s : str.split("")) {
            stack.push(s);
        }

        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {

        System.out.println("Practice 1");
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);

        System.out.println("Practice 2");
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("((()))())");
        checkParenthesis(")))(((");

        System.out.println("Practice 3");
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));
        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));

        System.out.println("Practice 4");
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));
    }
}

