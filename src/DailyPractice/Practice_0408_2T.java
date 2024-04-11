package DailyPractice;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Practice_0408_2T {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        for(int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            // 0 ~ 44까지의 숫자가 랜덤하게 나오는 Math.random
            set.add(num);
        }

        LinkedList list = new LinkedList(set);
        Collections.sort(list);
        System.out.println("list = " + list);
    }
}
