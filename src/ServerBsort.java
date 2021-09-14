import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ServerBsort {
    public static void main(String[] args) throws IOException {

        System.out.println("Waiting for Client");
        ServerSocket ss = new ServerSocket(9806);
        Socket soc = ss.accept();  //ass soon as it gets the request it returns socket object
        System.out.println("Connection Established");
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        String str = in.readLine();  //we will be sending back to same client
        int n=str.length();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            if(str.charAt(i)!=' '){
                arr.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        int size=arr.size();
        boolean flag=false;
        for(int i=1; i<size; i++){
            if(arr.get(i-1)>arr.get(i)){
               flag=true;
            }
        }
        StringBuilder new_S = new StringBuilder();
        if (flag){
                //Bubble Sort
                for (int i = 0; i < size-1; i++)
                {
                    for (int j = 0; j < size - i - 1; j++) {
                        if (arr.get(j) > arr.get(j + 1)) {
                            Collections.swap(arr, j+1, j);
                        }
                    }
                }
                for (int i=0; i<size; i++){
                    new_S.append(arr.get(i));
                    new_S.append(" ");
                }
            out.println("Server Says : Not Sorted" + "Sorted Array is:"+new_S);
        }
        else {
            out.println("Server Says : Already Sorted");
        }
        }
}
