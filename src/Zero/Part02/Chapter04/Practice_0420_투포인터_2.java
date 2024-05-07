package Zero.Part02.Chapter04;

import java.util.Arrays;
import java.util.HashSet;

public class Practice_0420_투포인터_2 {
    public static String solution(String s) {
        /*
            a,b,c,d,로 이루어진 알파벳 문자열에 대해서
            다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 변환하는 프로그램을 작성
            양쪽의 문자를 비교한 후 같으면 삭제, 연속해서 같은 문자가 등장하면 함께 삭제한다
            최종적으로 남은 문자열을 반환

            입출력 예시
            입력 : "ab"
            출력 : "ab"

            입력 : "aaabbaa"
            출력 : 없음
        */
        if(s == null || s.length() == 0) {
            return null;
        }

        int p1 = 0;
        int p2 = s.length() - 1;

        // 두 포인터가 교차하지 않는 동안 루프 돌기
        // 끝과 끝이 같을 때만 돌기
        while(p1 < p2 && s.charAt(p1) == s.charAt(p2)) {
            // 현재 포인터가 가리키는 문자
            char c = s.charAt(p2);

            // p1 포인터를 이동시키면서 p1 위치의 문자가 c와 같은 동안,
            // p1 감소 시켜 문자 삭제
            while (p1 <= p2 && s.charAt(p1) == c) {
                p1++;
            }
            // p2 포인터를 이동시키면서 p2 위치의 문자가 c과 같은 동안,
            // p2 감소 시켜 문자 삭제
            while (p1 <= p2 && s.charAt(p2) == c) {
                p2--;
            }
        }

        return s.substring(p1, p2 + 1);
    }

    public static int[] solution2(int[] num1, int[] num2) {
        /*
            num1, num2 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성
            결과 배열의 원소에는 중복 값이 없도록 하며 순서 상관 없다

            입출력 예시
            num1 : 1, 2, 2, 1
            num2 : 2, 2
            출력 : 2

            num1 : 4, 9, 3
            num2 : 9, 4, 9, 8, 4
            출력 : 4, 9 (or 9, 4)
         */

        HashSet<Integer> set = new HashSet<>();

        // 정렬되어 있으면 편하기 때문에 정렬
        Arrays.sort(num1);
        Arrays.sort(num2);

        // 하나의 포인터는 num1에서, 다른 포인터는 num2에서 이동시킨다
        int p1 = 0;
        int p2 = 0;

        while(p1 < num1.length && p2 < num2.length) {
            if(num1[p1] < num2[p2]) {
                // 오름차순이므로 p1이 더 작다면 p1 다음엔 더 큰 값이 없으므로 p1++
                p1++;
            } else if (num1[p1] > num2[p2]) {
                // p1이 더 크다면 p2 다음에는 더 큰 값이 없으므로 p2++
                p2++;
            } else {
                // 같은 원소일 때 p1,p2 어떤 원소 사용하든 상관 없음
                set.add(num1[p1]);
                p1++;
                p2++;
            }
        }

        // set -> 배열로 다시 변환
        int[] result = new int[set.size()];
        int idx = 0;
        for(Integer n : set) {
            result[idx++] = n;
        }

        return result;
    }
    public static void main(String[] args) {

        System.out.println("== solution1 ==");
        System.out.println(solution("ab")); // ab
        System.out.println(solution("aaabbaa"));
        System.out.println(solution("aabcddba")); // cdd

        System.out.println("== solution2 ==");
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(solution2(num1, num2)));

        num1 = new int[]{4,9,3};
        num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution2(num1, num2)));

        num1 = new int[]{1,7,4,9};
        num2 = new int[]{7,9};
        System.out.println(Arrays.toString(solution2(num1, num2)));

    }
}
