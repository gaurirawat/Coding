package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/rightmost-different-bit/0
public class BM_gfg_rightmost_different_bit {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(x==y){
                System.out.println(-1);
                continue;
            }
            int a=x^y;
            a=a&~(a-1);
            int pos=(int)(Math.log10(a)/Math.log10(2))+1;
            System.out.println(pos);
        }
    }
}