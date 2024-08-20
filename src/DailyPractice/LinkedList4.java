package DailyPractice;
/*
    원형 리스트 (양방향)
 */

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트에 데이터 추가
    // beforeData가 null인 경우, 가장 뒤에 추가
    // beforeData에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi newNodeBi = new NodeBi(data, null, null);
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        } else if (beforeData == null) {
            // 끝에 데이터 추가
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
            this.tail.next = newNodeBi;
            this.head.prev = newNodeBi;
            this.tail = newNodeBi;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;

            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
                        this.tail.next = newNodeBi;
                        this.head.prev = newNodeBi;
                        this.head = newNodeBi;
                    } else {
                        // node 중간에 추가
                        NodeBi newNodeBi = new NodeBi(data, cur, pre);
                        pre.next = newNodeBi;
                        cur.prev = newNodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while (cur != this.head);
        }
    }

    // 연결 리스트에서 특정 값을 가진 노드 삭제
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
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    // head 지우기
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                } else if (cur == this.tail) {
                    // tail 지우기
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
                } else {
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
        // null로 끝나면 원형리스트라 무한 루프에 돌기 때문에,
        // next와 head가 같을 때까지 한 바퀴 돈다
        while (cur.next != this.head) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        // 가장 끝 노드의 데이터 출렿ㄱ
        System.out.println(cur.data);
    }
}
public class LinkedList4 {
    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList(new NodeBi(1, null, null));
        c.addData(2, null);
        c.addData(3, null);
        c.addData(4, null);
        c.addData(5, null);
        c.showData();

        c.addData(100, 1);
        c.addData(200, 2);
        c.addData(300, 3);
        c.addData(400, 4);
        c.addData(500, 5);
        c.showData();

        c.removeData(300);
        c.removeData(100);
        c.removeData(500);
        c.removeData(200);
        c.removeData(400);
        c.showData();

        c.removeData(3);
        c.removeData(1);
        c.removeData(2);
        c.removeData(4);
        c.removeData(5);
        c.showData();
    }
}

