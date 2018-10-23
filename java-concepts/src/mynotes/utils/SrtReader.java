package mynotes.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SrtReader {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.srt"), "UTF-8"));
        // Writing data
        File f2 = new File("test.txt");
        FileWriter fw = new FileWriter(f2);
        BufferedWriter bw = new BufferedWriter(fw);
        String s = br.readLine();
        int count = 0;
        while (s != null) {
            if (count == 3) {
                count = 0;
                bw.write(s.replaceAll("\\<[^>]*>", " "));
                bw.newLine();
                System.out.println(s);
                s = br.readLine();
            } else {
                s = br.readLine();
                count++;
            }

        }
        bw.flush();
        bw.close();
    }

}
