package Zero.Part02;
/*
    N과 K가 주어졌을 때 (N, K) 요세푸스 순열 구하기
    N과 K는 N >= K 를 만족하는 양의 정수.
    1 ~ N 번까지 N명이 순서대로 원을 이루어 모여있다.
    이 모임에서 원을 따라 순서대로 K번째 사람을 제외한다.
    모든 사람이 제외될 때까지 반복하여, 제외되는 순서가 요세푸스 순열이다.

    입력 : N = 5, K = 2
    결과 : 2, 4, 1, 5, 3

    입력 : N = 7, K = 3
    결과 : 3, 6, 2, 7, 5, 1, 4
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Practice_0417_2_2 {
    public static ArrayList getJose(int n, int k) {

        Queue q = new LinkedList();
        // 순열 결과 담을 result
        ArrayList result = new ArrayList();

        // n명의 구성원 만들기
        IntStream.range(1, n + 1).forEach(x -> q.add(x));

        // k번째 카운트 위한 변수
        int cnt = 0;
        while (!q.isEmpty()) {
            // 첫번째 사람 데려옴
            int data = (int)q.remove();
            cnt += 1;

            // k번째 사람의 list에 더해주기
            if(cnt % k ==0 ) {
                result.add(data);
            } else {
                // 아니면 Queue의 맨 뒤에 넣기
                q.add(data);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getJose(5,2));
        System.out.println(getJose(7,3));
    }
}
