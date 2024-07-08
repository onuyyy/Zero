package Zero.Part02.Chapter03;
/*
    Center Node 찾기
    무방향 그래프에서 Center node를 출력
    다른 모든 노드의 연결된 노드를 의미하고, 다른 노드와 연결된 노드는 하나라고 가정

    입력 : {{1,2}, {2,3}, {4,2}}
    출력 : 2

    입력 : {{1,2}, {5,1}, {1,3}, {1,4}}
    출력 : 1

    간선 개수가 가장 많거나, 노드 개수 - 1 한 숫자가 간선의 수인 노드를 찾는다

    solution2 제약 사항
    1. 간선의 총 개수는 노드의 개수 - 1
    2. 모든 노드는 연결되어 있다
 */

class MyGraphMatrix3 {
    char[] vertices;
    int[][] adjMat;
    int elemCnt;

    public MyGraphMatrix3() {}
    public MyGraphMatrix3(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.vertices.length == this.elemCnt;
    }

    public void addVertex(char data) {
        if(isFull()) {
            System.out.println("Graph is Full");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }
}

public class Graph_5 {
    public static int solution(int[][] e) {
        // 들어오는 데이터에 대한 그래프를 구성하기
        // e.length + 1 ? edge 정보는 간선 정보이기 때문에
        // 노드수 + 1로 만들어서 그래프에 대한 정보 만든다
        MyGraphMatrix3 graph = new MyGraphMatrix3(e.length + 1);

        // 반복문으로 간선정보들을 넣어준다
        for (int i = 0; i < e.length; i++) {
            // 인덱스 편하게 하기 위해 0 베이스로 만든다 ( -1 )
            graph.addEdge(e[i][0] - 1 , e[i][1] - 1);
        }

        // 노드수만큼 엣지카운트 위한 변수 만든다
        int[] edgeCnt = new int[e.length + 1];
        // 인접행렬의 길이만큼 돌면서 카운팅한다
        for (int i = 0; i < graph.adjMat.length; i++) {
            for (int j = 0; j < graph.adjMat[i].length; j++) {
                if(graph.adjMat[i][j] == 1) {
                    // 노드에 해당하는 간선수들을 배열 안에 넣게 된다 edgeCnt
                    edgeCnt[i] += 1;
                }
            }
        }

        int maxCnt = -1;
        int maxIdx = -1;
        for (int i = 0; i < edgeCnt.length; i++) {
            if(maxCnt < edgeCnt[i]) {
                // 간선수 제일 많은 것을 찾아 Update
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }

        // 인덱스 구하기 편하게 -1 계산했기 때문에 다시 +1 해준다
        return maxIdx + 1;
    }

    public static int solution2(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        edges = new int[][]{{1,2},{5,1},{1,3},{1,4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
