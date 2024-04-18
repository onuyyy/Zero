package Zero.Part02;
/*
    데크 변형
        기본 데크 구조에서 중간 데이터를 추가하는 기능 구현
        단, 추가적인 자료구조 생성하지 않고 구현

        입력 : 초기 데크 size 5
            1, 2, 3, 4
        중간 입력 : 10
        결과 데크 : 1, 2, 10, 3, 4
 */

class MyDeque3 {
    int[] arr;
    int front = 0;
    int rear = 0;
    MyDeque3(int size) {
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

    public void addMiddle(int data) {
        if(this.isFull()) {
            System.out.println("Deque is Full!");
            return;
        }
        // 데크 몇 개인지 세어보자
        int elements = this.rear - this.front;
        // 음수인 경우
        if (elements < 0) {
            elements = this.arr.length + elements;
        }
        // 중간 지점 찾기
        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;
        // 데이터 넣기
        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;
        for (int i = start; i != end; i = (i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;

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
public class Practice_0417_4_3 {
    public static void main(String[] args) {
        MyDeque3 m = new MyDeque3(5);

        m.addFirst(4);
        m.addFirst(3);
        m.addFirst(2);
        m.addFirst(1);
        m.printDeque();

        m.addMiddle(10);
        m.printDeque();
    }
}
