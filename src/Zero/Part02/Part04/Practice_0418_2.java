package Zero.Part02.Part04;

import java.util.Arrays;

/*
    합병 정렬 :
        배열을 계속 분할해서 길이가 1이 되도록 만들고,
        인정합 부분끼리 정렬하면서 합병하는 방식

    힙 정렬 :
        힙 자료구조 형태의 정렬 방식
        기존 배열을 최대 힙으로 구조 변경 후 정렬 진행

    퀵 정렬 :
        임의의 기준 값(pivot)을 정하고 그 값을 기준으로
        좌우로 분할하며 정렬하는 방식

        윤영이 바봉 메롱
        나랑 놀장
        가지망 ㅜㅜ
        망원동에 있으라공!!!!!!!!!!!!!
        나는.............................못 보냉.................
        윤영이는 바보지만 ㅜㅜ 못 보내 ㅜㅜ
        -꿀꿀이강...-
 */
public class Practice_0418_2 {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        // 분할
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid); //  좌측
            mergeSort(arr, tmp, mid + 1, right); // 우측
            merge(arr, tmp, left, right, mid);
        }
    }
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) {
            if(p <= mid && q <= right) {
                if(arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
                // 오른쪽에 데이터가 더 없는 경우
            } else if (p <= mid && q > right) {
                // 좌측만 남았을 때
                tmp[idx++] = arr[p++];
            } else {
                // 우측만 남았을 때
                tmp[idx++] = arr[q++];
            }
        }
        // tmp에 있던 정렬 arr에 다시 넣기
        for (int i = left; i <= right; i++) {
            arr[i] =  tmp[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,7,2,8,3,1};
        int[] tmp = new int[arr.length];

        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬 : " + Arrays.toString(arr));
    }
}
