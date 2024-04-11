package DailyPractice;

import java.util.*;

public class Practice_0408_2 {
    public static void main(String[] args) {
        /*
            컬렉션 프레임워크
                여러 데이터를 편리하게 관리할 수 있게 만들어 놓은 것
                자료 구조 및 알고리즘을 구조화
                List, Set, Map 인터페이스 등
         */
        System.out.println("== ArrayList ==");
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println("list1 = " + list1);
        list1.remove(Integer.valueOf(2));
        // 인덱스 말고 숫자 값을 지울 때는 Integer.valueOf
        System.out.println("list1 = " + list1);
        list1.add(0,10);
        System.out.println("list1 = " + list1);
        list1.add(5);
        list1.remove(2);
        System.out.println("list1 = " + list1);
        System.out.println(list1.size() + " : list.size");
        System.out.println(list1.contains(10) + " : list.contains 10");
        System.out.println(list1.indexOf(10) + " : list.indexOf 10");

        System.out.println("== LinkedList ==");
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println("list2 = " + list2);
        list2.addFirst(10);
        list2.addLast(20);
        System.out.println("list2 = " + list2);
        list2.remove(Integer.valueOf(10));
        System.out.println("list2 = " + list2);
        list2.removeFirst();
        list2.removeLast();
        System.out.println("list2 = " + list2);
        System.out.println(list2.size() + " : list.size");

        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("set1 = " + set1);
        set1.remove(2);
        // 인덱스가 아닌 값으로 인식을 한다
        System.out.println("set1 = " + set1);
        set1.add(3);
        System.out.println("set1 = " + set1);
        // 중복된 데이터가 들어갈 수 없다
        System.out.println(set1.size() + " : set.size");
        System.out.println(set1.contains(3) + " : set.contains");

        System.out.println("== TreeSet ==");
        TreeSet set2 = new TreeSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println("set2 = " + set2);
        set2.remove(2);
        System.out.println("set2 = " + set2);
        set2.clear();
        System.out.println("set2 = " + set2);
        set2.add(10);
        set2.add(10);
        // 중복 값 안 됨
        set2.add(20);
        set2.add(30);
        System.out.println("set2 = " + set2);
        System.out.println(set2.first());
        System.out.println(set2.last());
        System.out.println(set2.lower(20));
        // 20보다 작은 값 출력
        System.out.println(set2.higher(20));
        // 20보다 큰 값 출력

        System.out.println("== HashMap ==");
        HashMap map1 = new HashMap();
        map1.put(1,"a");
        map1.put(2,"b");
        map1.put(3,"c");
        map1.put(5,"e");
        System.out.println("map1 = " + map1);
        map1.remove(3);
        System.out.println("map1 = " + map1);
        System.out.println(map1.get(2) + " : map.get2");

        System.out.println("== TreeMap ==");
        TreeMap map2 = new TreeMap();
        map2.put(10,"a");
        map2.put(20,"b");
        map2.put(30,"c");
        System.out.println("map2 = " + map2);

        System.out.println(map2.firstEntry());
        System.out.println(map2.firstKey());
        System.out.println(map2.lastEntry());
        System.out.println(map2.lastKey());
        System.out.println(map2.lowerEntry(20));
        System.out.println(map2.higherEntry(20));


    }
}

