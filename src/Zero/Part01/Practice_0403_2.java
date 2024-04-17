package Zero.Part01;

public class Practice_0403_2 {
    public static void main(String[] args) {
        System.out.println("== 2차원 배열 ==");
        // int[][] array = {{1,2,3},{4,5,6}};
        // int[][] array2 = new int[2][3]; 2행 3열

        int[][] array = {{1,2,3},{4,5,6}};
        System.out.println("array = " + array[1][2]);

        // array.length : 2행 / array[i].length : 3열
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }

        // for each문은 배열을 반복하는 것이기 때문에
        // 2차원 배열을 1차원 배열에 담는다
        // 첫 번째 배열을 깐 거다
        for(int[] ints : array) {
            // 2차원 배열을 배열에 담고
            for(int ints2 : ints) {
                // 깐 배열의 내용물을 1차원 배열 ints2에 담음
                System.out.println(ints2);
            }
        }

        System.out.println("== 연습 문제 ==");
        int[][] testArray = {{0,0,0},{0,0,0},{0,0,0}};
        // 대각 원소를 10으로 바꿔라
        for(int i = 0; i < testArray.length; i++) {
            for(int j = 0; j < testArray[i].length; j++) {
                // 1로 초기화
                testArray[i][j]=1;
                if(i == j) {
                    testArray[i][j] =10;
                }
            }
        }

        for(int[] i : testArray) {
            for(int i2 : i) {
                System.out.print(i2 + "\t");
            }
            System.out.println();
        }
    }
}
