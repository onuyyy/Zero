package Zero.Part02.Chapter03;
/*
    최소 힙, 최대 힙을 이용하여 데이터를 오름차순, 내림차순으로 출력해보기
 */

import java.util.ArrayList;

class MaxHeap6 {
    ArrayList<Integer> heap;

    public MaxHeap6() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) > heap.get(cur / 2)) {
            int parent = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur));
            heap.set(cur, parent);

            cur /= 2;
        }
    }

    public Integer delete() {
        if(heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        int target = this.heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = 0;

            if(right < heap.size()) {
                targetIdx = heap.get(left) < heap.get(right) ? right : left;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if(heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parent = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parent);

                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}

class MinHeap6 {
    ArrayList<Integer> heap;

    public MinHeap6() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) < heap.get(cur / 2)) {
            int parent = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parent);

            cur /= 2;
        }
    }

    public Integer delete() {
        if(this.heap.size() == 1) {
            System.out.println("Heap is Empty");
            return null;
        }

        int target = this.heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = 0;

            if(right < heap.size()) {
                targetIdx = heap.get(left) < heap.get(right) ? left : right;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if(heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parent = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parent);

                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}
public class Practice_Heap6 {
    public static void solution(MinHeap6 minHeap) {
        MaxHeap6 maxHeap = new MaxHeap6();

        System.out.print("오름차순 : ");
        while (minHeap.heap.size() != 1) {
            int data = minHeap.delete();
            System.out.print(data + " ");
            maxHeap.insert(data);
        }
        System.out.println();

        System.out.print("내림차순 : ");
        while (maxHeap.heap.size() != 1) {
            System.out.print(maxHeap.delete() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MinHeap6 minHeap = new MinHeap6();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();
        System.out.println("Solution 출력");
        solution(minHeap);

/*        MaxHeap6 maxHeap = new MaxHeap6();
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.printTree();*/
    }
}
