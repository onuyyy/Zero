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
    public boolean findData(int data) {
        if(this.isEmpty()) {
            System.out.println("List is Empty");
        }

        Node cur = this.head;
        while (cur != null) {
            if(cur.data == data) {
                System.out.println("data exist!");
                return true;
            }
            cur = cur.next;
        }
        return false;
        // System.out.println("data not found!");
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
    /*
        연결 리스트 배열 사용 연습

        주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성
        관리 규칙 : 각 문자열의 첫 글자가 같은 것끼리
                   같은 연결 리스트로 관리하기
     */
    public static LinkedListPr reverseList(LinkedListPr list, int left, int right) {
        /*
            연결 리스트 부분 뒤집기
            주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오

            입력 연결 리스트 : 1,2,3,4,5
            시작 : 2 / 끝 : 4
            결과 연결 리스트 : 1,4,3,2,5
         */

        Node cur1 = null;
        Node pre1 = null;

        cur1 = list.head;
        for (int i = 0; i < left - 1; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        Node cur2 = cur1;
        Node pre2 = pre1;
        Node after = null;
        for (int i = left; i <= right ; i++) {
            after = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = after;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return list;
    }

    public static boolean checkPalindrome(LinkedListPr list) {
        /*
            추가 자료구조 없이 연결 리스트만으로 풀기
            Palindrome : 앞으로 읽어도 뒤로 읽어도 같은 문자열

            입력 : 1,3,5,3,1
            결과 : true
         */

        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        // 원소 몇 개있는지 확인
        int cnt = 0;
        while (cur != null) {
            cnt++;
            // 가장 끝 노드를 가리키기
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        // 원소 개수의 절반만큼만 비교하면 되니까 / 2
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = left;
            // 다음 노드를 비교해야 하니까 right 노드와 같은 걸 가리키는
            // prevRight 노드 전의 노드를 가리키기 위하여 !- prevRight
            while (right.next != prevRight) {
                right = right.next;
            }
        }
        return true;
    }

    public static LinkedListPr removeDup(LinkedListPr listBefore) {
    /*
        단방향 연결 리스트에서 중복 데이터를 찾아 삭제
        입력 연결 리스트 : 1, 3, 3, 1, 4, 2, 4, 2
        결과 : 1, 3, 4, 2
     */
        LinkedListPr listAfter = new LinkedListPr();
        Node cur = listBefore.head;
        while (cur != null) {
            if(!listAfter.findData(cur.data)) {
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }
        return listAfter;
    }
    public static void main(String[] args) {
        LinkedListPr list = new LinkedListPr(new Node(1,null));
        list.showData();

        list.addData(2);
        list.addData(1);
        list.addData(3);
        list.addData(4);
        list.addData(2);
        list.addData(3);
        list.addData(5);
        list.addData(6);

        list = removeDup(list);
        list.showData();


        //
        System.out.println(checkPalindrome(list));

        list = new LinkedListPr(new Node(1,null));
        list.addData(2);
        list.addData(2);
        list.addData(1);
        System.out.println(checkPalindrome(list));

        list = new LinkedListPr(new Node(1,null));
        list.addData(2);
        list.addData(3);
        list.addData(2);
        list.addData(1);
        System.out.println(checkPalindrome(list));

        list = new LinkedListPr(new Node(1,null));
        list.addData(2);
        list.addData(5);
        list.addData(1);
        System.out.println(checkPalindrome(list));

        //
        list = new LinkedListPr(new Node(1,null));
        list.addData(2);
        list.addData(3);
        list.addData(4);
        list.addData(5);
        list = reverseList(list,3,5);
        list.showData();
    }
}
