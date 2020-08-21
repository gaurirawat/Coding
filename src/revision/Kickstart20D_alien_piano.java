package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kickstart20D_alien_piano {
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

            System.out.println("Case #"+(T+1)+": "+alien(arr));
        }
    }

    public static int alien(int arr[]){
        int ans[]=new int[arr.length];
        for(int i=1;i<arr.length;++i){
            if(arr[i]>arr[i-1] && ans[i-1]!=3)
                ans[i]=ans[i-1]+1;
            if(arr[i]==arr[i-1])
                ans[i]=ans[i-1];
        }
        for(int i=arr.length-2; i>=0;--i){
            if(arr[i]>arr[i+1] && ans[i+1]!=3)
                ans[i]=ans[i+1]+1;
            if(arr[i]==arr[i+1])
                ans[i]=ans[i+1];
        }

        System.out.println(Arrays.toString(ans));

        int c=0;
        for(int i=1;i<arr.length-1;++i){
            if(arr[i]>arr[i-1] && ans[i]<ans[i-1])
                c++;
            if(arr[i]==arr[i-1] && ans[i]!=ans[i-1])
                c++;
        }

        for(int i=arr.length-2; i>=0;--i){
            if(arr[i]>arr[i+1] && ans[i]<=ans[i+1])
                c++;
        }
        return c;
    }
}
