package clien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileRW {

    private String fileName = "sample.txt";
    private Vector<String> arr;

    public Vector<String> Read() throws FileNotFoundException, IOException {
arr = new Vector<String>();
 FileReader fr = new FileReader("sample.txt");
        try (BufferedReader bufferedReader = new BufferedReader(fr)) {
            String line = bufferedReader.readLine();
            while (line != null) {
              //  System.out.println(line);
                line = bufferedReader.readLine();
                arr.add(line);
            }
        }
       fr.close();
        return arr;
    }

    public void Write(String ip) throws IOException {
        // write the content in file 
        FileWriter fw = new FileWriter("sample.txt", true);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            String fileContent = ip+"\n";
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // exception handling
        }
        fw.close();

    }
}
