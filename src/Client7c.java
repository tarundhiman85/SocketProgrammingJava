import java.io.*;
import java.net.*;
public class Client7c
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket Client_Socket = new DatagramSocket();
        InetAddress ipaddress;

        if (args.length == 0)  ipaddress = InetAddress.getLocalHost();
        else ipaddress = InetAddress.getByName(args[0]);

        byte[] Send_data = new byte[1024];
        byte[] Receive_Data = new byte[1024];
        int Port = 1362;
        System.out.print("Enter the hostname : ");
        String sentence = br.readLine();
        Send_data = sentence.getBytes();
        DatagramPacket pack = new DatagramPacket(Send_data,Send_data.length, ipaddress,Port);
        Client_Socket.send(pack);
        DatagramPacket Receive_Packet =new DatagramPacket(Receive_Data,Receive_Data.length);
        Client_Socket.receive(Receive_Packet);
        String modified = new String(Receive_Packet.getData());
        System.out.println("IP Address: " + modified);
        Client_Socket.close();
    }
}
