package Zero.Part01;

public class Practice_0411 {
    public static String solution(int[] keyLog) {
        final int BACK_SPACE = 8;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        StringBuilder sb = new StringBuilder();

        int step = (int)('a' - 'A');

        int cursor = 0;
        int cmdInx = 0;
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;
        while(cmdInx != keyLog.length) {
            int cur = keyLog[cmdInx];

            if (cur == BACK_SPACE) {
                if (cursor == 0) {
                    cmdInx++;
                    continue;
                }
                sb.delete(cursor - 1, cursor);
                cursor = Math.max(0, cursor - 1);
            } else if (cur == SHIFT) {
                isShift = true;
            } else if (cur == CAPS_LOCK) {
                isCapsLock = !isCapsLock;
            } else if (cur == SPACE_BAR) {
                // 공백 문자 넣기
                inputData(sb,' ',cursor, isInsert);
            } else if (cur == KEY_LEFT) {
                cursor = Math.max(0, cursor - 1);
            } else if (cur == KEY_RIGHT) {
                cursor = Math.min(sb.length(), cursor + 1);
            } else if (cur == INSERT) {
                isInsert = !isInsert;
            } else if (cur == DELETE) {
                if (cursor == sb.length()) {
                    // 마지막 문자에는 delete 할 게 없다
                    cmdInx++;
                    continue;
                }
                sb.delete(cursor, cursor + 1);
            } else if (cur >= 97 && cur <= 122){
                int data = cur;

                if (isCapsLock && isShift) {
                    data = cur;
                } else if (isCapsLock || isShift) {
                    data -= step;
                }
                // 데이터 입력
                inputData(sb,(char)data,cursor,isInsert);
                isShift = false; // SHITF 키는 일회성
                cursor += 1;
            } else if (cur >= 48 && cur <= 57) {

                char[] specialKey = {')','!','@','#','$','%','^','&','*','('};
                // 데이터 입력

                isShift = false; // 일회성 키
                cursor += 1;
            }
            cmdInx++;
        }
        return sb.toString();
    }

    public static void inputData(StringBuilder sb, char data, int cursor, boolean isInsert) {
        // 데이터 입력 부분은 반복 코드라 따로 메서드 만듦
        if(isInsert == false) {
            sb.insert(cursor, data);
        } else {
            sb.setCharAt(cursor, data);
        }
    }
    public static void main(String[] args) {
        int[] keyLog = {16,106,101,108,111,37,37,37,37,37,155,16,104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20,104,16,105,32,20,16,106,97,118,97};
        System.out.println(solution(keyLog));

        keyLog = new int[]{49,51,8,50,51,53,55,37,37,127,127,52,53};
        System.out.println(solution(keyLog));
    }
}
