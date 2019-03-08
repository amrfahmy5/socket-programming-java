package clien;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Scanner inputs = new Scanner(System.in);

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

        System.out.println("1-for 1 to 1 communication");
        System.out.println("2-for 1 to Group communication");
        String address = "LocalHost";
        int port = 4444;
        int check = inputs.nextInt();
        if (check == 1) {
            System.out.println("Please Enter Port Number: ");
            port = inputs.nextInt();
            OneToOne R = new OneToOne(port);
            OneToOne S = new OneToOne(address, port);

            Thread thread1 = new Thread() {
                public void run() {
                    try {
                        R.recieve();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
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
        
        
        else if (check == 2) {
            System.out.print("If you need Add member to Group enter  1 :");
            check = inputs.nextInt();
            if (check == 1) {
                System.out.print("Enter Num of Member:");
                int Size = inputs.nextInt();
                for (int i = 0; i < Size; i++) {
                    FileRW file = new FileRW();
                    file.Write(inputs.next());
                }
            }
            System.out.println("Please Enter Port Number of the group you want to connect with: ");
            port = inputs.nextInt();

            GroupChat gc = new GroupChat(port);
            while (true) {
                System.out.println("End the Message");
                String message = inputs.next();
                Thread thread1 = new Thread() {
                    public void run() {
                        try {
                          //  gc.broadcast();
                            gc.BbyMS();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                Thread thread2 = new Thread() {
                    public void run() {
                        try {
                            gc.send(message);
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread1.start();
                thread2.start();
                thread1.join();
                thread2.join();
                if (message == "Bye") {
                    break;
                }
            }
        } else {
            System.out.println("Please Enter 1 or 2");
        }

    }

}
