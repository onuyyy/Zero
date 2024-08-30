package DailyPractice;

class BinaryTree {
    // 배열을 이용한 이진 트리 구성, 순회
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int idx) {
        // 현재 > 왼쪽 > 오른쪽
        System.out.print(this.arr[idx] + " ");

        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }
        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void inOrder(int idx) {
        // 왼쪽 > 현재 > 오른쪽

        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (left < this.arr.length) {
            this.inOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if (right < this.arr.length) {
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) {
        // 왼쪽 > 오른쪽 > 현재
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if (left < this.arr.length) {
            this.postOrder(left);
        }
        if (right < this.arr.length) {
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }
}
public class TreePractice {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);
        System.out.println("Preorder");
        bt.preOrder(0);
        System.out.println();

        System.out.println("Inorder");
        bt.inOrder(0);
        System.out.println();

        System.out.println("Postorder");
        bt.postOrder(0);
        System.out.println();
    }
}
