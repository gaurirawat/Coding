package IB;

import java.util.*;

//https://www.interviewbit.com/problems/min-xor-value/
public class BM_ib_min_xor_value {
    public int findMinXor(ArrayList<Integer> l) {
        Collections.sort(l);

        int mn=Integer.MAX_VALUE;
        for(int i=1;i<l.size();++i){
            mn=Math.min(l.get(i)^l.get(i-1), mn);
        }

        return mn;
    }
}
