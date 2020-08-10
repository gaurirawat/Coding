package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/count-total-set-bits/0
public class BM_gfg_total_set_bits_for_numbers_till_n {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int c=0;
            while(x!=0){
                int n=x;
                while(n!=0){
                    c++;
                    n=n&(n-1);
                }
                --x;
            }
            System.out.println(c);
        }
    }
}
