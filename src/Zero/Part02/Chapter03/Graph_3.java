package Zero.Part02.Chapter03;
// 인접 행렬 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphMatrix2 extends MyGraphMatrix {

    public MyGraphMatrix2(int size) {
        super(size);
    }

    public void dfs(int id) {
        // 스택 자료구조와 방문 배열 만들기
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            // 거꾸로 탐색하기
            for (int i = this.elemCnt - 1; i >= 0; i--) {
                // 해당 위치가 1이면 간선 정보가 있는 것,
                if(this.adjMat[curId][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    // BFS
    public void bfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0 ; i--) {
                if(this.adjMat[curId][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}
public class Graph_3 {
    public static void main(String[] args) {
        MyGraphMatrix2 mg = new MyGraphMatrix2(7);
        mg.addVertex('A');
        mg.addVertex('B');
        mg.addVertex('C');
        mg.addVertex('D');
        mg.addVertex('E');
        mg.addVertex('F');
        mg.addVertex('G');

        mg.addEdge(0,1);
        mg.addEdge(0,2);
        mg.addEdge(0,3);
        mg.addEdge(1,4);
        mg.addEdge(2,5);
        mg.addEdge(3,4);
        mg.addEdge(3,5);
        mg.addEdge(4,6);
        mg.addEdge(5,6);
        mg.printAdjacentMatrix();

        System.out.println();
        mg.dfs(0);

        mg.bfs(0);
    }
}

