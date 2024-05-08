package Zero.Part02.Chapter02;

import java.util.Hashtable;
import java.util.Map;

class MyHashTable {
    // 배열을 이용하여 해시테이블 구현
    Integer[] table;
    // 해시테이블 안에 실질적인 데이터 몇 개인지 체크하기 위한 변수
    int elemCnt;

    MyHashTable() {}
    MyHashTable(int size) {
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elemCnt++;
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key) {
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + " : " + this.table[i]);
        }
    }
}

class MyHashTable2 extends MyHashTable {
    // 해시 충돌 해결
    // 개발 주소법 - 선형 탐사법
    MyHashTable2(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash Table is Full!");
            return;
        } else if (this.table[idx] == null) {
            // 해시테이블에 공간이 있을 때
            this.table[idx] = data;
        } else {
            // 해시테이블 내 공간은 있는데 데이터가 이미 들어가 있을 때[충돌]
            int newIdx = idx;
            while (true) {
                // 해시테이블 위치의 다음 위치(+1)가 null인지 확인
                newIdx = (newIdx + 1) % this.table.length;
                if(this.table[newIdx] == null) {
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt++;
    }
}
public class Practice_0423_해시테이블 {

    public static int getHash(int key) {
        // 해시테이블의 사이즈 5
        return key % 5;
    }

    public static void main(String[] args) {

        // Java 제공 해시 테이블
        Hashtable<String, Integer> ht = new Hashtable<>();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);

        // 충돌 만들기
        ht.put("key3", 50); // 데이터 바뀜

        for (Map.Entry<String, Integer> item : ht.entrySet()) {
            // entrySet 테이블 안에 있는 key값 대응하는 값을 뽑아줌
            // Map.Entry > 해시테이블은 Map 인터페이스를 사용했기 때문에
            System.out.println(item.getKey() + " " + item.getValue());
        }

        // 해시 충돌 케이스 (해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable<>();
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("== 충돌 전 ==");
        for (Map.Entry<Integer, Integer> item : ht2.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }

        System.out.println("== 충돌 후 ==");
        ht2.put(getHash(6), 60);
        for (Map.Entry<Integer, Integer> item : ht2.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }


        System.out.println("== Hash Tale 배열을 이용하여 구현 ==");
        MyHashTable h = new MyHashTable(7);
        h.setValue(1, 10);
        h.setValue(2, 20);
        h.setValue(3, 30);
        h.setValue(4, 40);
        h.setValue(5, 50);
        h.printHashTable();
        h.setValue(8,60);
        h.printHashTable();

        System.out.println("== 선형 탐색법 ==");
        MyHashTable2 h2 = new MyHashTable2(5);
        h2.setValue(1, 1);
        h2.setValue(2, 2);
        h2.printHashTable();

        h2.setValue(1, 10);
        h2.printHashTable();

        h2.setValue(1, 20);
        h2.setValue(1, 30);
        h2.setValue(1, 40);
        h2.printHashTable();
    }
}
