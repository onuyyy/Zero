package Zero.Part02.Chapter03;
/*
    주어진 그래프를 두 개의 그래프로 분리할 수 있는지 확인하는 프로그램
    분리 조건 : 인접하지 않은 노드끼리 분리

    모든 노드는 연결되어 있고 분리 가능하면 true , 불가능하면 false 출력

    입력
    그래프 : {{1,3},{0,2},{1,3},{0,2}}
    출력 : true

    그래프 : {{1,2,3},{0,2},{0,1,3},{0,2}}
    출력 : false
 */
public class Graph_7 {
    public static void solution(int[][] graph) {
        // flag 변수 > 간선정보가 아니라서 노드 개수만큼에 대한 거기 때문에 length
        int[] flags = new int[graph.length];

        // 처음 설정할 flag값 1, 처음 순회할 노드 0
        if (checkSplit(graph, flags, 1, 0) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean checkSplit(int[][] gr, int[] flags, int flag, int node) {

        // 재귀 호출을 위한 탈출
        if (flags[node] != 0) {
            // 0이 아니면 해당 노드는 이미 1 또는 -1로 지정된 상태
            // 다른 순회 과정에서 반복했던 부분을 호출하는 부분으로
            // 현재 노드에 설정하려는 flag와 같은지 확인하고 true
            // 다른 값으로 세팅이 되어있으면 인접한 노드이니까 false
            return flags[node] == flag;
        }

        // 처음엔 1이란 값으로 세팅
        flags[node] = flag;

        for (int adjacentNode : gr[node]) {
            // 모든 인접 노드에 대해 재귀 호출
            // 인접 노드에는 반대 그룹 -flag를 설정
            if (!checkSplit(gr, flags, -flag, adjacentNode)) {
                // 재귀 호출 중 하나라도 false를 반환하면 이분 그래프가 아니다
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // 0,1,2,3 의 각 노드들의 간선정보가 들어있는 것임
        int[][] gr = {{1,3},{0,2},{1,3},{0,2}};
        solution(gr);

        gr = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        solution(gr);
    }
}
