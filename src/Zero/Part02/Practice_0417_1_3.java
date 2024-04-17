package Zero.Part02;

// 배열을 이용한 기본 큐 구현 (원형 큐 형태)

class MyQueue2 {
    int[] arr;
    int front = 0;
    int rear = 0;
    MyQueue2(int size) {
        // 원형 큐의 관리를 위해 요청 사이즈의 +1 을 해야한다
        // 비어있거나 꽉차있을 때 front와 rear가 같은 곳을 가리키기 때문에
        arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void enqueue(int data) {
        if(this.isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue() {
        if(this.isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        // front는 비워두기 때문에 + 1
        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        // 원형이니까 돌아가야 할 때는 나머지를 이용한다
        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
public class Practice_0417_1_3 {
    public static void main(String[] args) {
        MyQueue2 m = new MyQueue2(5);
        m.enqueue(1);
        m.enqueue(2);
        m.enqueue(3);
        m.enqueue(4);
        m.enqueue(5);
        m.printQueue();

        System.out.println(m.dequeue());
        m.printQueue();

        System.out.println(m.dequeue());
        m.printQueue();

        m.enqueue(6);
        m.enqueue(7);
        m.printQueue();

        System.out.println(m.dequeue());
        System.out.println(m.dequeue());
        System.out.println(m.dequeue());
        m.printQueue();
        System.out.println(m.isFull());
        System.out.println(m.isEmpty());


    }
}

