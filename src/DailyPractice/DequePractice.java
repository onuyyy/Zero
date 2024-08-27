package DailyPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size) {
        // 원형 데크로 만들 것임 size + 1
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        this.arr[this.front] = data;
        // 공식이다 외워라
        // front가 - 일 경우에 대비하여 length를 더한 후 나눔
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        // front는 비워져 있어야 하니까 + 1 한 인덱스 찾기
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
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
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = (int)this.list.get(0);
        this.list.remove(0);

        return data;
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is Empty");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);

        return data;
    }

    public void printList() {
        System.out.println(this.list);
    }
}
public class DequePractice {
    public static void main(String[] args) {

        System.out.println("Practice 1");
        Deque d = new ArrayDeque();

        // Front 부분 입력
        d.addFirst(1);
        d.addFirst(2);
        System.out.println(d);

        // Rear 부분 입력
        d.addLast(5);
        d.addLast(6);
        System.out.println(d);

        // Front 부분 출력
        System.out.println(d.getFirst());
        System.out.println(d);
        System.out.println(d.removeFirst());

        // Rear 부분 출력
        System.out.println(d.getLast());
        System.out.println(d);
        System.out.println(d.remove());


        d.remove();
        d.remove();
        // null return
        System.out.println(d.pollLast());
        // deque가 빈 상태에서 예외 발생
        // d.remove();
        System.out.println(d.pollLast());

        System.out.println("Practice 2");
        MyDeque1 m1 = new MyDeque1();
        m1.addFirst(1);
        m1.addFirst(2);
        m1.addFirst(3);
        m1.printList();

        m1.addLast(10);
        m1.addLast(20);
        m1.addLast(30);
        m1.printList();

        System.out.println(m1.removeFirst());
        m1.printList();

        System.out.println(m1.removeLast());
        m1.printList();
        System.out.println(m1.removeLast());
        System.out.println(m1.removeLast());
        System.out.println(m1.removeLast());
        System.out.println(m1.removeLast());
        m1.printList();

        System.out.println("Practice 3");
        MyDeque2 m2 = new MyDeque2(5);
        m2.addFirst(1);
        m2.addFirst(2);
        m2.addFirst(3);
        m2.printDeque();

        m2.addLast(10);
        m2.addLast(20);
        m2.addLast(30);
        m2.printDeque();

        System.out.println(m2.removeFirst()); // 3
        m2.printDeque(); // 2 1 10 20

        System.out.println(m2.removeLast()); // 20
        m2.printDeque(); // 2 1 10

        System.out.println(m2.removeLast()); // 10
        System.out.println(m2.removeLast()); // 1
        System.out.println(m2.removeLast()); // 2
        System.out.println(m2.removeLast()); // Deque is Empty


    }
}
