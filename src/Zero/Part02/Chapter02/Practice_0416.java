package Zero.Part02.Chapter02;

import java.util.Stack;

/*
    Stack
        - 후입선출 자료구조 Last In First Out (LIFO)
        마지막에 들어온 데이터가 먼저 나가는 구조
        - 데이터가 입력된 순서의 역순으로 처리되어야 할 때 사용
        ex ) 함수 콜 스택, 수식 계산, 인터럽트 처리 등
 */
public class Practice_0416 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        // pop 하면서 데이터를 return 하기 때문에 출력 가능
        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        // top의 데이터를 return 해주며 삭제되진 않음
        System.out.println("stack.peek() : " + stack.peek());
        System.out.println(stack);

        // 해당 데이터가 있는지
        System.out.println("stack.contains(1) : " + stack.contains(1));

        System.out.println("stack.size() : " + stack.size());

        System.out.println("stack.empty() : " + stack.empty());

        stack.clear();
        System.out.println("stack : " + stack);

        System.out.println("stack이 비어있을 때 pop 실행시 오류");
        stack.pop();

    }
}
