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

    public void AddVertex(int data) {
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

    }
    public static void main(String[] args) {

    }
}
