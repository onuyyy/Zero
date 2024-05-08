package Zero.Part02.Chapter02;

import java.util.Arrays;
import java.util.Hashtable;

public class Practice_0423_해시테이블_2 {

    public static void solution(int[] arr1, int[] arr2) {
        /*
            주어진 첫 번째 배열을 이용하여 해시 테이블을 초기화 한 후,
            두 번째 배열로 해당 배열 내 데이터가 해시 테이블에 있는지 확인하는 코드

            입출력 예시
            입력 : 배열1 > 1,3,5,7,9 / 배열2 > 1,2,3,4,5
            출력 : true, false, true, false, true

         */

        Hashtable<Integer, Integer> ht = new Hashtable<>();

        // 초기화 하기
        for (int i = 0; i < arr1.length; i++) {
            ht.put(arr1[i], arr1[i]);
        }

        // 수 찾기
        for (int i = 0; i < arr2.length; i++) {
            if(ht.containsKey(arr2[i])) {
                System.out.println("True");
            } else{
                System.out.println("False");
            }
        }
        System.out.println();
    }

    public static int[] solution2(int[] numbers, int target) {
        /*
            정수형 배열 nums와 target이 주어졌을 때,
            nums에서 임의의 두 수를 더해 target을 구할 수 있는지 확인
            두 수의 합으로 target을 구할 수 있으면 해당 값의 index를 반환,
            구하지 못하면 null

            입출력 예시
            nums : 7, 11, 5, 3 / target : 10
            출력 : 0, 3

            nums : 8, 3, -2 / target : 6
            출력 : 0, 2
         */

        int[] result = new int[2];
        Hashtable<Integer, Integer> h = new Hashtable<>();

        for (int i = 0; i < numbers.length; i++) {
            if(h.containsKey(numbers[i])) {
                /*
                    10 - 7 = 3 > 3이 있어야 7+3 하여 target 값 구할 수 있으니
                    뺀 값을 키 값으로 저장한다
                    후에, 저장한 키 값이 현재 numbers에 값과 일치하면
                    출력
                 */
                result[0] = h.get(numbers[i]);
                result[1] = i;
                return  result;
            }
            h.put(target - numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("== solution1 ==");
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {1,2,3,4,5};
        solution(arr1,arr2);
        System.out.println();

        System.out.println("== solution2 ==");
        int[] nums = {7,11,5,3};
        System.out.println(Arrays.toString(solution2(nums, 10)));
        nums = new int[]{8,3,-2};
        System.out.println(Arrays.toString(solution2(nums, 6)));
        nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(solution2(nums, 12)));
    }
}
