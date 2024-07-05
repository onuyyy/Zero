package Zero.Part02.Chapter03;
// 인접 리스트를 이용한 그래프

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}
class MyGraphList {
    char[] vertices;
    Node[] adjList;
    int elemCnt;
    public MyGraphList() {};
    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if(isFull()) {
            System.out.println("Graph is Full!");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        // 양방향 인접리스트
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }

    public  void addDirectEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + ": ");

            Node cur = this.adjList[i];
            while (cur != null) {
                System.out.print(this.vertices[cur.id] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
public class Graph_2 {
    public static void main(String[] args) {
        MyGraphList mg = new MyGraphList(4);
        mg.addVertex('A');
        mg.addVertex('B');
        mg.addVertex('C');
        mg.addVertex('D');

        mg.addEdge(0,1);
        mg.addEdge(0,2);
        mg.addEdge(1,2);
        mg.addEdge(1,3);
        mg.addEdge(2,3);
        mg.printAdjacentList();
    }
}
