package Zero.Part02.Chapter03;

class Bt {
    int h;
    int[] arr;
    int res;

    public Bt(int h, int[] w) {
        this.h = h;
        // 노드 7기준으로 8로 잡고 한 칸 사용 안 하면 됨
        arr = new int[(int)Math.pow(2, h + 1)];
        res = 0;

        // i부터 시작하는 이유 > 배열이 8로 잡혀있으면 1개는 사용 안 하고,
        // 노드 값이 아닌 간선의 가중치를 기록할 것이니 때문에 또 -1 해서 2부터 시작
        for (int i = 2; i < (int)Math.pow(2, h + 1); i++) {
            arr[i] = w[i - 2];
        }
    }

    public int dfs(int idx, int h) {
        if(this.h == h) {
            res += arr[idx];
            return arr[idx];
        }
        int left = dfs(idx * 2, h + 1);
        int right = dfs(idx * 2 + 1, h + 1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}
public class BinaryTree_4 {
    public static void solution2(int h, int[] w) {
        /*
            각각의 엣지에 가중치가 있는 포화 이진 트리가 있을 때
            루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
            이때 모든 가중치들의 총합이 최소가 되도록 하는 프로그램
         */

        Bt bt = new Bt(h, w);
        bt.dfs(1, 0);
        System.out.println(bt.res);
    }
    public static void solution(int n) {
        // 포화이진트리니까 2의n승개만큼 만들어 줌
        int[] bt = new int[(int)Math.pow(2,n)];

        // 맨 처음 접으면 0이니까
        bt[0] = 0;
        // idx 0에 이미 0을 넣었으니까 n - 1
        for (int i = 0; i < (int)Math.pow(2, n - 1) - 1; i++) {
            bt[i * 2 + 1] = 0;
            bt[i * 2 + 2] = 1;
        }

        inOrder(bt, 0);
        System.out.println();
    }

    public static void inOrder(int[] arr, int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // 위에서 배열의 끝 부분은 사용하지 않기 때문에 -1 해서 빈 마지막 부분은 x
        if (left < arr.length - 1) {
            inOrder(arr, left);
        }

        System.out.print(arr[idx] + " ");

        if(right < arr.length - 1) {
            inOrder(arr, right);
        }
    }
    public static void main(String[] args) {
        System.out.println("Solution");
        solution(1);
        solution(2);
        solution(3);

        System.out.println("Solution2");
        int h = 2; // tree height
        int[] w = {2, 2, 2, 1, 1, 3}; // tree 각각 엣지의 가중치
        solution2(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1,2,1,3,2,4,1,1,1,1,1,1,1,1};
        solution2(h, w);
        System.out.println();
    }
}
