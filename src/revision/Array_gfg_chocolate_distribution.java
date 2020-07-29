package revision;

import java.util.*;

public class Array_gfg_chocolate_distribution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=sc.nextInt();
            int arr[]= new int[len];
            for(int i=0;i<arr.length;++i)
                arr[i]=sc.nextInt();
            int k=sc.nextInt();
            Arrays.sort(arr);
            if(k>arr.length)
                System.out.println(arr[len-1]);
            else{
                int min=Integer.MAX_VALUE;
                for(int i=k-1;i<arr.length;++i)
                    min=Math.min(min, arr[i]-arr[i-(k-1)]);
                System.out.println(min);
            }

        }
    }
}
