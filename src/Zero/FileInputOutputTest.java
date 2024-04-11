package Zero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileInputOutputTest {
    public static void main(String[] args) throws Exception {
        // 현재 폴더에 memo라는 이름의 txt 파일 만든다
        FileWriter fw = new FileWriter("./memo.txt");
        String memo = "헤드 라인\n";
        fw.write(memo);

        memo = "1월 1일 날씨 맑음";
        fw.write(memo);
        fw.close();

        // PrintWriter
        PrintWriter pw = new PrintWriter("./memo.txt");
        memo = "헤드 라인";
        pw.println(memo); // line까지 포함해서 출력이라 \n 안 써도 된다
        memo = "1월 1일 날씨 맑음";
        pw.println(memo);
        pw.close();

        // 파일에 이어 쓰기
        FileWriter fw2 = new FileWriter("./memo.txt",true);
        // true : 이어쓰기
        memo = "1월 2일 날씨 완전 맑음\n";
        fw2.write(memo);
        fw2.close();

        // 파일에 이어 쓰기 2
        PrintWriter pw2 = new PrintWriter(new FileWriter("./memo.txt",true));
        memo = "1월 3일 날씨 또 맑음";
        pw2.println(memo);
        pw2.close();

        // 파일로부터 데이터를 읽어 오기
        // System.in은 키보드로부터 읽고
        // FileReader로 읽을 파일명 입력
        BufferedReader br = new BufferedReader(new FileReader("./memo.txt"));

        while(true) {
            // 데이터 읽기
            String line = br.readLine();

            if(line == null) {
                break;
            }
            System.out.println(line);
        }
        br.close();

    }
}
