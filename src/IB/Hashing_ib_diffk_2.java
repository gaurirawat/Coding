package IB;

import java.util.HashSet;
import java.util.List;

//https://www.interviewbit.com/problems/diffk-ii/
public class Hashing_ib_diffk_2 {
    public int diffPossible(final List<Integer> l, int k) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<l.size();++i){
            int n=l.get(i);
            if(set.contains(k+n)||set.contains(n-k)){
                // System.out.println((n-k)+" "+n+" "+(k+n));
                return 1;
            }
            set.add(n);
        }
        return 0;
    }
}