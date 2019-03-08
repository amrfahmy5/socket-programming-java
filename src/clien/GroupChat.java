package clien;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;

public class GroupChat {
 int port;
    String address;
   DatagramSocket socket ;
       public static Scanner input = new Scanner(System.in);
public GroupChat(int p) throws SocketException{
 socket = new DatagramSocket() ;
    this.port=p;

}
       public GroupChat(String ad, int p) throws SocketException, UnknownHostException 
    {
        
        this.port = p;
       
        this.address = ad;
        socket.connect(InetAddress.getByName(address), port);
        socket.setBroadcast(true);
    }
        public void send() throws IOException {
            System.out.print("Enter the Message: ");
             String message = input.next() ;
              
             while(!message.equals("Bye")){
          message = input.next();
        byte buf[] = message.getBytes();
        DatagramPacket dp = new DatagramPacket(buf,message.length(),InetAddress.getByName(address), port);
        socket.send(dp);
             }
             System.out.println("...Chat ended....");
             socket.close();
    }
     public void broadcast() throws SocketException, UnknownHostException, IOException
   {
            socket = new DatagramSocket();
       FileRW f = new FileRW() ;
       Vector <String>arr=f.Read();
       int size = arr.size();
       for(int i=0;i<size;i++)
       {
           this.address=arr.elementAt(i);
           socket.connect(InetAddress.getByName(address), this.port);
           byte buf1[] = new byte[1000];
           
        DatagramPacket dptorec = new DatagramPacket(buf1, buf1.length);
      //  socket.receive(dptorec);
        System.out.println(socket.getInetAddress()+" : Received data : " +dptorec.getData());
       }
       }
       
       
   }
    

