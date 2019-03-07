package clien;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
   private static Scanner inputs = new Scanner(System.in);
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        
        System.out.println("1-for 1 to 1 communication");
        System.out.println("2-for 1 to Group communication");
        String address = "LocalHost";
       int port =4444 ;
       int check = inputs.nextInt();
        if(check==1){
        System.out.println("Please Enter Port Number: ");
        port = inputs.nextInt();
      connect R = new connect(port);
        connect S = new connect(address,port);
    
        
        Thread thread1 = new Thread() {
    public void run()  {
        try {
            R.recieve();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            };
      Thread thread2 = new Thread() {
    public void run()  {
        try {
            S.send();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            };

thread1.start();
thread2.start();
thread1.join();
thread2.join();
        }
        
        
        
        
        
        
        
        
        
        
        
        else if(check==2)
        {
            System.out.println("Please Enter Port Number: ");
        port = inputs.nextInt();
            GroupChat gc = new GroupChat(address,port);
            gc.broadcast();
            gc.send();
            
        }
        else
            System.out.println("Please Enter 1 or 2");
       
    
    }
    
}
