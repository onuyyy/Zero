package Zero.Part02;

import java.util.Arrays;

class MyArray {
    int[] arr;

    // 배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    // 배열에 데이터 삽입
    public void insertData(int idx, int data) {
        // 예외 처리, 인덱스에 벗어난 데이터의 삽입 시
        if(idx < 0 || this.arr.length < idx) {
            System.out.println("Index Error");
            return;
        }

        // 데이터 이동 후 삽입
        // 기존 배열 복사
        int[] arrDup = this.arr.clone();
        // 기존보다 하나 더 큰 배열 생성
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < idx; i++) {
            // 해당 인덱스까지 기존 데이터 할당
            this.arr[i] = arrDup[i];
        }

        for (int i = idx; i < this.arr.length; i++) {
            // 해당 인덱스부터 기존 데이터 할당
            this.arr[i] = arrDup[i - 1];
        }

        // 해당 인덱스에 데이터 삽입
        this.arr[idx] = data;

    }

    // 배열에서 특정 데이터 찾아서 삭제
    public void removeData(int data) {
        int targetIndex = -1;

        for (int i = 0; i < this.arr.length; i++) {
            // 데이터가 존재하는지 찾기
            if(this.arr[i] == data) {
                // 찾은 위치에 해당하는 인덱스를 넣어주기
                targetIndex = i;
                break;
            }
        }

        // 찾은 데이터가 없을 때
        if(targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
            // 있을 때 삭제 시작
            // 기존 데이터 백업
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIndex; i++) {
                // 지울 인덱스 위치 전까지 데이터 넣기
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIndex; i < this.arr.length; i++) {
                // 지울 인덱스 위치 다음부터 원래 데이터 넣기
                this.arr[i] = arrDup[i+1];
            }
        }
    }
}
public class Practice_0415T {
    public static void main(String[] args) {
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(2,20);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(6,60);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(-1,0); // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(99); // 해당 데이터 없습니다
    }
}
