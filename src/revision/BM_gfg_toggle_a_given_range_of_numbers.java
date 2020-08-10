package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/toggle-bits-given-range/0
public class BM_gfg_toggle_a_given_range_of_numbers {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            int num=((1<<r)-1)^((1<<(l-1))-1);
            System.out.println(num^x);
        }
    }
}
