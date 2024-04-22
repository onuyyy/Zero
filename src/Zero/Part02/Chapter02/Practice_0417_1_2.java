package Zero.Part02.Chapter02;

import java.util.ArrayList;

class MyQueue {
    ArrayList list;
    MyQueue() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        if(this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }

        // 사장 처음에 있는 데이터면 0
        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }

        return (int)this.list.get(0);

    }

    public void printQueue() {
        System.out.println(list);
    }
}
public class Practice_0417_1_2 {
    public static void main(String[] args) {
        MyQueue m1 = new MyQueue();

        m1.push(1);
        m1.push(2);
        m1.push(3);
        m1.push(4);
        m1.push(5);

        m1.printQueue();

        System.out.println(m1.peek());
        m1.printQueue();

        System.out.println(m1.pop());
        m1.printQueue();

        System.out.println(m1.pop());
        m1.printQueue();

        System.out.println(m1.pop());
        System.out.println(m1.pop());
        System.out.println(m1.pop());
        System.out.println(m1.pop());
    }
}
