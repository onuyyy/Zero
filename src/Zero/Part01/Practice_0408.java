package Zero.Part01;

import java.io.IOException;

// 사용자 예외 만들기
class NotTenException extends RuntimeException {
    // RuntimeException 상속 받기
}

public class Practice_0408 {

    public static boolean checkTen(int ten) {
        if(ten != 10) return false;
        return true;
    }
    public static boolean checkTenWithException(int ten) {
        try {
            if(ten != 10) {
                throw new NotTenException();
            }
        } catch (NotTenException e) {
            System.out.println("e = " + e);
            return false;
        }
        return true;
    }

    public static boolean checkTenWithThrows(int ten) throws NotTenException {
        // 예외가 발생하면 여기서 처리할 게 아니라 밖으로 내보낸다 throws
        if(ten != 10) {
            throw new NotTenException();
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        /*
            예외 : 정상적이지 않은 Case
                - 0으로 나누기
                - 배열의 인덱스 초과
                - 없는 파일 열기
            예외 처리 : 정상적이지 않은 case에 대한 적절한 처리 방법
            try ~ catch

            finally : 예외 발생 여부와 관계없이 항상 실행
            throw : 예외를 발생 시킴
            throws : 예외를 전가 시킴
         */

        System.out.println("예외 : 0으로 나누기");
        try {
            int a = 5/0;
        } catch(Exception e) {
            System.out.println("0으로 나누기 예외 발생");
            System.out.println("e = " + e);
        } finally {
            System.out.println("1 연습 종료");
        }

        System.out.println("예외 : 배열 인덱스 초과");
        try {
            int[] b = new int[4];
            b[4]= 1;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("e = " + e);
        }

        System.out.println("throw, throws");
        boolean checkResult = Practice_0408.checkTen(10);
        System.out.println("checkResult = " + checkResult);

        System.out.println("== checkTenWithException ==");
        // checkResult = Practice_0408.checkTenWithException(10);
        checkResult = Practice_0408.checkTenWithException(11);
        System.out.println("checkResult = " + checkResult);

        System.out.println("== checkTenWithThrows ==");
        try {
            checkResult = checkTenWithThrows(5);
        } catch (NotTenException e) {
            System.out.println("e = " + e);
        }
        System.out.println("checkResult = " + checkResult);

    }
}
