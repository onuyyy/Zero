package Zero.Part02.Chapter02;

class LinkedList2 extends LinkedList {

    LinkedList2(Node node) {
        super(node);
    }

    // 연결 리스트에 데이터 추가
    // before_data가 null일 경우, 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public  void addData(int data, Integer beforeData) {
        if(this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            // before가 null이면 가장 뒤에 노드 추가
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while(cur != null) {
                if (cur.data == beforeData) {
                    // beforedata 찾은 상태에서 앞에다 추가
                    if(cur == this.head) {
                        // 현재 노드가 head이면 head에 새로운 데이터 넣고
                        // next를 이전 head 가리킴
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
        if(this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        // 지울 대상의 노드 cur , 그 앞을 쫓아다닐 pre
        Node cur = this.head;
        Node pre = cur;
        while(cur != null) {
            if(cur.data == data) {
                if(cur == this.head) {
                    // 찾은 데이터가 head였으면 cur의 다음을 가리켜서
                    // head를 끊고 다음의 노드를 head로 만들어줌
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
public class Practice_0422_2 {
    public static void main(String[] args) {

        LinkedList2 l = new LinkedList2(new Node(1,null));

        l.showData();
        l.addData(2);
        l.addData(3);
        l.addData(4);
        l.addData(5);
        l.addData(6);
        l.addData(7);
        l.showData();

        l.addData(100,1);
        l.addData(200,2);
        l.showData();
        l.addData(300,3);
        l.addData(400,4);
        l.showData();

        l.removeData(100);
        l.removeData(300);

        l.showData();
    }

}
