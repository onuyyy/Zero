package Alorithm;

import java.util.Arrays;

public class Array_1 {

    public static void bubbleSort(int[] arr) {
        // i를 앞부터 지정
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr [j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        // i를 끝부터 지정
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr [j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,2,8,9,7};
        bubbleSort(arr);
        System.out.println("버블 정렬 :" +Arrays.toString(arr));

        arr = new int[]{4,3,7,2,0};
        insertSort(arr);
        System.out.println("삽입 정렬 :" +Arrays.toString(arr));

        arr = new int[]{1,5,2,3,6};
        selectSort(arr);
        System.out.println("선택 정렬 :" +Arrays.toString(arr));
    }
}
