package DailyPractice;

import java.io.*;

public class Practice_0405_4 {
    public static void main(String[] args) throws IOException {
        System.out.println("== 파입 입출력 ==");

        // 파일 쓰기
        FileWriter fw = new FileWriter("./memo.txt");
        // 현재 폴더에 memo.txt 만들기
        String memo = "헤드 라인\n";
        fw.write(memo);
        memo = "1월 1일 날씨 맑음\n";
        fw.write(memo);

        fw.close();

        // 이미 존재하는 파일에 쓰기 위해 사용
        PrintWriter pw = new PrintWriter("./memo.txt");
        memo = "헤드 라인";
        pw.println();
        pw.println(memo);
        memo = "1월 1일 날씨 맑음";
        pw.println(memo);
        pw.close();

        // 파일 이어 쓰기
        FileWriter fw2 = new FileWriter("./memo.txt",true);
        memo = "1월 2일 날씨 완전 맑음";
        fw2.write(memo);
        fw2.close();

        PrintWriter pw2 = new PrintWriter(new FileWriter("./memo.txt",true));
        memo = "1월 3일 날씨 또 맑음";
        pw2.println(memo);
        pw2.close();

        // 파일 입력
        BufferedReader br = new BufferedReader(new FileReader("./memo.txt"));

        while(true) {
            String line = br.readLine();
            // 한줄씩 읽어올 때 readLine
            if(line == null) {
                break;
            }
            System.out.println(line);
        }
        br.close();

    }
}
