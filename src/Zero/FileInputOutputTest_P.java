package Zero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//
public class FileInputOutputTest_P {
    public static void main(String[] args) throws Exception {
        String input = "./InOutput.txt";
        String output = "./InPutEdit.txt";

        // 찾을 단어, 변경 단어 입력 받기
        System.out.println("찾을 단어 : ");
        Scanner sc = new Scanner(System.in);
        String find = sc.nextLine();
        System.out.println("변경 단어 : ");
        String change = sc.nextLine();

        // 파일 읽기, 변경 및 저장
        BufferedReader br = new BufferedReader(new FileReader(input));
        FileWriter fw = new FileWriter(output);

        // 데이터 읽기
        while(true) {
            String line = br.readLine();
            if(line == null) {
                break;
            }
            String newLine = line.replace(find,change);
            fw.write(newLine);
        }

        fw.close();
        br.close();
    }
}
