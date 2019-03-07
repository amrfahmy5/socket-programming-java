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

    public Vector<String> Read() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
                arr.add(line);

            }

        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
        return arr;
    }

    public void Write(String ip) throws IOException {
        // write the content in file 
        FileWriter fw = new FileWriter("sample.txt", true);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            String fileContent = ip;
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // exception handling
        }

    }
}
