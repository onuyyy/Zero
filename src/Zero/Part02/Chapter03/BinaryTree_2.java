package Zero.Part02.Chapter03;

// 연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    char data;
    Node3 left;
    Node3 right;

    public Node3(char data, Node3 left, Node3 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class BinaryTree2 {
    Node3 head;
    BinaryTree2() {}
    BinaryTree2(char[] arr) {
        // Node 형태의 배열로 만들기
        Node3[] nodes = new Node3[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 각 노드에 데이터 넣음
            nodes[i] = new Node3(arr[i], null, null);
        }

        // 현재 노드에 자식 노드 연결 하기
        for (int i = 0; i < arr.length; i++) {
            // 자식 노드 인덱스 찾기
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            // 인덱스의 범위 체크
            if(left < arr.length) {
                // 자식 노드가 있으면 현재 노드에 왼쪽에 노드 연결
                nodes[i].left = nodes[left];
            }

            if(right < arr.length) {
                // 자식 노드가 있으면 현재 노드에 오른쪽에 노드 연결
                nodes[i].right = nodes[right];
            }
        }
        // 루트 노드에 대한 연결 부분 넣어주기
        this.head = nodes[0];
    }

    public void preOrder(Node3 node) {
        // 재귀 함수의 탈출 조건 명시
        if(node == null) {
            return;
        }

        // 전위 순회니까 현재 노드 먼저 출력
        System.out.print(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node3 node) {
        if(node == null) {
            return;
        }

        this.inOrder(node.left);
        System.out.print(node.data + " ");
        this.inOrder(node.right);
    }

    public void postOrder(Node3 node) {
        if(node == null) {
            return;
        }

        this.postOrder(node.left);
        this.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node3 node) {
        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node3 cur = queue.poll();

            System.out.print(cur.data +  " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }

            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
public class BinaryTree_2 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("PreOrder");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("InOrder");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("PostOrder");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("LevelOrder");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
