package Zero.Part02.Chapter03;

import java.util.ArrayList;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        // 더미 데이터 넣어서 1번부터 시작할 수 있도록 편리하게
        this.heap.add(0);
    }
    public void insert(int data) {
        // 끝 쪽에 데이터 넣기
        heap.add(data);
        // 부모 키랑 비교하여 자기 자신을 위로 올리기
        // 방금 넣은 데이터의 인덱스 위치 cur
        int cur = heap.size() - 1;
        // cur / 2 = 위치는 부모쪽 인덱스 값 > 지금 들어온 데이터 값보다 크면
        // cur의 값을 올려준다
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            // 위로 다시 올라가서 체크
            cur /= 2;
        }
    }
    public Integer delete() {
        if(this.heap.size() == 1) {
            System.out.println("Heap is empty!");
            return  null;
        }
        int target = this.heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // 가장 위로 올린 데이터가 최소 힙인지 비교한다
        int cur = 1;
        while (true) {

            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()) {
                // right가 heap 사이즈보다 크면 오른쪽 자식 노드가 없는 것
                // 자식 노드가 둘 다 있는 경우
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                // 자식 노드가 하나인 경우
                targetIdx = cur * 2;
            } else {
                // 자식 노드가 없는 상황
                break;
            }
            if (heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parentVal  = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);

                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }

}
class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        // 더미 데이터 넣어서 1번부터 시작할 수 있도록 편리하게
        this.heap.add(0);
    }
    public void insert(int data) {
        // 끝 쪽에 데이터 넣기
        heap.add(data);
        // 부모 키랑 비교하여 자기 자신을 위로 올리기
        // 방금 넣은 데이터의 인덱스 위치 cur
        int cur = heap.size() - 1;
        // cur / 2 = 위치는 부모쪽 인덱스 값 > 지금 들어온 데이터 값보다 크면
        // cur의 값을 올려준다
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            // 위로 다시 올라가서 체크
            cur /= 2;
        }
    }
    public Integer delete() {
        if(this.heap.size() == 1) {
            System.out.println("Heap is empty!");
            return  null;
        }
        int target = this.heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // 가장 위로 올린 데이터가 최소 힙인지 비교한다
        int cur = 1;
        while (true) {

            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()) {
                // right가 heap 사이즈보다 크면 오른쪽 자식 노드가 없는 것
                // 자식 노드가 둘 다 있는 경우
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                // 자식 노드가 하나인 경우
                targetIdx = cur * 2;
            } else {
                // 자식 노드가 없는 상황
                break;
            }
            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal  = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);

                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Pracitce_Heap {
    public static void main(String[] args) {
        MinHeap min = new MinHeap();
        System.out.println("MinHeap 데이터 삽입");
        min.insert(30);
        min.insert(40);
        min.insert(10);
        min.printTree();
        min.insert(50);
        min.insert(60);
        min.insert(70);
        min.printTree();
        min.insert(20);
        min.printTree();
        min.insert(30);
        min.printTree();

        System.out.println();
        System.out.println("MinHeap 데이터 삭제");
        System.out.println("삭제 : " + min.delete());
        min.printTree();
        System.out.println("삭제 : " + min.delete());
        min.printTree();
        System.out.println("삭제 : " + min.delete());
        min.printTree();
        System.out.println();

        MaxHeap max = new MaxHeap();
        System.out.println("MaxHeap 데이터 삽입");
        max.insert(30);
        max.insert(40);
        max.insert(10);
        max.printTree();
        max.insert(50);
        max.insert(60);
        max.insert(70);
        max.printTree();
        max.insert(20);
        max.printTree();
        max.insert(30);
        max.printTree();

        System.out.println();
        System.out.println("MaxHeap 데이터 삭제");
        System.out.println("삭제 : " + max.delete());
        max.printTree();
        System.out.println("삭제 : " + max.delete());
        max.printTree();
        System.out.println("삭제 : " + max.delete());
        max.printTree();
    }
}

