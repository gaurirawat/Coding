package IB;

import java.util.*;
//https://www.interviewbit.com/problems/k-largest-elements/
public class Heap_ib_k_largest_elements {
    public ArrayList<Integer> solve(ArrayList<Integer> a, int k) {
        Collections.sort(a, Collections.reverseOrder());
        ArrayList<Integer> l= new ArrayList<Integer>();
        for(int i=0;i<k;++i)
            l.add(a.get(i));
        return l;
    }
}
