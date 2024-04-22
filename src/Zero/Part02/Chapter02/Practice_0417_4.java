package Zero.Part02.Chapter02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

/*
    데이터 재정렬
    D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
    D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬

    입력 : 1 -> 2 -> 3 -> 4 -> 5
    출력 : 1 -> 5 -> 2 -> 4 -> 3
 */
public class Practice_0417_4 {
    public static void reorderData(int[] arr) {
        Deque d = new ArrayDeque();

        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> d.addLast(x));
        System.out.println(d);

        while(!d.isEmpty()) {
            result.add(d.removeFirst());

            if(!d.isEmpty()) {
                result.add(d.removeLast());
            }
        }

        System.out.println("== 정렬 전 ==");
        printData(arr);

        System.out.println("== 정렬 후 ==");
        printData(result.stream().mapToInt(x ->(int)x).toArray());
    }

    public static void printData(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " -> ");
        }
        // 마지막 원소 값
        System.out.println(arr[arr.length - 1]);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reorderData(arr);
        int[] arr2 = {1,2,3,4,5,6,7};
        reorderData(arr2);

    }
}
