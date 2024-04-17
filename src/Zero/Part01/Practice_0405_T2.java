package Zero.Part01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practice_0405_T2 {
    public static void main(String[] args) throws IOException {
        String input = "./memo2";
        String inputEdit = "./memo3.txt";

        System.out.println("찾을 단어 입력 : ");
        Scanner sc = new Scanner(System.in);
        String find = sc.nextLine();
        System.out.println("변경 단어 : ");
        String to = sc.nextLine();

        // 파일 읽기
        BufferedReader br = new BufferedReader(new FileReader(input));
        FileWriter fw = new FileWriter(inputEdit);

        while(true) {
            String line = br.readLine();
            if(line == null) break;
            String newLine = line.replace(find,to);
            fw.write(newLine + '\n');
        }

        br.close();
        fw.close();
    }
}
