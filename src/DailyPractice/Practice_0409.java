package DailyPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice_0409 {
    public static void main(String[] args) {
        /*
            스트림
                배열, 컬렉션 등의 데이터를 하나씩 참조하여 처리 가능한 기능
                for문의 사용을 줄여 코드를 간결하게 함
                스트림은 크게 생성, 중개 연산, 최종 연산으로 구성

                데이터소스객체.Stream생성().중개연산().최종연산();
         */

        System.out.println("== for i ==");
        String[] arr = new String[]{"a","b","c"};
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("== forEach ==");
        for(String a : arr) {
            System.out.println(a);
        }

        System.out.println("== to Stream ==");
        Stream s1 = Arrays.stream(arr);
        s1.forEach(System.out::println);

        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1,2,3));
        // 주어진 배열이나 복수의 요소를 포함하는 고정 크기의 리스트 반환하는 메서드
        System.out.println("list1 = " + list1);
        Stream s2 = list1.stream();
        // s2.forEach(System.out::println);
        s2.forEach(x -> System.out.println(x));
        // stream은 일회용이기 때문에 연산을 한 번 수행하고 나면
        // 그 스트림은 더 이상 사용할 수 없다 (IllegalStateException 발생)

        System.out.println("== Stream Builder ==");
        Stream sb1 = Stream.builder().add(1).add(2).add(3).build();
        // build 메서드를 호출하면 스트림이 구성된다 이 순간 빌더는 해당 스트림을
        // 생성하기 위해 자신이 보유한 모든 요소를 스트림으로 변환하여 포함한다
        // build 호출된 후에는 더 이상 빌더에 요소를 추가할 수 없다
        sb1.forEach(System.out::println);

        System.out.println("== Stream Generate ==");
        Stream sg = Stream.generate( () -> "abc").limit(3);
        sg.forEach(System.out::println);

        System.out.println("== Stream Iterate ==");
        Stream st = Stream.iterate(10,n -> n*2).limit(5);
        // 초기값 10, 10 *2 = 20 .. , 5번 반복
        st.forEach(System.out::println);

        System.out.println("== 기본 타입 Stream ==");
        IntStream is = IntStream.range(1,5);
        // 1~4까지의 데이터를 만들기
        is.forEach(System.out::println);

        System.out.println("== Stream 중개 연산 ==");
        System.out.println("== Filtering ==");
        // Filtering 조건에 맞는 데이터를 추출하는 것
        IntStream is2 = IntStream.range(1,10).filter(n -> n%2 ==0);
        is2.forEach(System.out::println);

        System.out.println("== Mapping ==");
        // Mapprin은 각각의 원소대로 연산해서 다시 만들어주는 것
        IntStream is3 = IntStream.range(1,10).map(n -> n+1);
        is3.forEach(n -> System.out.print(n + " "));

        System.out.println("== Sorting ==");
        IntStream is4 = IntStream.builder().add(5).add(1).add(3).add(4).build();
        // 스트림은 한 번의 연산에 사용되고 나면 더 사용할 수 없기 때문에
        // 한 번 더 만듦
        IntStream isSort = is4.sorted();
        isSort.forEach(System.out::println);

        System.out.println("== 최종 연산 ==");
        System.out.println("== Sum, Average ==");
        int sum = IntStream.range(1,5).sum();
        System.out.println("sum = " + sum);
        double average = IntStream.range(1,5).average().getAsDouble();
        System.out.println("average = " + average);

        System.out.println("== Min, Max ==");
        // int min = IntStream.range(1,10).min();
        // min()이 int 타입의 값을 반환하지 않고 OptionalInt를 반환하기 때문에
        // OptionalInt는 0~1개의 int 값을 포함할 수 있는 컨테이너 객체로
        int min = IntStream.range(1,10).min().getAsInt();
        System.out.println("min = " + min);
        int max = IntStream.range(1,10).max().getAsInt();
        System.out.println("max = " + max);

        System.out.println("== reduce ==");
        Stream<Integer> str1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)).stream();
        System.out.println(str1.reduce((x,y) -> x+y).get());
        // 1+2 = 3 / 3+3 = 6 / 6+4 = 10 / 10+5 =15
        // 연쇄적으로 합을 해서 데이터를 뽑아낸다

        System.out.println("== forEach ==");
        IntStream.range(1,10).filter(n -> n%3 == 0).forEach(System.out::println);
    }
}
