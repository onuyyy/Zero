package Zero.Part02.Part04;

import java.util.Arrays;

public class Practice_0418 {
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,3};
        bubbleSort(arr);
        System.out.println("버블 정렬 : " + Arrays.toString(arr));

        int[] arr2 = {5,6,3,3,2,7,2};
        insertSort(arr2);
        System.out.println("삽입 정렬 : " + Arrays.toString(arr2));

        int[] arr3 = {5,7,8,9,3,2};
        selectionSort(arr3);
        System.out.println("선택 정력 : " + Arrays.toString(arr3));
    }
}
