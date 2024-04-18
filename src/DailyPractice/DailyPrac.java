package DailyPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DailyPrac {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Integer[] arr = list.stream().toArray(Integer[]::new);
        //  제네릭 클래스에서 toArray를 하려면 배열에 생성자를 넣어줘야 한다

        int[] intArray = list.stream().mapToInt(i -> i).toArray();
        // mapToInt : 스트림의 요소를 int 타입으로 매핑

        List<Integer> list1 = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());
                // boxed : int > Integer 로 바꿔줌
        List<Integer> list2 = Arrays.stream(intArray)
                .boxed()
                .toList();

        // 여러 개의 배열을 동시에 반복
        int[] array1 = {10,20,30,40};
        int[] array2 = {100,200,300,400};
        IntStream.range(0, array1.length)
                .map(i -> array1[i] + array2[i])
                .forEach(System.out::println);
    }
}
