package DS1to1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class peer {

    public static Scanner input = new Scanner(System.in);
    int port;
    InetAddress address;
   DatagramSocket socket ;
    

    public peer(InetAddress ad, int p) throws SocketException 
    {
        
        this.port = p;
        socket = new DatagramSocket() ;
        this.address = ad;
        socket.connect(address, port);
    }

    public void send(String message) throws IOException {
 
        byte buf[] = message.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, message.length(), address, port);
        socket.send(dp);
        System.out.println("...packet sent successfully....");
       socket.close();
    }

    public void receive() throws IOException {
        byte buf1[] = new byte[1000];
        DatagramPacket dptorec = new DatagramPacket(buf1, buf1.length);
        socket.receive(dptorec);
        System.out.println("Received packet data : " + Arrays.toString(dptorec.getData()));

    }

}

