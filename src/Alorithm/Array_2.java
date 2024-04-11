package Alorithm;

import java.util.Arrays;

public class Array_2 {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        // 정렬 분할
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr,tmp,left,mid);
            mergeSort(arr,tmp,mid+1,right);
            // 역순으로 합병
            merge(arr,tmp,left,right,mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right,int mid) {
        // 정렬 합병
        int p = left;
        int q = mid + 1;
        int idx = p;

        while(p <= mid || q <= right) {
            if(p <= mid && q <= right) {
                if(arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if(p <= mid && q > right) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }
        for(int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,2,4,8};
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
