package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits/0
public class BM_gfg_swap_all_odd_and_even_bits {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int odd=x&(0x55555555);
            int even=x&(0xAAAAAAAA);
            System.out.println((even>>1)|(odd<<1)&0xFFFFFFFF);
        }
    }
}
