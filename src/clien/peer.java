package clien;

import java.io.IOException;
import java.net.*;



public class peer {
    public void multicast(String multicastMessage,int port,String address) throws IOException {

				DatagramSocket socket;
				InetAddress group;
				byte[] buf;    
				socket = new DatagramSocket();
                                socket.setBroadcast(true);
		        group = InetAddress.getByName(address);
		        buf = multicastMessage.getBytes();
		 
		        DatagramPacket packet 
		          = new DatagramPacket(buf, buf.length, group, port);
		        socket.send(packet);
		        socket.close();
		    }
}
