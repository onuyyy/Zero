package Zero.Part02.Chapter03;
/*
    주어진 그래프에서 시작 노드에서 끝 노드로 가는 길이 있는지 확인하는 프로그램을 작성
    path 가 존재하면 true, 없으면 false 출력

    입력 :
    노드 개수 = 3
    간선 정보 = {{0,1}, {1,2}, {2,0}}
    출발 노드 = 0
    종착 노드 = 2
    출력 = true

    DFS 로 노드 path 있는지 확인하면 된다
 */

import java.util.ArrayList;
import java.util.Stack;

class Node2 {
    int id;
    Node2 next;

    public Node2(int id, Node2 next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList3 {
    int vertices[];
    Node[] adjList;
    int elemCnt;

    public MyGraphList3() {}
    public MyGraphList3(int size) {
        this.vertices = new int[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(int data) {
        if(isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }
}
public class Graph_6 {
    public static void solution(int n, int[][] edges, int source, int dest) {
        // 인접리스트 방식
        MyGraphList3 gr = new MyGraphList3(n);

        // 노드 정보 업데이트
        for (int i = 0; i < n; i++) {
            gr.addVertex(i);
        }

        // 간선 정보 추가
        for (int i = 0; i < edges.length; i++) {
            gr.addEdge(edges[i][0],edges[i][1]);
        }

        // DFS 순회하면서 방문했던 것들 리스트에 넘겨주기
        ArrayList<Integer> visitedItem = new ArrayList<>();
        dfs(gr, 0, visitedItem);

        if(visitedItem.contains(source) && visitedItem.contains(dest)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void dfs(MyGraphList3 gr, int id, ArrayList<Integer> visitedItem) {
        boolean[] visited = new boolean[gr.vertices.length];
        Stack<Integer> stack = new Stack<>();

        // 밑에서 while 문 돌리기 위해 매개변수 0으로 받아서 stack과 visited 생성
        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            visitedItem.add(curId);
            
            // 노드에 간선정보 넣기
            Node cur = gr.adjList[curId];
            while (cur != null) {
                if(visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int dest = 2;
        solution(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        source = 0;
        dest = 5;
        solution(n, edges, source, dest);
    }
}
