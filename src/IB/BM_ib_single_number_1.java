package IB;

import java.util.List;

public class BM_ib_single_number_1 {
    public int singleNumber(final List<Integer> l) {
        int n=l.get(0);
        for(int i=1;i<l.size();++i){
            n=n^l.get(i);
        }
        return n;
    }
}
