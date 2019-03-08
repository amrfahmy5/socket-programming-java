package clien;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class OneToOne {
    private Socket socket = null;
    private int port;
    private String  address;
   public OneToOne(String ip,int p) throws IOException
    {
        this.port=p;
        this.address = ip;
        
        
    }
   public OneToOne(int p)
   {
       this.port=p;
   }
    public void send() throws IOException
    {socket = new Socket(address,port);
        
        DataInputStream in = new DataInputStream(socket.getInputStream());

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 ="" , s2 = "";
         while(!s1.equals("Bye"))
        {
           
                       //=---------Send------------

            s1 = bf.readLine();
            out.writeUTF(s1);
            out.flush();
            //---------Recieve--------
            s2 = in.readUTF();
            System.out.println("\t Server : "+s2);
        }
        
              out.close();
        in.close();
        socket.close();

    }

    public void recieve() throws IOException
    {
        ServerSocket s = new ServerSocket(port);
         Socket c = s.accept();
        System.out.println("Sender With local address:"+c.getLocalAddress()+"  Is Connected Successfully");
         System.out.println("-----------------------------------------------------------");
	
        DataInputStream in = new DataInputStream(c.getInputStream());
	
        DataOutputStream out = new DataOutputStream(c.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
        String s1 = "" , s2 = "";
	
        while(!s1.equals("Bye"))
        {
            s1 = in.readUTF();
            System.out.println("\tSender LA(" +c.getLocalAddress()+") : "+s1);
            s2 = bf.readLine();
            out.writeUTF(s2);

            out.flush();
        }
        out.close();
        in.close();
        s.close();
   
    }
    
  
}
