package Zero.Part02;

import java.util.ArrayList;
import java.util.Arrays;

/*
    만은 수의 데이터를 다룰 때 사용,
    각 데이터를 인덱스와 1:1 대응하도록 구성,
    데이터가 메모리 사엥 연속적으로 저장됨,
    인덱스를 이용하여 데이터에 빠르게 접근 가능

    단점 : 데이터의 추가, 삭제가 번거로우며 미리 길이를 정해서 생성해야 함
            가변 길이 배열은 배열의 크기를 변경할 때마다 새로운 배열을 생성해야 함
            데이터 삭제 시, 인덱스를 유지하기 위해 빈 공간 유지
 */
public class Practice_0415 {
    public static void main(String[] args) {
        
        // 1차원 배열
        System.out.println("== 1차원 배열 ==");
        int[] arr = {1,2,3,4,5};
        for (int i : arr) {
            System.out.println("i = " + i);
        }

        // 데이터 수정
        arr[1] = 100;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        System.out.println("== 2차원 배열 ==");
        int[][] arr2 = {{1,2,3},{4,5,6}};
        System.out.println(arr2[0][1]);

        // 처음 까는 arr2의 첫 번째 배열
        for (int[] i : arr2) {
            for (int j : i) {
                System.out.println("j = " + j);
            }
        }

        System.out.println("== ArrayList ==");
        // Arrays.asList : 배열을 리스트로 변환하는 메서드
        ArrayList list1 = new ArrayList(Arrays.asList(1,2,3));
        System.out.println("list1 = " + list1);
        list1.add(4);
        list1.add(5);
        System.out.println("list1 = " + list1);
        list1.remove(2); // index 입력
        System.out.println("list1 = " + list1);
        list1.remove(Integer.valueOf(4)); // 값을 지우는 방법
        System.out.println("list1 = " + list1);

        ArrayList list2d = new ArrayList<>();
        ArrayList list1d1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList list1d2 = new ArrayList<>(Arrays.asList(4,5,6));
        list2d.add(list1d1);
        list2d.add(list1d2);
        System.out.println("list1d1 = " + list1d1);
        System.out.println("list1d2 = " + list1d2);
        System.out.println("list2d = " + list2d);
    }
}
