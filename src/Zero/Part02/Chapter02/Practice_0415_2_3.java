package Zero.Part02.Chapter02;

import java.util.Arrays;

/*
    배열 arr의 데이터 순서를 거꾸로 변경하라
    추가 배열 사용없이 구현
 */
public class Practice_0415_2_3 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
