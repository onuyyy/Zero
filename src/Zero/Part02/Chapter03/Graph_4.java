package Zero.Part02.Chapter03;
// 인럽 리스트 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList {
    public MyGraphList2(int size) {
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

            Node cur = this.adjList[curId];
            while (cur != null) {
                if(visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
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

            Node cur = this.adjList[curId];
            while (cur != null) {
                if(visited[cur.id] == false) {
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }
}
public class Graph_4 {
    public static void main(String[] args) {
        MyGraphList2 mg = new MyGraphList2(7);
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
        mg.dfs(0);
        mg.bfs(0);
    }
}
