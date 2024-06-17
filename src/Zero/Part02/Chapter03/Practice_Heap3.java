package Zero.Part02.Chapter03;
// 최소 힙, 최대 힙을 이용하여 데이터를 오름차순, 내림차순으로 출력

import java.util.ArrayList;

class MaxHeap3 {
    ArrayList<Integer> heap;

    MaxHeap3() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
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
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = leftIdx;
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

    public void printHeap() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}
public class Practice_Heap3 {
    public static void solution(MinHeap2 minHeap2) {
        MaxHeap3 maxHeap = new MaxHeap3();

        System.out.print("오름차순 출력 : ");
        while (minHeap2.heap.size() != 1) {
            int data = minHeap2.delete();
            System.out.print(data + " ");

            maxHeap.insert(data);
        }
        System.out.println();

        System.out.print("내림차순 출력 : ");
        while (maxHeap.heap.size() != 1) {
            System.out.print(maxHeap.delete() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MinHeap2 heap = new MinHeap2();
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(50);
        heap.insert(60);
        heap.insert(70);
        heap.insert(20);
        heap.insert(30);

        solution(heap);
    }
}
