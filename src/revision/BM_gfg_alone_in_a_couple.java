package revision;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/alone-in-couple/0
public class BM_gfg_alone_in_a_couple {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int xor=0;
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            for(int i=0;i<s.length;++i){
                xor=xor^Integer.parseInt(s[i]);
            }
            System.out.println(xor);
        }
    }
}
