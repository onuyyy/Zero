package Zero.Part02.Chapter04;

public class Practice_0420_이진탐색_2 {
    public static  int solution2(int[] arr, int target) {
    /*
        원형 정렬 상태 배열에서의 이진 탐색
        nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
        이진 탐색으로 데이터를 찾는 프로그램을 작성
            - 배열을 재 정렬하지 않고 풀기

        입출력 예시
        arr : 4,5,6,7,8,0,1,2
        target : 0
        출력 : 5

        target : 3
        출력 : -1
     */

        // 예외 처리
        if(arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(target == arr[mid]) {
                return mid;
            }

            // 4,5,6,7,0,1,2 > 중앙 값보다 좌측 값이 작을 때
            if(arr[left] <= arr[mid]) {
                if(target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 11,5,6,7,8,9,10 > 중앙 값보다 좌측 값이 클 때
                if(target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int solution(int[] arr, int target) {
    /*
        이진 탐색 추가 구현
        target 값이 arr 내에 있으면 해당 인덱스 반환
        없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

        - 입출력 예시
        입력 : arr 1,2,5,10,20,30,40,50,60

        target : 30
        출력 : 5

        target : 3
        출력 : -3
     */

        // 예외 처리
        if(arr == null || arr.length == 0) {
            return  -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            
            /*
                오버 플로우 방지할 때 중앙값 찾기
                int mid = left + (right - left) / 2;
             */

            if(target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -left - 1;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,5,10,20,30,40,50,60};
        System.out.println(solution(arr,30));   // 5
        System.out.println(solution(arr,3));    // -3
        System.out.println(solution(arr,11));   // -5
        System.out.println(solution(arr,35));   // -7

        System.out.println("solution 2");
        int[] nums = {4,5,6,7,8,0,1,2};
        System.out.println(solution2(nums,0));  // 5
        System.out.println(solution2(nums,3));  // -1
    }
}
