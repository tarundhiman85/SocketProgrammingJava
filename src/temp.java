import java.util.Arrays;
import java.util.Scanner;

public class temp {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0)
        {
            int M = in.nextInt(), x = in.nextInt(), y = in.nextInt();
            int m = x*y;
            int[] ar = new int[M+1];
            for(int i = 0; i<M; i++){
                ar[i] = in.nextInt();
            }
            ar[M] = 100+m+1;
            Arrays.sort(ar);
            int count = 0, left = 1;
            for(int i = 0; i<= M; i++){
                //System.out.println(i + " " + ar[i] + " " + left);
                if(ar[i]-m > left)
                {
                    count += ar[i]-m-left;
                }
                left = ar[i]+m+1;
            }
            System.out.println(count);
        }
    }
}
