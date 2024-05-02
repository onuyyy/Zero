package Zero.Part02.Chapter04;

import java.util.Arrays;

public class Practice_0420_이진탐색 {
    public static int binarySearch(int[] arr, int target) {

        // 반복문 구조로 이진 탐색 구현
        int left = 0;
        int right = arr.length - 1; // 끝 인덱스

        while(left <= right) { // left와 right가 만날 때까지
            int mid = (left + right) / 2;

            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                // left는 가장 왼쪽 right은 중앙의 그 왼쪽 부분 가리킴
                // 좌측 부분 기준으로 다시 탐색하기 위해
                right = mid - 1;
            } else {
                // 우측 부분 기준으로 다시 탐색
                left = mid + 1;
            }
        }

        return -1;
    }
    public static int binarySearch2(int[] arr, int target, int left, int right) {

        // 재귀 호출 구조
        if(left > right) {
            // 탈출 조건
            return -1;
        }

        int mid = (left + right) / 2;

        if(target == arr[mid]) {
            return mid;
        } else if(target < arr[mid]) {
            return binarySearch2(arr, target, left, mid-1);
        } else {
            return binarySearch2(arr,target,mid + 1, right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,30,40,50,60};

        System.out.println("index : " + binarySearch(arr,30));
        System.out.println();

        System.out.println("index : " + binarySearch2(arr,30,0,arr.length - 1));

        // 자바에서 제공하는 Binary Search 사용
        System.out.println("== 데이터가 있는 경우 ==");
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,30));

        System.out.println("== 데이터가 없는 경우 ==");
        System.out.println(Arrays.binarySearch(arr,3));
        System.out.println(Arrays.binarySearch(arr,11));
        System.out.println(Arrays.binarySearch(arr,35));
    }
}
