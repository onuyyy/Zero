package Zero.Part02.Chapter03;
/*
    정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대 값이 큰 값부터 출력

    입력 : 3 0 -2 -5 9 6 -11 20 -30
    삭제 횟수 : 1
    출력 : 20 -11 9 6 -5 3 -2 0
 */

import java.util.ArrayList;
import java.util.stream.IntStream;

class Num {
    int val;
    boolean isMinus;

    public Num(int val) {
        this.isMinus = val < 0 ? true : false;
        this.val = Math.abs(val);
    }
}

class MaxHeap2 {
    ArrayList<Num> heap;

    public MaxHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(new Num(0));
    }

    public void insert(int data) {
        heap.add(new Num(data));

        int cur = heap.size() - 1;
        while(cur > 1 && heap.get(cur / 2).val < heap.get(cur).val) {
            Num parent = heap.get(cur / 2);
            heap.set(cur / 2, heap.get(cur));
            heap.set(cur, parent);

            cur /= 2;
        }
    }

    public Num delete() {
        if(heap.size() == 1) {
            System.out.println("Heap is Empty!");
            return null;
        }

        Num target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if(right < heap.size()) {
                targetIdx = heap.get(left).val < heap.get(right).val ? right : left;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if(heap.get(cur).val > heap.get(targetIdx).val) {
                break;
            } else {
                Num parent = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parent);
                cur = targetIdx;
            }
        }
        return target;
    }
}
public class Practice_Heap4 {
    public static void solution(int[] nums, int deleteCnt) {
        MaxHeap2 maxHeap = new MaxHeap2();
        IntStream.of(nums).forEach(x -> maxHeap.insert(x));

        int cnt = 0;
        while (maxHeap.heap.size() != 1) {
            Num cur = maxHeap.delete();

            // deleteCnt가 1이면 첫번째 루프일 때 cnt가 0이고,
            // 0이면 출력하지 않고 continue가 되며
            // maxHeap의 큰 값은 넘어가며 deleteCnt 다음부터 출력된다
            if(cnt++ < deleteCnt) {
                continue;
            }

            // 음수 양수인지 구분하여 출력
            int oriVal = cur.isMinus ? cur.val * -1 : cur.val;
            System.out.print(oriVal + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {3, 0 , -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution(nums, deleteCnt);
    }
}
