import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSWP {
    public static void main(String[] args) throws IOException {

        System.out.println("Waiting for Client");
        ServerSocket ss = new ServerSocket(9806);
        Socket soc = ss.accept();  //ass soon as it gets the request it returns socket object
        DataInputStream in=new DataInputStream(System.in);
        DataInputStream in1=new DataInputStream(soc.getInputStream());
        String sbuff[]=new String[8];
        PrintStream p;
        int sptr=0,sws=8,nf,ano,i;
        String ch;
        do
        {
            p=new PrintStream(soc.getOutputStream());
            System.out.print("Enter the no. of frames : ");
            nf=Integer.parseInt(in.readLine());
            p.println(nf);
            if(nf<=sws-1)
            {

                System.out.println("Enter "+nf+" Messages to be send\n");
                for(i=1;i<=nf;i++)
                {
                    sbuff[sptr]=in.readLine();
                    p.println(sbuff[sptr]);
                    sptr=++sptr%8;
                }
                sws-=nf;
                System.out.print("Acknowledgment received");
                ano=Integer.parseInt(in1.readLine());
                System.out.println(" for "+ano+" frames");
                sws+=nf;
            }
            else
            {
                System.out.println("The no. of frames exceeds window size");
                break;
            }
            System.out.print("\nDo you wants to send some more frames : ");
            ch=in.readLine(); p.println(ch);
        }
        while(ch.equals("yes"));
        soc.close();
    }
}
