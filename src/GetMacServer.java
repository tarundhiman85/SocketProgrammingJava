import java.io.*;
import java.net.*;
import java.util.*;
class GetMacServer {

    public static void main(String args[]) throws IOException {
        try {
            DatagramSocket server = new DatagramSocket(9806);
            while (true) {
                byte[] sendbyte = new byte[1024];
                byte[] receivebyte = new byte[1024];
                System.out.println("Listening");
                DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
                server.receive(receiver);
                String str = new String(receiver.getData());
                String s = str.trim();
                InetAddress addr = receiver.getAddress();
                int port = receiver.getPort();

                String ip[] = {"165.165.80.80", "165.165.79.1"};
                String mac[] = {"6A:08:AA:C2", "8A:BC:E3:FA"};
                for (int i = 0; i < ip.length; i++)
                {
                    if (s.equals(mac[i])) {
                        sendbyte = ip[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        System.out.println("Listened and Done");
                        break;
                    }
                }
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

