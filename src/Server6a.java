
import java.io.*;
import java.net.*;
public class Server6a
{
    public static void main(String [] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(10007);
        System.out.println("Waiting for connection");
        Socket clientSocket = serverSocket.accept();
        System.out.println("connection successfull");
        System.out.println("waiting for input");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream()));
        String inputline;
        while((inputline = in.readLine())!=null)
        {
            System.out.println("Server " + inputline);
            out.println(inputline);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
