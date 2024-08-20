package DailyPractice;

class Node {
    int data;
    Node next; // 자기 자신이 클래스를 가리킬 노드 자료형

    Node() {}
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedListPr {
    Node head;

    LinkedListPr() {}
    LinkedListPr(Node node) {
        this.head = node;
    }
    // 연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
       if(this.head == null) {
           // List에 데이터가 아예 없으면 Node 생성
           this.head = new Node(data, null);
       } else {
           // Node가 있으면 하나씩 순회하면서 끝까지 도달하여
           Node cur = this.head;
           while (cur.next != null) {
               cur = cur.next;
           }
           cur.next = new Node(data, null);
       }
    }

    // 연결 리스트의 맨 뒤의 데이터 삭제
    public void removeDate() {
        if(this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        // next를 null 바꿔줘야 한다
        // remove할 친구를 cur로 바꿔준다
        Node cur = this.head;
        Node prev = cur;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if(cur == this.head) {
            // data가 head밖에 없으면 head null로 변경
            this.head = null;
        } else {
            prev.next = null;
        }

    }

    // 연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if(this.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if(cur.data == data) {
                System.out.println("data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("data not found!");
    }

    // 연결 리스트들의 모든 데이터 출력
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

}
public class LinkedList {
    public static void main(String[] args) {
        LinkedListPr list = new LinkedListPr(new Node(1,null));
        list.showData();

        list.addData(2);
        list.addData(3);
        list.addData(4);
        list.addData(5);
        list.addData(6);

        list.findData(3);
        list.findData(100);

        list.removeDate();
        list.removeDate();
        list.removeDate();

        list.showData();
    }
}
