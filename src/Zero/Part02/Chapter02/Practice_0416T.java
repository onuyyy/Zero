package Zero.Part02.Chapter02;

import java.util.ArrayList;

class MyStack1 {
    ArrayList list;
    MyStack1() {
        this.list = new ArrayList();
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

    public  Integer pop() {
        if(this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }
        // list의 끝을 가져오기
        // ArrayList가 제네릭 되어있지 않아서 (int) 형변환 필요
        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek() {
        if(this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        return data;
    }

    public void clear() {
        list.clear();
    }

    public void printStack() {
        System.out.println(this.list);
    }
}

public class Practice_0416T {
    public static void main(String[] args) {
        MyStack1 s1 = new MyStack1();
        System.out.println(s1.isEmpty());
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.printStack();

        System.out.println(s1.peek());
        s1.printStack();

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        s1.printStack();

        System.out.println(s1.pop());
        s1.printStack();

        s1.push(6);
        s1.printStack();

        s1.clear();
        s1.printStack();

        s1.pop();
    }
}

