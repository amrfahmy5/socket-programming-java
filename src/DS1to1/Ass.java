package DS1to1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ass {

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws InterruptedException, IOException 
    {
    InetAddress address = InetAddress.getLocalHost();
        int port = 555;
        peer sender = new peer(address, port);

                    InetAddress addres = InetAddress.getByName("LocalHost");
              peer reciever = new peer(addres,port);
            
              Thread thread1 = new Thread() {
    public void run()  {

        try {
            reciever.receive();
        } catch (IOException ex) {
            Logger.getLogger(Ass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
};
        
  Thread thread2 = new Thread() {
    public void run()  {
        try {
             System.out.println("Enter the message you want to send:");
        String message = input.next();
            sender.send(message);
        } catch (IOException ex) {
            Logger.getLogger(Ass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
};


            // write in file the message
        thread1.start();
thread2.start();


thread1.join();
thread2.join();
}

}
