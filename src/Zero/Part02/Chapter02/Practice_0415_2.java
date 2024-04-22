package Zero.Part02.Chapter02;
/*
    배열 arr의 데이터 중 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력
 */
public class Practice_0415_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        float sumEven = 0; // 짝수 평균
        float sumOdd = 0; // 홀수 평균
        int evenCnt = 0;
        int oddCnt = 0;

        for(int i : arr) {
            if(i%2 == 0) {
                sumEven += i;
                evenCnt++;
            } else {
                sumOdd += i;
                oddCnt++;
            }
        }
        System.out.println("짝수 평균 : " + sumEven / evenCnt);
        System.out.println("홀수 평균 : " + sumOdd / oddCnt);
    }
}
