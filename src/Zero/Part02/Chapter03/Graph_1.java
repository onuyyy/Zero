package Zero.Part02.Chapter03;

class MyGraphMatrix {
    // 데이터 담는 변수
    char[] vertices;
    // 2차원 인접 행렬
    int[][] adjMat;
    // 실제 그래프에 정점(노드)에 개수가 몇 개 들어왔는지
    int elemCnt;

    public MyGraphMatrix() {}
    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        // 꽉 찼는지 확인하는 메서드
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if(isFull()) {
            System.out.println("Graph is Full!");
            return;
        }
        // 해당 위치에 데이터를 추가하고 카운트를 늘려주기
        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        // 정점 정보를 입력하기
        // 무방향 그래프일 때는 양쪽 다 업데이트
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    public  void addDirectEdge(int x, int y) {
        // 방향 그래프일 땐 한 쪽만 업데이트
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    public void deleteDirectEdge(int x, int y) {
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
public class Graph_1 {
    public static void main(String[] args) {
        MyGraphMatrix mg = new MyGraphMatrix(4);

        mg.addVertex('A');
        mg.addVertex('B');
        mg.addVertex('C');
        mg.addVertex('D');

        mg.addEdge(0,1);
        mg.addEdge(0,2);
        mg.addEdge(1,2);
        mg.addEdge(1,3);
        mg.addEdge(2,3);
        mg.printAdjacentMatrix();
    }

}
