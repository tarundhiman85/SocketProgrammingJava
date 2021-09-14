import java.io.*;
import java.net.*;
import java.util.*;
class SendIPCLient {

    public static void main(String args[]) throws IOException {
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Physical address (MAC):");
            String str = in.readLine();
            sendbyte = str.getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, 9806);
            client.send(sender);
            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            client.receive(receiver);
            String s = new String(receiver.getData());
            System.out.println("The Logical Address is(IP): " + s.trim());
            client.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }