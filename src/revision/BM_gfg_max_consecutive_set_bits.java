package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/longest-consecutive-1s/0
public class BM_gfg_max_consecutive_set_bits {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());

        while(t--!=0){
            int x=sc.nextInt();
            int mx=0;
            while(x!=0){
                int c=0 ;
                while((int)(x&1)==1){
                    c++;
                    x=x>>1;
                }
                mx=Math.max(c,mx);
                x=x>>1;
            }
            System.out.println(mx);
        }
    }
}
