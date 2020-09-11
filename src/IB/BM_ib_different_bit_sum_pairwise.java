package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/different-bits-sum-pairwise/
public class BM_ib_different_bit_sum_pairwise {
    public int cntBits(ArrayList<Integer> l) {
        int mod=(int)Math.pow(10,9)+7;
        long c=0;
        for(int i=0;i<32;++i){
            int ones=0;
            for(int x:l){
                if(((x>>i)&1)==1)
                    ones++;
            }
            c+=2l*(ones)*(l.size()-ones);
            c%=mod;
        }
        return (int)c;
    }
}
