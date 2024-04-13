import java.util.ArrayList;
import java.util.HashMap;

public class Practice_0410_2 {
    public static void solution3(String input, String cmd) {

        // L : 커서 왼쪽으로
        // D : 커서 오른쪽으로
        // B : 왼쪽 문자 삭제
        // P x : x 문자 커서 왼쪽에 추가
        StringBuilder sb = new StringBuilder(input);
        ArrayList<String> cmdArr = new ArrayList<>();

        for(String s : cmd.split(" ")) {
            cmdArr.add(s);
        }

        int cursor = sb.length(); // 커서 위치
        int cmdIdx = 0; // 커맨드의 인덱스
        while(cmdIdx != cmdArr.size()) { // 끝의 커맨드 실행 때까지 실행
            String cur = cmdArr.get(cmdIdx); // 현재 cmd 위치
            if(cur.equals("L")) {
                // 커서가 0보다 좌측으로 가면 안 됨
                // cursor가 음수로 가게 되면 0을 선택하게
                cursor = Math.max(0, cursor - 1);
            } else if(cur.equals("D")) {
                cursor = Math.min(sb.length(), cursor + 1);
            } else if(cur.equals("B")) {
                if(cursor == 0) {
                    cmdIdx++;
                    continue;
                }
                // 현재커서 -1인 인덱스만 삭제
                sb.delete(cursor - 1, cursor);
                cursor = Math.max(0,cursor - 1);
            } else if(cur.equals("P")) {
                String s = cmdArr.get(++cmdIdx);
                sb.insert(cursor, s);
                cursor += 1;
            }
            cmdIdx++;
        }
        System.out.println(sb.toString());
    }

    public static void solution2(int n) {
        String result = "";
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        // 큰 표기 ~ 작은 표기 순, 그 사이사이 예외 문자는 정의 미리 해둠
        int i = 0;
        while(n > 0) {
            while(n >= values[i]) {
                n -= values[i];
                result += roman[i];
            }
            i++;
        }
        System.out.println(result);
    }
    public static void solution(String s) {
        // 문자 들어왔을 때 숫자로 바꾸기
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0; // 변환된 결과
        // 들어오는 String에 접근하기 위하여 배열로
        char[] arr = s.toCharArray();
        // Index 에러가 발생하지 않기 위해 -1
        // 값 두 개를 꺼내서 앞 뒤자리를 비교
        for (int i = 0; i < arr.length - 1; i++) {
            if(map.get(arr[i]) < map.get(arr[i+1])) {
                // 작은 기호가 앞에 온 경우
                sum -= map.get(arr[i]);
            } else {
                sum += map.get(arr[i]);
            }
        }
        // 마지막 숫자는 무조건 더해주기, 그 다음 값과 비교할 수 없기 때문에
        // 마지막 숫자는 뺄셈이 발생할 수 없기 때문에 무조건 +
        sum += map.get(arr[arr.length -1]);
        System.out.println(sum);
    }
    public static void main(String[] args) {
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
        solution("LCXV");

        solution2(3);
        solution2(4);
        solution2(6);
        solution2(13);
        solution2(26);
        solution2(1994);

        solution3("aba","L B");
        solution3("abcd","P x L P y");
        solution3("abc","L L L P x L B P y");
        solution3("a","B B L L D D P a P b P c");
    }
}
