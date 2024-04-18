package Zero.Part02;

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque2(int size) {
        // 데크도 원형 데크로 구현
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if(this.isFull()) {
            System.out.println("Deque is Full!");
            return;
        }
        this.arr[this.front] = data;

        // front가 0일 때 위치 조정을 하기위해 -1 해야 하는데 %연산 하면
        // 계속 -1 이기 때문에 arr.length를 한 번 더함
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if(this.isFull()) {
            System.out.println("Deque is Full!");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;

    }
    public Integer removeFirst() {
        if(this.isEmpty()) {
            System.out.println("Deque is Empty!");
            return null;
        }
        // 기본적으로 프론트가 가리키는 공간은 비어있기 때문에
        // +1 하여 다음 공간의 데이터를 지움
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if(this.isEmpty()) {
            System.out.println("Deque is Empty!");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end ; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
public class Practice_0417_3_3 {
    public static void main(String[] args) {
        System.out.println("== 배열을 이용한 데크 구현 ==");

        MyDeque2 m = new MyDeque2(5);
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

        System.out.println(m.removeFirst());
        System.out.println(m.removeFirst());
        System.out.println(m.removeFirst());
        System.out.println(m.removeFirst());
    }
}


