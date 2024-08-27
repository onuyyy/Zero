package DailyPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueuePractice2 {
    public static ArrayList getJosephusPermutation(int N, int K) {
        /*
            요세푸스 문제
            N과 K가 주어졌을 때(N, K) 요세푸스 순열을 구하기
            N과 K는 N >= K 를 만족하는 양의 정수
            1 ~ N 번까지 N명이 순서대로 원을 이루어 모여있다
            이 모임에서 원을 따라 순서대로 K 번째 사람을 제외한다
            모든 사람이 제외될 때까지 반복하며, 이때 제외되는 순서가 요세푸스 순열

            입력 : N = 5 / K = 2
            결과 : 2, 4, 1, 5, 3

            입력 : N = 7, K = 3
            결과 : 3, 6, 2, 7, 5, 1, 4
         */
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        IntStream.range(1, N + 1).forEach(x -> q.add(x));

        int cnt = 0;
        while (!q.isEmpty()) {
            int data = q.remove();
            cnt += 1;

            if (cnt % K == 0) {
                result.add(data);
            } else {
                q.add(data);
            }
        }

        return result;
    }
    public static int findLastCard(int N) {
        /*
            카드 섞기
            1 ~ N 까지의 번호로 구성된 N장의 카드가 있다.
            1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드 순서대로 쌓여있다.
            아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막 남는 카드 번호 출력
            1. 가장 위 카드는 버린다.
            2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

            입력 : N = 4
            결과 : 4

            입력 : N = 7
            결과 : 6
         */

        Queue<Integer> q = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> q.add(x));
        System.out.println(q);

        while (q.size() > 1) {
            q.remove();
            int data = q.remove();
            q.add(data);
            System.out.println(q);
        }

        return q.remove();
    }
    public static void main(String[] args) {
        System.out.println("Practice 1");
        System.out.println(findLastCard(4));
        System.out.println(findLastCard(7));
        System.out.println(findLastCard(9));

        System.out.println("Practice 2");
        System.out.println(getJosephusPermutation(5,2));
        System.out.println(getJosephusPermutation(7,3));
    }
}

