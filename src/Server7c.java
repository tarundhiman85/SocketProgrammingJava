import java.io.*;
import java.net.*;
public class Server7c
{
    private static int indexOf(String[] array, String str)
    {
        str = str.trim();
        for (int i=0; i < array.length; i++)
        {
            if (array[i].equals(str))
                return i;
        }
        return -1;
    }
    public static void main(String arg[])throws IOException {
        String[] hosts = {"yahoo.com", "gmail.com", "cricinfo.com", "facebook.com"};
        String[] ip = {"68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16"};
        System.out.println("Press Ctrl + C to Quit");
        while (true) {
            DatagramSocket Server_Socket = new DatagramSocket(1362);
            byte[] Send_Data = new byte[1021];
            byte[] Receive_Data = new byte[1021];

            DatagramPacket Receive_Packet = new DatagramPacket(Receive_Data, Receive_Data.length);
            Server_Socket.receive(Receive_Packet);
            String sen = new String(Receive_Packet.getData());
            InetAddress ipaddress = Receive_Packet.getAddress();

            int port = Receive_Packet.getPort();
            String Cap_Sent;
            System.out.println("Request for host " + sen);

            if (indexOf(hosts, sen) != -1) Cap_Sent = ip[indexOf(hosts, sen)];
            else Cap_Sent = "Host Not Found";

            Send_Data = Cap_Sent.getBytes();
            DatagramPacket pack = new DatagramPacket(Send_Data, Send_Data.length, ipaddress, port);
            Server_Socket.send(pack);
            Server_Socket.close();
        }
    }
}
