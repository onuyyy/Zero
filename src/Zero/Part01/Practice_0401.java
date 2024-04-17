package Zero.Part01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/*
    List : 배열과 같이 여러 데이터 담을 수 있는 자료형
        add,get,size,remove,clear,sort,contains
    Map : key, value 형태로 데이터 저장
        put,get,size,remove,containsKey
    Generics : 자료형 명시적으로 지정
                제한적일 수 있지만 안정성 높여주고 형변환 줄여줌
 */
public class Practice_0401 {
    public static void main(String[] args) {
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();
        l1.add(1);
        l1.add("hi");
        l1.add(2);
        l1.add(3);
        System.out.println("l1 = " + l1);

        l1.add(0,7);
        // index에 어느 값을 넣겠다
        System.out.println("l1 = " + l1);

        System.out.println(l1.get(0));
        System.out.println(l1.get(3));

        System.out.println(l1.size());

        System.out.println(l1.remove(0));
        System.out.println(l1);
        // 인덱스 말고 값 지우기
        System.out.println(l1.remove(Integer.valueOf(2)));
        System.out.println(l1);

        // 리스트 모든 데이터 지우기
        l1.clear();
        System.out.println("l1 = " + l1);

        ArrayList l2 = new ArrayList();
        l2.add(4);
        l2.add(2);
        l2.add(7);
        l2.add(6);
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.naturalOrder()); // 오름차순
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.reverseOrder()); // 내림차순
        System.out.println("l2 = " + l2);

        System.out.println(l2.contains(1));
        System.out.println(l2.contains(2));

        System.out.println("== Map ==");
        // 순서 없음 키 값으로 가져오기 때문에
        HashMap map = new HashMap();
        map.put("kiwi",9000);
        map.put("orange",3000);
        map.put("banana",7000);
        System.out.println("map = " + map);

        System.out.println(map.get("kiwi"));
        System.out.println(map.get("apple"));
        System.out.println(map.size());

        System.out.println(map.remove("kiwi"));
        System.out.println(map.remove("apple"));

        System.out.println(map.containsKey("kiwi"));
        System.out.println(map.containsKey("banana"));

        System.out.println("== 제네릭 ==");
        ArrayList<String> l3 = new ArrayList<>();
        l3.add("String");
        // l3.add(2); 불가

        HashMap<Integer,String> h1 = new HashMap<Integer, String>();
        h1.put(1,"string");
        // h1.put("sdf",23); 불가

    }
}
