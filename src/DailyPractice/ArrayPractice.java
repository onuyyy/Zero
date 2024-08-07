package DailyPractice;
/*
    arr 모든 데이터에 대해서
    짝수 데이터들의 평균과 홀수 데이터들의 평균
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        float sumEven = 0;
        float sumOdd = 0;
        int evenCnt = 0;
        int oddCnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((i % 2) == 0) {
                evenCnt++;
                sumEven += arr[i];
            } else {
                oddCnt++;
                sumOdd += arr[i];
            }
        }

        float resultEven = sumEven / evenCnt;
        float resultOdd = sumOdd / evenCnt;

        System.out.println("resultOdd = " + resultOdd);
        System.out.println("resultEven = " + resultEven);

        //
        arr = new int[]{1,1,100,1,1,1,100};
        int target = 100;

        int maxIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                if(i > maxIdx) {
                    maxIdx = i;
                }
            }
        }
        if(maxIdx >= 0) {
            // 찾고자 하는 target이 배열에 없었으면 그대로 -1이니까 출력 안 됨
            System.out.println(maxIdx);
        }

        //
        arr = new int[]{1,3,5,7,9};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        //
        arr = new int[]{3,1,2,6,2,2,5,1,9,10,1,11};
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] > arr[i + 1]) {
                System.out.print(arr[i] + " ");
            } else if (i == arr.length - 1 && arr[i] > arr[i - 1]) {
                System.out.print(arr[i] + " ");
            } else {
                if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
        System.out.println();

        arr = new int[]{5,3,1,4,6,1};
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while (visitCnt < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < minVal && visited[i] == 0) {
                    minVal = arr[i];
                    minIdx = i;
                }
            }

            if (minIdx != -1) {
                System.out.print(minVal + " ");
                visited[minIdx] = 1;
                visitCnt++;
            }

            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
    }
}
