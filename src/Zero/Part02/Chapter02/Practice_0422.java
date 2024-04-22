package Zero.Part02.Chapter02;
/*
    데이터를 링크로 연결해서 관리하는 자료구조
    자료의 순서는 있지만, 메모리상 연속성이 보장되지 않음

    장점 : 데이터 공간 미리 할당할 필요 없고, 길이가 가변적이라 추가/삭제 용이
    단점 : 연결 구조를 위한 별도 데이터 공간 필요, 연결 정보 찾는 시간 필요(속도가 상대적으로 느림)
            데이터 추가, 삭제 시 앞뒤 데이터의 연결을 재구성하는 작업 필요
 */

class Node {
    // 실제 데이터
    int data;
    // 노드 포인터
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
class LinkedList {
    Node head;

    LinkedList(Node node) {
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
            // head 가 비어있으면 head 쪽에 노드 생성
            // 다음 데이터는 아직 없으니까 null
            this.head = new Node(data, null);
        } else {
            // 기존 노드들이 있는 경우 head로부터 끝까지 순회하여
            // 가장 끝에 노드 생성
            Node cur = this.head;
            while (cur.next != null) {
                // 남아있는 주소 순회하다가 마지막 주소를 cur에 할당하고
                cur = cur.next;
            }
            // next에 새로운 node 생성
            cur.next = new Node(data,null);
        }
    }

    // 연결 리스트의 맨 뒤에 데이터 삭제
    public void removeData() {
        if(this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node cur = this.head;
        // 마지막 노드를 가리키는 노드에 포인터를 null로 만들어야 하기 때문에
        Node prev = cur;

        while (cur.next != null) {
            // cur를 이동시키면서 cur에 다음 노드 포인터를 두고
            // prev에 현재 노드를 넣음
            prev = cur;
            cur = cur.next;
        }

        // java에선 garbage collector가 정리해주기 때문에
        // 링크 관리만 잘하면 된다 (연결된 링크 끊기 + 추가)
        if(cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    // 연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if(this.head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = this.head;
        while(cur != null) {
            if(cur.data == data) {
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data Not found!");
    }

    // 연결 리스트의 모든 데이터 출력
    public void showData() {
        if(this.head == null) {
            System.out.println("List is empty!");
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
public class Practice_0422 {
    public static void main(String[] args) {
        LinkedList l = new LinkedList(new Node(1,null));
        l.showData();

        l.addData(2);
        l.addData(3);
        l.addData(4);
        l.addData(5);
        l.addData(6);
        l.addData(7);
        l.showData();

        l.findData(3);
        l.findData(10);

        l.removeData();
        l.removeData();
        l.removeData();
        l.showData();
    }
}

