package Zero.Part02;

import java.util.LinkedList;
import java.util.Queue;

/*
    큐 : 선입선출 First in First Out (FIFO)
        먼저 등러온 데이터가 먼저 나가는 구조
        입력 순서대로 데이터 처리가 필요할 때 사용
            - 데이터 추가(Enqueue), 꺼내기(Dequeue), 큐 공간 확인
 */
public class Practice_0417 {
    public static void main(String[] args) {
        // Queue는 인터페이스로 되어있어서
        // 오버라이드 구현해야 할 게 많다, 바로 쓸 수 없어서 LinkedList 이용
        Queue queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        // poll() 꺼내서 없앰
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(4));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll());
    }
}

