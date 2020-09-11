package IB;

import java.util.List;

public class BM_ib_single_number_2 {
    public int singleNumber(final List<Integer> a) {
        long c[]=new long[32];
        for(int x:a){
            for(int i=0;i<32;++i){
                c[i]+=x&(1<<i);
            }
        }
        int n=0;
        for(int i=0;i<32;++i){
            if(c[i]%3!=0)
                n+=(1<<i);
        }
        return n;
    }
}