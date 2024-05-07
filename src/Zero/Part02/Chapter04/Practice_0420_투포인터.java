package Zero.Part02.Chapter04;

import java.util.Arrays;

public class Practice_0420_투포인터 {
    public static int[] forLoop(int[] arr, int target) {

        int[] result = {-1,-1};
        for (int i = 0; i < arr.length; i++) {
            // 부분합 계산할 변수
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(sum == target) {
                    result[0] = i;
                    result[1] = j - 1;
                    break;
                }
                // sum 값이 안 될 경우엔 더함
                sum += arr[j];
            }
            // 바깥 for문 탈출하기 위해 한 번 더 break
            if(sum == target) {
                break;
            }
        }
        return result;
    }
    public static int[] twoPointers(int[] arr, int target) {

        // 슬라이딩 윈도우 알고리즘
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] result = {-1, -1};

        while(true) {
            if(sum > target) {
                // 이전 인덱스의 값을 빼기
                sum -= arr[p1++];
            } else if (p2 == arr.length) {
                // 끝까지 도달했는데 못 찾았을 때
                break;
            } else {
                // 다음 인덱스의 값을 더하기
                sum += arr[p2++];
            }

            if(sum == target) {
                result[0] = p1;
                result[1] = p2 - 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,5,3,7,2,4,3,2};
        System.out.println(Arrays.toString(forLoop(arr,9)));
        System.out.println(Arrays.toString(forLoop(arr,14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr,9)));
        System.out.println(Arrays.toString(twoPointers(arr,14)));
    }
}
