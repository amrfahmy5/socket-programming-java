package clien;

import java.io.IOException;
import java.net.*;

import java.util.*;
import java.util.logging.*;


public class Sender extends Thread {

    int port;
    String address;
    DatagramSocket socket;
    DatagramPacket dptorec ;
    String message ;
    public static Scanner input = new Scanner(System.in);

    public Sender(int p,String ad) throws SocketException {
        this.port = p;
       
        this.address = ad;
    }
    
    public void start(){  
        
        while(true){
        try {
//            FakeDataGenerator f = null ;
			//f.start();
			//message=FakeDataGenerator.getData();
System.out.println("Enter the Message:");
           message=input.next();
            peer p = new peer();
            p.multicast(message,this.port,address);
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ("end".equals(message)) {
                break;
        }
    }
}
}
