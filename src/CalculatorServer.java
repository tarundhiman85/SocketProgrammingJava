import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {

        System.out.println("Waiting for Client");
        ServerSocket ss = new ServerSocket(9806);
        Socket soc = ss.accept();  //ass soon as it gets the request it returns socket object
        System.out.println("Connection Established");
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String str = in.readLine();  //we will be sending back to same client
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        out.println("Server Says : "+str);

    }
}
