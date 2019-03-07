
package clien;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GroupChat {
 int port;
    String address;
   DatagramSocket socket ;
       public static Scanner input = new Scanner(System.in);

       public GroupChat(String ad, int p) throws SocketException, UnknownHostException 
    {
        
        this.port = p;
        socket = new DatagramSocket() ;
        this.address = ad;
        socket.connect(InetAddress.getByName(address), port);
    }
        public void send() throws IOException {
             String message = null ;
             while(!message.equals("Bye")){
          message = input.next();
        byte buf[] = message.getBytes();
        DatagramPacket dp = new DatagramPacket(buf,message.length(),InetAddress.getByName(address), port);
        socket.send(dp);
             } 
             System.out.println("...All Done....");
             socket.close();
    }
     public void broadcast() throws SocketException, UnknownHostException, IOException
   {
       DatagramSocket socket = new DatagramSocket();
       int size = 0;//get size of file
       for(int i=0;i<size;i++)
       {
           //read address from file
           socket.connect(InetAddress.getByName(address), this.port);
           byte buf1[] = new byte[1000];
           
        DatagramPacket dptorec = new DatagramPacket(buf1, buf1.length);
        socket.receive(dptorec);
        System.out.println(socket.getInetAddress()+" : Received data : " +dptorec.getData());
       }
       
       
   }
    
}
