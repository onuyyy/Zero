package Zero.Part02;

import java.util.Stack;

/*
    두 문자열 비교
    단 #은 backSpace 로 바로 이전의 문자를 삭제하는 기능이라고 가정

    입력 : s1 = "tree", s2 = "th#ree
    출력 : true
 */
public class Practice_0416_2_4 {

    public static String doBackspace(String s) {
        Stack stack = new Stack<>();
        // String을 char Array로 변환
        for(char c : s.toCharArray()) {
            if(c == '#' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
    public static boolean stringCompare(String s1, String s2) {
        String s1After = doBackspace(s1);
        String s2After = doBackspace(s2);

        return s1After.equals(s2After);
    }
    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "trh#ee";
        System.out.println(stringCompare(s1,s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1,s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1,s2));

    }
}
