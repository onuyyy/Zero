package DailyPractice;

public class Practice_0410 {
    public static void solution(int n, int type) {
        if(type == 1) type1(n);
        if(type == 2) type2(n);
        if(type == 3) type3(n);
        if(type == 4) type4(n);
        if(type == 5) type5(n);
    }

    public static void type1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void type2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void type3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void type4(int n) {
        // 피라미드 별 모양 1 -3 -5  => i*2+1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void type5(int n) {
        // 상단부
        for (int i = 0; i <= n/2; i++) {
            for (int j = 0; j < n/2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 하단부
        for (int i = n / 2; i > 0; i--) {
            for (int j = 0; j < n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void test1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - 1 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void heartSJ(boolean[][] heart) {
        for (int row = 0; row < heart.length; row++) {
            for (int col = 0; col < heart[row].length; col++) {
                if (heart[row][col]) {
                    System.out.print("♡ ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
/*        type1(3);
        type2(3);
        type3(3);
        type4(3);
        type5(5);*/

        //test1(5);

        boolean[][] heart = {
                {false, true, true, false, true, true, false},
                {true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true},
                {false, true, true, true, true, true, false},
                {false, false, true, true, true, false, false},
                {false, false, false, true, false, false, false}
        };

        heartSJ(heart);
    }
}
