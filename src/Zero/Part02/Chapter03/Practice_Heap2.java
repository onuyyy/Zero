package Zero.Part02.Chapter03;

import java.util.ArrayList;
import java.util.logging.Handler;

// 최소 힙에서 특정 값을 변경하는 코드 작성
// 특정 값이 여러 개라면 모두 바꾸기

public class Practice_Heap2 {
    public static void solution(MinHeap2 minHeap, int from, int to) {
        for (int i = 0; i < minHeap.heap.size(); i++) {
            if(minHeap.heap.get(i) == from) {
                minHeap.heap.set(i, to);

                moveUp(minHeap, i);
                moveDown(minHeap, i);
            }
        }
    }

    public static void moveUp(MinHeap2 minHeap, int idx) {
        int cur = idx;

        while (cur > 1 && minHeap.heap.get(cur / 2) > minHeap.heap.get(cur)) {
            int parent = minHeap.heap.get(cur / 2);
            minHeap.heap.set(cur / 2, minHeap.heap.get(cur));
            minHeap.heap.set(cur, parent);

            cur /= 2;
        }
    }

    public static void moveDown(MinHeap2 minHeap, int idx) {
        int cur = idx;

        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < minHeap.heap.size()) {
                targetIdx = minHeap.heap.get(leftIdx) < minHeap.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < minHeap.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if(minHeap.heap.get(cur) < minHeap.heap.get(targetIdx)) {
                break;
            } else {
                int parent = minHeap.heap.get(cur);
                minHeap.heap.set(cur, minHeap.heap.get(targetIdx));
                minHeap.heap.set(targetIdx, parent);

                cur = targetIdx;
            }
        }
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
        System.out.println("데이터 변경 전");
        heap.printHeap();

        System.out.println("데이터 변경 후");
        solution(heap, 30, 100);
        heap.printHeap();

        solution(heap, 60, 1);
        heap.printHeap();
    }
}
