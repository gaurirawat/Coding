package revision;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Kickstart20D_record_breaker {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int T=0;T<t;++T){
            int len=Integer.parseInt(br.readLine());
            int arr[]=new int[len];
            String s[]=br.readLine().split(" ");
            for(int i=0;i<len;++i){
                arr[i]=Integer.parseInt(s[i]);
            }

            System.out.println("Case #"+(T+1)+": "+find(arr));
        }
    }

    public static int find(int arr[]){
        int mx=Integer.MIN_VALUE;
        int c=0;
        for(int i=0;i<arr.length;++i){
            if(mx<arr[i] && (i==arr.length-1 ||arr[i]>arr[i+1]))
                c++;
            mx=Math.max(arr[i],mx);
        }
        return c;
    }
}
