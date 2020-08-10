package revision;

import java.util.Scanner;

public class BM_gfg_sparse_number {
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());

        while(t--!=0){
            int x=sc.nextInt();
            int c=0;
            while(x!=0){
                if((int)(x&1)==1)
                    c++;
                else
                    c=0;
                if(c==2)
                    break;
                x=x>>1;
            }
            System.out.println(c==2?0:1);
        }
    }
}
