package Zero.Part02.Chapter02;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    데크 : 양쪽에서 삽입과 삭제가 모두 가능한 자료구조 (Stack + Queue)
        일부 기능을 제한하여 용도에 맞게 변형 가능

        입력 제한 데크 : 한 쪽의 입력을 제한한 데크 (Scroll)
            - Front나 Rear 한 쪽의 입력을 제한
        출력 제한 데크 : 한 쪽의 출력을 제한한 데크 (Shelf)
            - Front나 Rear 한 쪽의 출력을 제한
 */
public class Practice_0417_3 {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();

        // Front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        // Rear 부분 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        // Front 부분 출력
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // Rear 부분 출력
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        // 비어 있는 상태에서 poll 하면 -> null
        System.out.println(deque.pollLast());

        // 비어 있는 상태에서 remove 하면 -> 예외 : 예외 처리 필요
        System.out.println(deque.removeLast());
    }
}
