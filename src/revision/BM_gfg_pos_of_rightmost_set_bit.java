package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/find-first-set-bit/0
public class BM_gfg_pos_of_rightmost_set_bit {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            if(x==0){
                System.out.println(0);
                continue;
            }
            int num=x&~(x-1);
            int pos=(int)(Math.log10(num)/Math.log10(2))+1;
            System.out.println(pos);
        }
    }
}
