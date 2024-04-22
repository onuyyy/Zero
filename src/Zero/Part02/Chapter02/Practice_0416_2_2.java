package Zero.Part02.Chapter02;

import java.util.Stack;

/*
    괄호 짝 검사
    입력 : "("
    출력 : Fail

    입력 : "()"
    출력 : Pass
 */
public class Practice_0416_2_2 {
    public static void checkParenthesis(String str) {
        Stack stack = new Stack<>();
        boolean flag = true;

        for(String s : str.split("")) {
            if(s.equals("(")) {
                stack.push(s);
            } else {
                if(stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(flag == true && stack.isEmpty()) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
    public static void main(String[] args) {
        checkParenthesis("(");  // fail
        checkParenthesis(")");  // fail
        checkParenthesis("()"); // pass
        checkParenthesis("()()()"); // pass
        checkParenthesis("(())()"); // pass
        checkParenthesis("(((()))");    // fail
    }
}
