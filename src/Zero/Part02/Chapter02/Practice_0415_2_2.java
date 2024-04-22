package Zero.Part02.Chapter02;
/*
    배열 arr에서 target에 해당하는 값의 인덱스를 출력
    해당 값이 여러 개인 경우 가장 큰 인덱스 출력
 */
public class Practice_0415_2_2 {
    public static void main(String[] args) {
        int[] arr = {1,1,100,1,1,1,100};
        int target = 100;
        int idxMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                // 기존 인덱스보다 크면 갱신
                if(i > idxMax) {
                    idxMax = i;
                }
            }
        }
        if(idxMax >= 0) {
            System.out.println(idxMax);
        }
    }
}
