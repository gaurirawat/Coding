package IB;

import java.util.*;

//https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
public class Pointer_ib_intersection_of_sorted_arrays {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int aa=0, bb=0;
        while(aa!=a.size() && bb!=b.size()){
            int x=a.get(aa).compareTo(b.get(bb));
            if(x==0){
                ans.add(a.get(aa));
                ++aa;++bb;
            }
            else if(x<0)
                ++aa;
            else
                ++bb;
        }
        return ans;
    }
}
