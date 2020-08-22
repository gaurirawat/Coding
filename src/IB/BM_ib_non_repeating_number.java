package IB;

import java.util.List;

//https://www.interviewbit.com/problems/single-number/
public class BM_ib_non_repeating_number {
    public int singleNumber(final List<Integer> l) {
        int n=l.get(0);
        for(int i=1;i<l.size();++i){
            n=n^l.get(i);
        }
        return n;
    }
}
