package Zero.Part02;

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        if(this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if(this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if(this.isFull()) {
            // 꽉 차있으면 넣을 수 없기 때문에
            System.out.println("Stack is Full!");
            return;
        }
        this.top += 1;
        // 탑 위치에 data push
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if(this.isEmpty()) {
            // 비어있으면 꺼낼 데이터가 없기 때문에
            System.out.println("Stack is Empty!");
            return null;
        }
        int data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

    public Integer peek() {
        if(this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}
public class Practice_0416T2 {
    public static void main(String[] args) {
        MyStack2 m = new MyStack2(5);
        m.isEmpty();
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        m.push(5);
        m.push(6);
        m.printStack();

        System.out.println(m.peek());
        m.printStack();

        System.out.println(m.pop());
        System.out.println(m.pop());
        m.printStack();

        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        m.printStack();

    }
}
