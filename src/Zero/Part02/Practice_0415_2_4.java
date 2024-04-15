package Zero.Part02;
/*
    배열 arr 에서 peek 값 모두 출력
    peek : 좌우측 값보다 크면 peek 값
 */
public class Practice_0415_2_4 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,6,2,2,5,1,9,10,1,11};

        for (int i = 0; i < arr.length; i++) {
            // 첫 번째 값 확인 > 왼쪽에 값이 없기 때문에 오른쪽 값만 비교
            if(i == 0 && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + " ");
                // 두 번째 값 확인 > 오른쪽에 값이 없기 때문에 왼쪽 값만 비교
            } else if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
                System.out.print(arr[i] + " ");
            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println();
    }
}
