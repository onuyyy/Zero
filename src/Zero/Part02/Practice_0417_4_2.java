package Zero.Part02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/*
    앞으로 읽어도 거꾸로 읽어도 같은 문자열

    입력 : a
    출력 : true

    입력 : abab
    출력 : false

    입력 : madam
    출력 : true
 */
public class Practice_0417_4_2 {
    public static boolean checkPalindrome(String str) {
        Deque d = new ArrayDeque();
        boolean isFront = true;
        boolean isPalindrome = true;

        // 한 글자씩 잘라서 넣기
        for(String s : str.split("")) {
            d.addFirst(s);
        }

        while(!d.isEmpty()) {
            // poll이 아닌 remove를 쓰게 되면 error가 발생
            // poll은 null
            String s1 = (String)d.pollFirst();
            String s2 = (String)d.pollLast();

            // 홀수일 때 한 쪽이 null이면 true
            if(s1 != null && s2 != null && !s1.equals(s2)) {
                isPalindrome = false;
                break;
            }
        }
        return  isPalindrome;
    }
    public static void main(String[] args) {
        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("madam"));
        System.out.println(checkPalindrome("abcd"));
    }
}
