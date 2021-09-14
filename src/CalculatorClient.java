
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
        Socket soc = new Socket("localhost",9806);
        System.out.println("Connection Established");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));  //we are getting data from keyboard
        System.out.println("Welcome to Simple Calculator :");
        System.out.println("Enter the Operation:DIVIDE(/), MULTIPLY(*), SUBTRACT(-), ADD(+)");
        Scanner sc= new Scanner(System.in);
        String opr = sc.next();
        System.out.println("Enter First Number: ");
        int a=sc.nextInt();
        System.out.println("Enter Second Number: ");
        int ans=0;
        int b= sc.nextInt();;
        if(opr.equals("+")){
            ans=a+b;
        }
        else if(opr.equals("/")){
            ans=a/b;
        }
        else if(opr.equals("*")){
            ans=a*b;
        }
        else if(opr.equals("-")){
            ans=a-b;
        }
        else{
            System.out.println("Enter valid Operation");
        }
        String my_ans=Integer.toString(ans);
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        out.println(my_ans);
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(in.readLine());
    }
}
