package Zero;


import java.util.Arrays;

public class DailyPractice {
    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
            // Integer 최대값
            // int 추가해서 더 많은 기능이 있음 Integer
        System.out.println(Integer.MIN_VALUE);
            // Integer 최소값

        int num1 = Integer.MAX_VALUE + 1;
        // 1을 더해준 수는 Max 데이터를 넘어가서 잘못된 데이터가 들어감
        long num2 = (long)Integer.MAX_VALUE + 1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        float f1 = (float) Double.MAX_VALUE;
        double d1 = Float.MAX_VALUE;

        System.out.println("f1 = " + f1);
        System.out.println("d1 = " + d1);

        String s1 = "Hello";
        String s2 = "World";
        String s3 = "World";
        // 문자열은 기존에 똑같은 데이터가 있으면
        // 기존 데이터를 같이 바라본다

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        String s5 = new String("World");
        // new String = 새로 객체를 만든다

        System.out.println("== 객체 비교 ==");
        System.out.println(s2.equals(s5)); // true
        System.out.println(s2==s5); // false
        // 다른 객체이기 때문에 false가 나온다
        // 값을 비교하고 싶으면 equals 사용하면 된다

        // equals : 값을 비교
        // new String :

        // StringBuffer 문자열을 추가,변경할 때 사용하는 자료형
        StringBuffer sb = new StringBuffer();

        sb.append(s1);
        sb.append(s2);
        System.out.println(sb);


        System.out.println("== indexOf ==");
        String s6 = "Hello! World!";
        System.out.println(s6.indexOf("!"));
        // 두 번째 ! 찾으려면
        System.out.println(s6.indexOf("!",s6.indexOf("!")+1));

        String s7 = s6.replace("Hello","Hi");

        System.out.println("s7 = " + s7);

        // 부분 문자열 뽑기
        // 0~3의 문자열 찾기
        System.out.println(s7.substring(0,3));
        System.out.println(s7.substring(0,s7.indexOf("!")+1));

        System.out.println("== 배열 ==");
        int[] array = {1,2,3,4,5};
        System.out.println(array[0]);

        String[] array2 = new String[3];
        array2[0] = "Hello";
        array2[1] = "World~";

        System.out.println(Arrays.toString(array2));

    }
}
