package Zero.Part02.Chapter04;

import java.util.Arrays;

// 힙 정렬
public class Practice_0418_2_2 {
    public static void heapSort(int[] arr) {
        // 기존 배열 -> 힙 배열
        // 최대힙으로만 변경 
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }

        // 최대힙으로 변경된 것을 재 정렬
        // 맨 처음 노드를 가장 뒤로 보내고 뒤에 노드를 앞으로 보낸다

        // 7,5,6,3,1,4,2
        // 2 5 6 3 1 4 7 >>  7 이 제일 뒤로 간 것으로 기준으로 heapify 재호출
        // 그럼 인덱스 0에 그 다음 큰 값인 6이 갈 거임
       for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0, i);
            heapify(arr,0,i);
        }
    }
    public static void heapify(int[] arr, int parentIdx, int size) {
        // 힙으로 변경
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        if(parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }
    public static void swap(int[] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        public static void main(String[] args) {
            int[] arr = {3,5,2,7,1,4,6};
            heapSort(arr);
            System.out.println(Arrays.toString(arr));
        }
}
