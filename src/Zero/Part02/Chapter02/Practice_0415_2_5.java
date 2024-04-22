package Zero.Part02.Chapter02;
/*
    배열 arr 의 값을 오름차순으로 출력
 */
public class Practice_0415_2_5 {
    public static void main(String[] args) {
        int[] arr = {5,3,1,4,6,1};
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE; // 최소값들로 업데이트 해줄 변수
        int minIdx = -1;

        while(visitCnt < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < minVal && visited[i] == 0) {
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            if(minIdx != -1) {
                System.out.print(minVal + " ");
                visited[minIdx] = 1; // 해당 인덱스 방문 했다는 표시
                visitCnt++;
            }

            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
        System.out.println();
    }
}
