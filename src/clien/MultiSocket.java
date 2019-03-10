package clien;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiSocket extends Thread {

    
    
        protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];

     ArrayList<String> Ips ;
    int port ;
    public MultiSocket(int port) throws IOException {
        this.port = port;  
   }
    public void run() {
        try {
			socket = new MulticastSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	
        try {
            FilesInterface FM = new FilesInterface("member.txt");
            Ips=FM.ReadM();
            for(int i=0;i<Ips.size();i++)
                socket.joinGroup(InetAddress.getByName(Ips.get(i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        while (true) {
            
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
            String received = new String(
              packet.getData(), 0, packet.getLength());

            System.out.println("\t"+received);

            FilesInterface x = new FilesInterface("chat.txt");
            try {
                x.Write(packet.getAddress().toString(), received);
            } catch (IOException ex) {
                Logger.getLogger(MultiSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(packet.getAddress()+"say:"+received);
            if ("end".equals(received)) {
                break;
            }
        }
        try {
			for(int i=0;i<Ips.size();i++)
                socket.leaveGroup(InetAddress.getByName(Ips.get(i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
        socket.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    
//    
//    MulticastSocket socket;
//    int port;
//    FileRW f;
//    byte buf1[] = new byte[1000];
//    DatagramPacket dptorec;
//
//    public MultiSocket(int port) throws IOException {
//        this.port = port;
//        socket = new MulticastSocket(this.port);
//        f = new FileRW();
//        dptorec = new DatagramPacket(buf1, buf1.length);
//    }
//
//    public void BbyMS() throws IOException {
//
//        //Vector<String> arr = f.Read();
//        //int size = arr.size();
//        //System.out.println();
//        //arr.add("230.0.0.0");
//        //arr.add("230.0.0.1");
//        socket.joinGroup(InetAddress.getByName("230.0.0.0"));
//        //socket.joinGroup(InetAddress.getByName("230.0.0.2"));
////        for (int i = 0; i < size; i++) {
////            socket.joinGroup(InetAddress.getByName(arr.elementAt(0)));
////        }
//       while (true) {
//            DatagramPacket packet = new DatagramPacket(buf, buf.length);
//            try {
//				socket.receive(packet);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//            String received = new String(
//              packet.getData(), 0, packet.getLength());
//            System.out.println(packet.getAddress()+" "+received);
//            if ("end".equals(received)) {
//                break;
//            }
//        }
//        for (int i = 0; i < 1; i++) {
//            socket.leaveGroup(InetAddress.getByName(arr.elementAt(i)));
//        }
//
//        socket.close();
    }

