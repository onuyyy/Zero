package Zero.Part02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/*
    카드 섞기
    1 ~ N 까지의 번호로 구성된 N장의 카드가 있다.
    1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여 있다.
    아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막 남는 카드 번호?

    1. 가장 위의 카드는 버린다.
    2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

    입력 : N = 4 , 결과 : 4
    입력 : N = 7 , 결과 : 6
 */
public class Practice_0417_2 {
    public static int findLastCard(int n) {

        Queue<Integer> q = new LinkedList();

        // n장의 카드를 쌓는다
        IntStream.range(1, n + 1).forEach(x -> q.add(x));
        System.out.println(q);

        // 마지막 한 장 안 버리기 위해
        while(q.size() > 1) {
            // 첫 장 버려
            q.remove();
            // 그 다음장 data에 넣어두기
            int data = (int)q.remove();
            // 마지막에 두 번째장 다시 넣기
            q.add(data);
            System.out.println(q);
        }
        // 마지막 한 장
        return q.remove();
    }
    public static void main(String[] args) {
        System.out.println(findLastCard(4));
        System.out.println(findLastCard(7));
        System.out.println(findLastCard(9));
    }
}
