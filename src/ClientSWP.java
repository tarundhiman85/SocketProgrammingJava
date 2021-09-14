import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientSWP {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
        Socket soc = new Socket("localhost", 9806);
        System.out.println("Connection Established");
        DataInputStream in=new DataInputStream(soc.getInputStream());
        PrintStream p=new PrintStream(soc.getOutputStream());
        int i=0,rptr=-1,nf,rws=8;
        String rbuf[]=new String[8];
        String ch; System.out.println();
        do
        {
            nf=Integer.parseInt(in.readLine());
            if(nf<=rws-1)
            {
                for(i=1;i<=nf;i++)
                {
                    rptr=++rptr%8;
                    rbuf[rptr]=in.readLine();
                    System.out.println("The received Frame " +rptr+" is : "+rbuf[rptr]);
                }
                rws-=nf;
                System.out.println("\nAcknowledgment sent\n");
                p.println(rptr+1); rws+=nf; }
            else
                break;
            ch=in.readLine();
        }
        while(ch.equals("yes"));
    }
}
