package Zero.Part02;

import java.util.Stack;

/*
    후위 표기법
        입력 : 2 2 +
        출력 : 4
    전위 : +22
    중위 : 2+@

    중위를 후위로 바꾸기 :
    (1 + 2) * 3
    > ((1 + 2) * 3) : 괄호 치기
    > 12+3* : 연산자를 가장 가까운 괄호의 우측으로 옮기기

    1 + 2 * 3
    > (1 + (2 * 3))
    > 23* > 123*+ > 123*
        +는 괄호가 최외곽이니까 제일 밖으로

 */
public class Practice_0416_2_3 {
    public static double calculate(String str) {
        // double로 형변환 해줘야 한다
        Stack<Double> stack = new Stack<>();
        for(String s : str.split(" ")) {
            if(s.equals("+")) {
                // Stack의 제네릭을 지정 하지 않으면 Object로 반환되기 때문에
                // 형변환 시켜줘야 함
                stack.push((double)stack.pop() + (double)stack.pop());
            } else if (s.equals("-")) {
                stack.push(- stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(s));
            }
        }

        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));
    }
}
