package revision;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/rotate-bits/0
public class BM_gfg_rotate_bits {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            short x=sc.nextShort();
            int d=sc.nextInt()%16;
            //right rotate
            System.out.println((x<<d)|(x>>(16-d)));
            //left rotate
            System.out.println((x>>d)|(x<<(16-d))& 0xFFFF);
            // we are doing & 0xFFFF so that the extra bits beyond size16 get removed
        }
    }
}
