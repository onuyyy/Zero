package DailyPractice;

class LinkedListPr2 {
    Node head;

    LinkedListPr2(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        if(this.head == null) {
            return  true;
        }
        return false;
    }

    public void addData(int data) {
        if(this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData() {
        if(isEmpty()) {
            System.out.println("List is Empty");
        } else {
            Node cur = this.head;
            Node prev = cur;

            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
            }

            if(cur == this.head) {
                this.head = null;
            } else {
                prev.next = null;
            }
        }
    }

    public void findData(int data) {
        if(this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if(cur.data == data) {
                System.out.println("data exist");
                return;
            }
            cur = cur.next;
        }

        System.out.println("data no found");
    }

    public void showData() {
        if(this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 연결 리스트에 데이터 추가
    // before data가 null이면 가장 뒤에 추가
    // before data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if(this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            // cur을 쫓아 다닐 pre
            Node pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    // beforedata가 있을 때 앞에 추가함
                    if(cur == this.head) {
                        // beforedata가 head일 경우에는
                        // head에 new node 만들어주고,
                        // 만들어진 head의 next는 이전 head를 넣어준다
                        this.head = new Node(data, this.head);
                    } else {
                        // 중간에 들어가는 경우
                        pre.next = new Node(data, cur);
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
            System.out.println("Empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }
}

public class LinkedList2 {



    public static void main(String[] args) {
        LinkedListPr2 list = new LinkedListPr2(new Node(1, null));
        list.showData();

        list.addData(2);
        list.addData(3);
        list.addData(4);
        list.addData(5);
        list.showData();

        list.addData(100, 1);
        list.addData(200, 2);
        list.addData(300, 3);
        list.addData(400, 4);
        list.addData(500, 5);
        list.showData();

        list.removeData(300);
        list.removeData(100);
        list.removeData(500);
        list.removeData(200);
        list.removeData(400);
        list.showData();

        list.removeData(3);
        list.removeData(1);
        list.removeData(5);
        list.removeData(2);
        // list.removeData(4);
        list.showData();
    }
}
