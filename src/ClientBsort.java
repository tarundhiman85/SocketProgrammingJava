
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientBsort {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
        Socket soc = new Socket("localhost",9806);
        System.out.println("Connection Established");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Elements:");
        String str= userInput.readLine();
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        out.println(str);
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String sorted_array=in.readLine();
        System.out.println(sorted_array);
}
}
