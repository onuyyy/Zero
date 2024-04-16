package Zero;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DailyPractice {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    static Stack<Integer> s3 = new Stack<>();
    static Stack<Integer> s4 = new Stack<>();

    static String makeStack(int[] arr, Stack[] stackArr) {
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for(Stack s : stackArr) {
                if((int)s.peek() < num) {
                    s.push(num);
                    num = 0;
                    break;
                }
            }
            // stack 최 상당 숫자보다 현재 숫자가 더 크다면 넣음
            if(num != 0) return "NO"; // 현재 숫자가 어느 스택에도 못 들어갈 때
        }
        // 입력 받은 숫자만큼 반복
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        sc.nextLine();

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        Stack[] stackArr = {s1,s2,s3,s4};
        for(Stack s : stackArr) {
            // 스택에 isEmpty를 체크하는 것 대신 -1을 넣어 바로 넣을 수 있게
            s.push(-1);
        }
    }
}
