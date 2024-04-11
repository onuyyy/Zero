package DailyPractice;

public class Practice_0403 {
    public static void main(String[] args) {
        System.out.println("== 조건문 : if ==");
        int num1 = 99;
        if(num1 >= 100){
            System.out.println("100 안 넘어");
        } else {
            System.out.println("100 넘어");
        }

        int score = 90;
        char grade = 0;

        if(score >= 90) {
            grade = 'A';
        } else if(score >= 80) {
            grade = 'B';
        } else if(score >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        System.out.println("grade = " + grade);

        System.out.println("== 조건문 : Switch ==");
        // 입력 값에 따라 어떤 case를 실행할지 판단
        // default : case에 해당하지 않을 때 기본으로 적용할 것
        String fruit = "banana";
        switch (fruit) {
            case "apple" :
                System.out.println(fruit + "3,000원 입니다");
                break;
            case "banana" :
                System.out.println(fruit + "5,000원 입니다");
            default:
                System.out.println("없는 과일입니다");
        }

        // 홀짝 구분
        System.out.println("숫자 홀짝 구분하기");
        int number = 5;
        if(number % 2 == 0) {
            System.out.println("짝수입니다");
        } else {
            System.out.println("홀수 입니다");
        }

        System.out.println("score 구문 switch로 바꾸기");
        score = 85;
        grade = 0;
        switch (score/10) {
            case 10:
                // 어차피 나눠도 10이고 break도 없으니 case 9에 맞는
                // A 학점이 나옴
            case 9 :
                System.out.println(score + "점은 A 학점입니다");
                break;
            case 8 :
                System.out.println(score + "점은 B 학점입니다");
                break;
            case 7 :
                System.out.println(score + "점은 C 학점입니다");
                break;
            default:
                System.out.println("공부 좀 해라");
        }


        System.out.println();
        System.out.println("== 반복문 : for ==");
        // 주어진 횟수만큼 반복하여 실행하는 구조
        // for(초기치; 조건문; 증가치)
        for(int i = 0; i < 5; i++) {
            System.out.print(i +"\t");
        }

        System.out.println();
        // 별 찍기
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("== continue ==");
        for(int i = 0; i < 5; i++) {
            if(i == 2) {
                continue;
                // i 가 2일 때는 아래 구문 실행 안 함
            }
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("== break; ==");
        for(int i = 0; i < 5; i++) {
            if(i == 2) {
                continue;
                // i 가 2일 때는 반복문 탈출
            }
            for(int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("== for each ==");
        int[] nums = {1,2,3,4,5};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
        System.out.println();

        for(int n : nums) {
            System.out.print(n + "\t");
        }


        System.out.println();
        System.out.println("== while ==");
        // 조건문이 만족하는 동안 반복 실행
        int i = 0;
        while(i < 5) {
            System.out.print(i + "\t");
            i++;
        }

        System.out.println();
        System.out.println("== continue ==");
        i = 0;
        while(i < 5) {
            if(i == 2) {
                i++;
                continue;
            }
            System.out.print(i++ +"\t");
        }

        System.out.println();
        System.out.println("== break ==");
        i = 0;
        while(i < 5) {
            if(i == 2) {
                i++;
                continue;
            }
            System.out.print(i++ +"\t");
        }


        System.out.println();
        System.out.println("== do ~ while ==");
        // 일단 무조건 한 번 실행한다
        boolean knock = false;
        do {
            System.out.println("knock");
        } while(knock);


        System.out.println("== 연습 문제 ==");
        for(int a = 0; a < 7; a+=2) {
            for(int j = 0; j < a+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int b = 0; b < 8; b++) {
            if(b%2 == 0) {
                continue;
            }
            for(int c = 0; c < b; c++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("== 연습 문제2 ==");
        int temp = 0;
        while(temp < 100) {
            temp++;
            if(temp % 10 == 0) {
                System.out.println(temp + "도 입니다");
            }
        }
    }
}
