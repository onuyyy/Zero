package DailyPractice;

import java.util.ArrayList;
import java.util.Stack;

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is Full");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        } else {
            int data = this.arr[this.top];
            this.top -= 1;
            return data;
        }
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        } else {
            return this.arr[this.top];
        }
    }

    public void printStack() {
        for (int i = 0; i < this.top + 1; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
class MyStack1 {
    ArrayList list;
    MyStack1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if(list.size() == 0 ) {
            return true;
        } else  {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if(this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }

        int data = (int) this.list.get(this.list.size() - 1);
        return data;
    }

    public void printStack() {
        System.out.println(this.list);
    }
}
public class StackPractice {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.contains(1));

        System.out.println(stack.size());

        System.out.println(stack.empty());

        stack.clear();
        // stack.pop();

        System.out.println("My Stack 1");
        MyStack1 s1 = new MyStack1();
        System.out.println(s1.isEmpty());
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);

        System.out.println(s1.peek());
        s1.printStack();

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        s1.printStack();

        System.out.println(s1.pop());

        System.out.println("My Stack 2");
        MyStack2 s2 = new MyStack2(5);
        System.out.println(s1.isEmpty());
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        s2.push(5);
        s2.push(6);

        System.out.println(s2.peek());
        s2.printStack();

        System.out.println(s2.pop());
        System.out.println(s2.pop());
        s2.printStack();

        System.out.println(s2.pop());
    }
}
