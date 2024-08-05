package Zero.Part02.Chapter03;

import java.util.LinkedList;
import java.util.Queue;

class Node4 {
    char data;
    Node4 left;
    Node4 right;
    Node4 parent;

    public Node4(char data, Node4 left, Node4 right, Node4 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
class BinaryTree3 {
    Node4 head;

    BinaryTree3(char[] arr) {
        Node4[] nodes = new Node4[arr.length];

        // 각각의 노드들 초기화 하기
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node4(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            // 자식 노드의 인덱스 잡기
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // 범위 비교하기
            if(left < arr.length) {
                nodes[i].left = nodes[left];
                // 부모 쪽도 연결하기 
                nodes[left].parent = nodes[i];
            }

            if(right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        // Root 노드 넣어주기
        this.head = nodes[0];
    }

    public Node4 searchNode(char data) {
        Queue<Node4> queue = new LinkedList<>();

        // 레벨오더 순으로 찾아감
        queue.add(this.head);
        while (!queue.isEmpty()) {
            Node4 cur = queue.poll();
            if(cur.data == data) {
                return cur;
            }

            if(cur.left != null) {
                queue.offer(cur.left);
            }

            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data) {
        Node4 node = this.searchNode(data);

        Queue<Node4> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while (!queue.isEmpty()) {
            Node4 cur = queue.poll();

            if(cur.left != null) {
                queue.offer(cur.left);
                size++;
            }

            if(cur.right != null) {
                queue.offer(cur.right);
                size++;
            }
        }
        // size 0부터 시작했으니까 + 1;
        return size + 1;
    }
}
public class BinaryTree_3 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }
        
        BinaryTree3 bt = new BinaryTree3(arr);
        
        // Root Node 출력
        System.out.println("bt.head.data = " + bt.head.data);

        // B's Child Node
        Node4 B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B -> left Child : " + B.left.data);
        }
        if(B.right != null) {
            System.out.println("B -> right Child : " + B.right.data);
        }

        // F's Parent Node
        Node4 F = bt.searchNode('F');
        System.out.println("F -> parent : " + F.parent.data);

        // Leaf Node
        System.out.print("Leaf node : ");
        for (int i = 0; i < arr.length; i++) {
            Node4 cur = bt.searchNode((char)('A' + i));

            if(cur.left == null & cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();

        // E's Depth
        Node4 E = bt.searchNode('E');
        Node4 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E depth : " + cnt);

        // Level 2 Node
        System.out.println("Level 2 Node");
        for (int i = 0; i < arr.length; i++) {
            Node4 target = bt.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if(cnt == 2) {
                System.out.print(target.data + " ");
            }
        }
        System.out.println();

        // Tree Height
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node4 target = bt.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if(maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Height = " + maxCnt);

        // B's size : 자신을 포함한 자식 노드의 개수
        int size = bt.checkSize('B');
        System.out.println("B size = " + size);
    }
}
