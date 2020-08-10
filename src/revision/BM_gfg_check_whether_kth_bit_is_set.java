package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not/0
public class BM_gfg_check_whether_kth_bit_is_set {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int x=sc.nextInt();
            int k=sc.nextInt();
            System.out.println((x&(1<<k))==(1<<k)?"Yes":"No");
        }
    }
}
