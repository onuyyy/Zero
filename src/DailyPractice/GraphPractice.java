package DailyPractice;


class GraphNode {
    int id;
    GraphNode next;

    public GraphNode(int id, GraphNode next) {
        this.id = id;
        this.next = next;
    }
}
class MyGraphList {
    /*
        인접 리스트를 이용한 그래프 구현
     */
    char[] vertices;
    GraphNode[] adjList;
    int elemCnt;

    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new GraphNode[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    // 양방향
    public void addEdge(int x, int y) {
        this.adjList[x] = new GraphNode(y,this.adjList[x]);
        this.adjList[y] = new GraphNode(x,this.adjList[y]);
    }

    // 단방향
    public void addDirectedEdge(int x, int y) {
        this.adjList[x] = new GraphNode(y, this.adjList[x]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i]+ ": ");

            GraphNode cur = this.adjList[i];
            while (cur != null) {
                System.out.print(this.vertices[cur.id]+ " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
class MyGraphMatrix {
    /*
      인접 행렬을 이용한 그래프 구현
    */
    char[] vertices; // 데이터 담을 변수
    int[][] adjMat; // 인접 행렬 간선 정보
    int elemCnt; // 정점의 개수

    public MyGraphMatrix() {}
    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    // 방향 그래프이면 한 쪽만 업데이트
    public void addDirectEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char item : this.vertices) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class GraphPractice {
    public static void main(String[] args) {
        MyGraphMatrix m = new MyGraphMatrix(4);

        System.out.println("Practice 1");
        m.addVertex('A');
        m.addVertex('B');
        m.addVertex('C');
        m.addVertex('D');

        m.addEdge(0,1);
        m.addEdge(0,2);
        m.addEdge(1,2);
        m.addEdge(1,3);
        m.addEdge(2,3);
        m.printAdjacentMatrix();

        System.out.println("Practice 2");
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

