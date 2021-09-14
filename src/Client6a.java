
import java.io.*;
import java.net.*;
public class Client6a
{
    public static void main(String [] args) throws Exception
    {
        String serverhostname = new String ("127.0.0.1");
        System.out.println("Attempting to connect to host " + serverhostname + " on pst 10007"); Socket echoSocket = new Socket(serverhostname,10007);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new
                InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); String userInput;
        System.out.print("input");
        while((userInput = stdIn.readLine())!=null)
        {
            System.out.print(userInput);
            System.out.println("echo " + in.readLine());
            System.out.print("input");
        }
    }
}
