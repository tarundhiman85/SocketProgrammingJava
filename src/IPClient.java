import java.io.*;
import java.net.*;
class IPClient {
    public static void main(String args[]) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket soc = new Socket("localhost", 9806);
            DataInputStream din = new DataInputStream(soc.getInputStream());
            DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
            System.out.println("Enter the Logical address(IP):");
            String str1 = in.readLine();
            dout.writeBytes(str1 + '\n');
            String str = din.readLine();
            System.out.println("The Physical Address is: " + str);
            soc.close();
        }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }
}