package DailyPractice;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static int solution8(int[] d, int budget) {

        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if(sum > budget) {
                break;
            }
            sum += budget;
        }

        if(sum <= budget) {
            answer = d.length;
        }

        return answer;
    }

    public static int solution7(int goal, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 0;
        int right = goal;

        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
                if(cnt > n) {
                    break;
                }
            }

            if(goal - prev < mid && cnt <= n) {
                cnt++;
            }
            if(cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

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

    public static int solution0513(int[] people, int limit) {

        int answer = 0;
        int start = 0;
        int end = people.length - 1;

        Arrays.sort(people);

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
                answer++;
            } else {
                end--;
                answer++;
            }
        }

        return answer;
    }

    public static String solution0513_2(String number, int k) {
        int idx = 0;
        int next = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;

            for (int j = idx; j < i + k; j++) {
                int cur = number.charAt(j);

                if(max < cur) {
                    max = cur;
                    cur = idx;
                }
            }
            sb.append(max);
            idx = next + 1;
        }

        return sb.toString();
    }
    public static void main(String[] args) throws IOException {

//        int[] people = {70,50,80,50};
//        int limit = 100;
//        System.out.println(solution0513(people, limit));

        int goal = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;
        System.out.println(solution7(goal, rocks, n));

    }
}
