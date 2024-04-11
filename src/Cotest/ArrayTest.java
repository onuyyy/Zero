package Cotest;
// 기본 배열 자료형 이용하여 생성, 삽입, 삭제 기능

import java.util.Arrays;

class MyArray {
    int[] arr;
    MyArray(int size) {
        this.arr = new int[size];
    }
    // 배열에 데이터 삽입
    public void insertData(int index, int data) {
        if(index < 0 || index > this.arr.length) {
            System.out.println("index error");
            return;
        }

        // 기존 데이터에 복사해두기
        int[] arrDup = this.arr.clone();
        // 삽입될 거기 때문에 기존 배열보다 1개 더 큰 배열 만들기
        this.arr = new int[this.arr.length + 1];

        // 데이터 추가하려는 위치까지는 기존 데이터 할당하기
        for(int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        // 데이터 추가하려는 위치 그 다음부터 기존 배열을 가지고 할당
        for(int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }
        
        // 해당 위치에 데이터 삽입
        this.arr[index] = data;
    }

    // 배열에서 특정 데이터 삭제
    public void removeData(int data) {
        // 기존 배열보다 1 작은 배열 만들기
        int targetIndex = -1;

        // 해당 데이터가 기존 배열에 있는지 찾기
        for(int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == data) {
                // 맞는 데이터가 있으면 변수에 넣고 빠져나가기
                targetIndex = i;
                break;
            }
        }

        // 찾은 데이터가 없다면
        if(targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
            // 찾은 데이터 있으면 삭제
            // 기존 데이터 백업
            int[] arrDup = this.arr.clone();
            // 배열을 사이즈 1 줄여서 만들기
            this.arr = new int[this.arr.length - 1];

            // 지우려 하는 인덱스 전까지 기존 배열 넣기
            for(int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];;
            }

            // 지우려하는 데이터 빼고 나머지 데이터를 넣기
            for(int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }
}
public class ArrayTest {
    public static void main(String[] args) {
        int size = 5;
        MyArray ma = new MyArray(size);
        // 데이터 넣기
        for(int i = 0; i < size; i++) {
            ma.arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(ma.arr));

        ma.arr[0] = 10;
        System.out.println(Arrays.toString(ma.arr));

        ma.insertData(2,20);
        System.out.println(Arrays.toString(ma.arr));

        ma.removeData((4));
        System.out.println(Arrays.toString(ma.arr));

        ma.removeData(99);
        System.out.println(Arrays.toString(ma.arr));
    }
}
