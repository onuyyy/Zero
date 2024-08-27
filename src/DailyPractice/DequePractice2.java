package DailyPractice;

import java.util.*;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class DequePractice2 {

    public static boolean checkPalindrome(String str) {
        /*
            Palindrome 찾기 : 앞으로 읽거나 거꾸로 읽어고 같은 문자열

            입력 : a
            결과 : true

            입력 : madam
            결과 : true
         */
        Deque d = new ArrayDeque();
        boolean isPalindrome = true;

        for (String s : str.split("")) {
            d.addFirst(s);
        }

        while (!d.isEmpty()) {
            // remove를 쓰면 예외가 발생하기 때문에
            // poll, remove 둘 다 결과는 반환함
            String s1 = (String) d.pollFirst();
            String s2 = (String) d.pollLast();

            if (s1 != null && s2 != null && !s1.equals(s2)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
    public static void reorderDate(int[] arr) {
        /*
            데이터 재정렬
            D_0 > D_1 > ...
            D_0 > D_n > D_1 > D_n-1 > ... 순이 되도록 재정렬

            입력 : 1 > 2 > 3 > 4 > 5
            출력 : 1 > 5 > 2 > 4 > 3
         */

        Deque d = new ArrayDeque();
        ArrayList result = new ArrayList();

        // arr을 intstream으로 만든 후 람다식으로 add 한다
        IntStream.of(arr).forEach(x -> d.addLast(x));

        while (!d.isEmpty()) {
            result.add(d.removeFirst());

            if (!d.isEmpty()) {
                result.add(d.removeLast());
            }
        }

        System.out.println("== 정렬 전 ==");
        printData(arr);
        System.out.println("== 정렬 후 ==");
        printData(result.stream().mapToInt(x -> (int) x).toArray());
    }

    public static void printData(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println(arr[arr.length - 1]);
    }
    public static void main(String[] args) {

        System.out.println("Practice 1");
        int[] arr = {1,2,3,4,5};
        reorderDate(arr);
        System.out.println();

        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        reorderDate(arr);

        System.out.println("Practice 2");
        System.out.println(checkPalindrome("a"));
        System.out.println(checkPalindrome("abc"));
        System.out.println(checkPalindrome("abab"));
        System.out.println(checkPalindrome("abccba"));
    }
}
