package DailyPractice;

import java.nio.file.NotDirectoryException;

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedListPr {
    NodeBi head;
    NodeBi tail;


    DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        if(this.head == null) {
            return  true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) {
            // beforedata가 없으면 가장 끝에 추가
            this.tail.next = new NodeBi(data, null, this.tail);
            // tail 바꿔주기
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if(cur == this.head) {
                        this.head = new NodeBi(data, this.head, null);
                        this.head.next.prev = this.head;
                    } else {
                        // head가 아닐 때
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    // Node가 1개인 case (head와 tail이 같다)
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    // head이고 node가 2개 이상인 case
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) {
                    // tail일 때는 끝을 가리킨 tail은 기존의 prev로 바꿔주고
                    // next는 없애기
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    // 중간 노드 삭제할 때
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        NodeBi cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void showDataFromTail() {
        if (this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        // tail부터 출력
        NodeBi cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}
public class LinkedList3 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(new NodeBi(1, null, null));
        list.showData();

        list.addData(2, null);
        list.addData(3, null);
        list.addData(4, null);
        list.addData(5, null);
        list.showData();
        list.showDataFromTail();

        list.addData(100, 1);
        list.addData(200, 2);
        list.addData(300, 3);
        list.addData(400, 4);
        list.addData(500, 5);
        list.showData();
        list.showDataFromTail();

        list.removeData(300);
        list.removeData(100);
        list.removeData(500);
        list.removeData(200);
        list.removeData(400);
        list.showData();
        list.showDataFromTail();

        list.removeData(1);
        list.removeData(2);
        list.removeData(3);
        list.removeData(4);
        list.removeData(5);
        list.showData();
        list.showDataFromTail();

    }
}
