package clien;


import java.io.*;
import java.util.*;


public class FilesInterface {

    private final String fileName;
    private ArrayList<String> Ips;
    private ArrayList<String> msgs;
    public FilesInterface(String fileName){
        this.fileName = fileName;
        Ips = new ArrayList<String>();
       
    }
    public void Write(String ip ,String msg) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName,true));
        writer.write(ip+" :"+msg);
        writer.newLine();
        writer.close();

    }
    public void WriteM(String ip) throws IOException
    {
        BufferedWriter writer= new BufferedWriter(new FileWriter(fileName,true));
         writer.write(ip);
         writer.newLine();
        writer.close();
    }
    public void Read() {
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                String arr[];
                arr = str.split(":");
            }

        } catch (IOException  exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
        sc.close();
    }
    public ArrayList<String> ReadM()
    {
                File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                Ips.add(str) ;
                
            }

        } catch (IOException  exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
        sc.close();
        return Ips;
    }

}
