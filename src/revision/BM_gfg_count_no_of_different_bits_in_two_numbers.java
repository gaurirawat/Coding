package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/bit-difference/0
public class BM_gfg_count_no_of_different_bits_in_two_numbers {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int n=x^y;
            int c=0;
            while(n!=0){
                c++;
                n=n&(n-1);
            }
            System.out.println(c);
        }
    }
}
