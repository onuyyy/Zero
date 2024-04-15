package Zero.Part02;
/*
    배열 arr 에서 중복 값을 제거한 새 배열 만들기
 */
public class Practice_0415_2_6 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,2,3,1,4,1,2,3,5};
        int[] arrResult = new int[arr.length];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false; // 증복 값 체크
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arrResult[j]) {
                    dupFlag = true;
                }
            }
            if(dupFlag == false) {
                // 중복 값 아니면 데이터 넣기
                arrResult[cnt++] = arr[i];
            }
        }
        for (int i = 0; i < cnt; i++) {
            System.out.print(arrResult[i] + " ");
        }
    }
}
