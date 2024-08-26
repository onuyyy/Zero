package DailyPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class MyQueue2 {
    // 배열을 이용한 큐 구현
    /*
        배열 관점에서 구현하다 보면 enqueue와 dequeue가 이루어질시 인덱스가
        앞 뒤 중 꽉 차게 되면 빈 공간에 넣어줘야 하는데 배열을 동그랗게 만들어서
        인덱스를 관리해본다 > 원형 큐
     */

    int[] arr;
    int front = 0;
    int rear = 0;
    MyQueue2(int size) {
        arr = new int[size + 1];
    }

    public boolean isEmpty() {
        // 원형 큐이기 때문에 front와 rear가 똑같다
        // 데이터가 추가가 되면 rear를 뒤쪽으로 하나씩 옮겨준다
        // 원형 큐 관리를 위해서는 front가 가리키고 있는 부분은 비워둔다
        // arr = new int[size + 1]이 되는 이유
        return this.rear == this.front;
    }

    public boolean isFull() {
        // 원형 큐는 1칸이 남기 때문에 +1을 해주고, 배열의 길이만큼 나눠주면
        // front의 길이와 같다
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void enqueue(int data) {
        if (this.isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empyu");
            return null;
        }

        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
class MyQueue1 {
    ArrayList list;

    MyQueue1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        int data = (int) this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        return (int) this.list.get(0);
    }

    public void printQueue() {
        System.out.println(this.list);
    }
}

public class QueuePractice {
    public static void main(String[] args) {
        /*
            Queue는 Interfate로 되어있기 때문에 메서드들을 오버라이딩 해서
            사용해야 하기 때문에 LinkedList를 이용하여
         */

        Queue queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);

        System.out.println("Practice 1");
        MyQueue1 m1 = new MyQueue1();
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

        System.out.println("Practice 2");
        MyQueue2 m2 = new MyQueue2(5);
        m2.enqueue(1);
        m2.enqueue(2);
        m2.enqueue(3);
        m2.enqueue(4);
        m2.enqueue(5);
        m2.enqueue(6);

        m2.printQueue();

        System.out.println(m2.dequeue());
        m2.printQueue();

        System.out.println(m2.dequeue());
        m2.printQueue();

        m2.enqueue(6);
        m2.enqueue(7);
        m2.printQueue();

        System.out.println(m2.dequeue());

    }
}


