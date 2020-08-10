package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/set-kth-bit/0
public class BM_gfg_set_kth_bit {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(x|(1<<k));
        }
    }
}
