package basething.readandwrite;

import java.io.*;

public class bufferread {
    public static void main(String[] args) throws IOException {
        String fileName = "allmypro/resources/read.txt";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
