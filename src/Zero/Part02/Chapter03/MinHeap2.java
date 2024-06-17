package Zero.Part02.Chapter03;

import java.util.ArrayList;

public class MinHeap2 {
    static ArrayList<Integer> heap;

    MinHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }
    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if(heap.size() == 1) {
            System.out.println("Heap is Empty!");
            return null;
        }

        int target = heap.get(1);
        heap.set(1,heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()) {
                // 자식 노드 둘 다 있음
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                // 왼쪽 자식만 있음
                targetIdx = leftIdx;
            } else {
                break;
            }

            // 자식 노드 중 더 작은 값을 구한 targetIdx와 cur 비교
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

    public void printHeap() {
        for(int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
