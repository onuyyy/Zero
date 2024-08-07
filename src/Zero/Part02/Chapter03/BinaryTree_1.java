package Zero.Part02.Chapter03;

// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int idx) {
        System.out.print(this.arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 재귀 함수 호출하여 왼쪽부터 순회하기 위함
        if(left < this.arr.length) {
            this.preOrder(left);
        }
        if(right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void inOrder(int idx) {
        // 왼 > 현 > 오
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < this.arr.length) {
            this.inOrder(left);
        }
        System.out.print(this.arr[idx] +  " ");

        if(right < this.arr.length) {
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) {
        // 왼 > 오 > 현
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < this.arr.length) {
            this.postOrder(left);
        }

        if(right < this.arr.length) {
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
    }
}
public class BinaryTree_1 {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree tree = new BinaryTree(arr);
        System.out.println("Preorder");
        tree.preOrder(0);
        System.out.println();

        System.out.println("inOrder");
        tree.inOrder(0);
        System.out.println();

        System.out.println("postOrder");
        tree.postOrder(0);
        System.out.println();

        System.out.println("levelOrder");
        tree.levelOrder(0);
        System.out.println();
    }
}
