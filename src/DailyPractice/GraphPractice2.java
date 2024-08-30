package DailyPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    인접 행렬을 이용한 dfs, bfs
 */
class MyGraphMatrix2 extends MyGraphMatrix {
    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0  ; i--) {
                if (this.adjMat[curId][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0; i--) {
                if (this.adjMat[curId][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}
public class GraphPractice2 {
    public static void main(String[] args) {
        MyGraphMatrix2 m2 = new MyGraphMatrix2(7);
        m2.addVertex('A');
        m2.addVertex('B');
        m2.addVertex('C');
        m2.addVertex('D');
        m2.addVertex('E');
        m2.addVertex('F');
        m2.addVertex('G');

        m2.addEdge(0,1);
        m2.addEdge(0,2);
        m2.addEdge(0,3);
        m2.addEdge(1,4);
        m2.addEdge(2,5);
        m2.addEdge(3,4);
        m2.addEdge(3,5);
        m2.addEdge(4,6);
        m2.addEdge(5,6);
        m2.printAdjacentMatrix();

        System.out.println();
        m2.dfs(0);
        m2.bfs(0);
    }
}
