package IB;

import java.util.*  ;
//https://www.interviewbit.com/problems/pairs-with-given-xor/
public class Hashing_ib_pairs_with_given_xor {
    public int solve(ArrayList<Integer> a, int k) {
        HashSet<Integer> set= new HashSet<Integer>();
        int c=0;
        for(int i=0;i<a.size();++i){
            if(set.contains(a.get(i)^k))
                ++c;
            set.add(a.get(i));
        }
        return c;
    }
}