package Zero.Part02.Chapter02;

import java.util.ArrayList;
import java.util.Arrays;

class MyDeque {
    ArrayList list;
    MyDeque() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        if(this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(int data) {
        this.list.add(0,data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if(this.isEmpty()) {
            System.out.println("Deque is Empty!");
            return null;
        }
        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast() {
        if(this.isEmpty()) {
            System.out.println("Deque is Empty!");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public void printDeque() {
        System.out.println(this.list);
    }
}
public class Practice_0417_3_2 {
    public static void main(String[] args) {
        System.out.println("== ArrayList를 이용한 데트 구현 ==");

        MyDeque m = new MyDeque();

        m.addFirst(1);
        m.addFirst(2);
        m.addFirst(3);
        m.printDeque();

        m.addLast(10);
        m.addLast(20);
        m.addLast(30);
        m.printDeque();

        System.out.println(m.removeFirst());
        m.printDeque();
        System.out.println(m.removeLast());
        m.printDeque();

        System.out.println(m.removeLast());
        System.out.println(m.removeLast());
        System.out.println(m.removeLast());
        System.out.println(m.removeLast());
        m.printDeque();
    }
}

