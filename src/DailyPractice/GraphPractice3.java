package DailyPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    인접 리스트를 이용한 dfs, bfs
 */
class MyGraphList2 extends MyGraphList {
   public MyGraphList2(int size) {
       super(size);
   }

   public void dfs(int id) {
       boolean visited[] = new boolean[this.elemCnt];
       Stack<Integer> stack = new Stack<>();

       stack.push(id);
       visited[id] = true;

       while (!stack.isEmpty()) {
           int curId = stack.pop();
           System.out.print(this.vertices[curId] + " ");

           GraphNode cur = this.adjList[curId];

           while (cur != null) {
                if (visited[cur.id] == false) {
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

           GraphNode cur = this.adjList[curId];
           while (cur != null) {
               if (visited[cur.id] == false) {
                   queue.offer(cur.id);
                   visited[cur.id] = true;
               }
               cur = cur.next;
           }
       }
       System.out.println();
   }
}
public class GraphPractice3 {
    public static void main(String[] args) {
        MyGraphList2 m = new MyGraphList2(7);
        m.addVertex('A');
        m.addVertex('B');
        m.addVertex('C');
        m.addVertex('D');
        m.addVertex('E');
        m.addVertex('F');
        m.addVertex('G');

        m.addEdge(0,1);
        m.addEdge(0,2);
        m.addEdge(0,3);
        m.addEdge(1,4);
        m.addEdge(2,5);
        m.addEdge(3,4);
        m.addEdge(3,5);
        m.addEdge(4,6);
        m.addEdge(5,6);
        m.dfs(0);
        m.bfs(0);
    }
}

