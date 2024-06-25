package Zero.Part02.Chapter03;
/*
    최소 힙에서 특정 값을 변경하는 코드를 작성
    특정 값이 여러 개라면 모두 바꾸기
 */

import java.util.ArrayList;

class MinHeap3 {
    ArrayList<Integer> heap;

    public MinHeap3() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parent = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur));
            heap.set(cur, parent);

            cur /= 2;
        }
    }

    public  Integer delete() {
        if(heap.size() == 1) {
            System.out.println("Heap is Empty!");
            return null;
        }

        int target = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if(right < heap.size() - 1) {
                targetIdx = heap.get(left) < heap.get(right) ? left : right;
            } else if (left < heap.size() - 1) {
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
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}
public class Practice_Heap5 {
    public static void solution(MinHeap3 minHeap, int from, int to) {
        for (int i = 0; i < minHeap.heap.size(); i++) {
            if(minHeap.heap.get(i) == from) {
                minHeap.heap.set(i, to);

                // 변경이 일어났을 경우 값을 올리거나 내리는 작업
                moveDown(minHeap, i);
                moveUp(minHeap, i);
            }
        }
    }

    public static void moveUp(MinHeap3 minHeap, int idx) {
        // idx 변경된 값의 인덱스
        int cur = idx;

        while(cur > 1 && minHeap.heap.get(cur / 2) > minHeap.heap.get(cur)) {
            int parentVal = minHeap.heap.get(cur / 2);
            minHeap.heap.set(cur / 2, minHeap.heap.get(cur));
            minHeap.heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public static void moveDown(MinHeap3 minHeap, int idx) {
        int cur = idx;

        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if(right < minHeap.heap.size()) {
                targetIdx = minHeap.heap.get(left) < minHeap.heap.get(right) ? left : right;
            } else if (left < minHeap.heap.size()) {
                targetIdx = left;
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
        MinHeap3 minHeap = new MinHeap3();
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

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap,60,1);
        minHeap.printTree();

    }
}
