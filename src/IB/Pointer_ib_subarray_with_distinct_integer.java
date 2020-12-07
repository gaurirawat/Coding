package IB;

import java.util.HashSet;

//https://www.interviewbit.com/problems/subarrays-with-distinct-integers/
public class Pointer_ib_subarray_with_distinct_integer {
    public int solve(int[] a, int b) {
        int c=0;
        for(int i=0;i<a.length;++i){
            HashSet<Integer> set=new HashSet<Integer>();
            for(int j=i;j<a.length;++j) {
                set.add(a[j]);
                if(set.size()==b) {
                    ++c;
                }
                else if(set.size()>b) {
                    break;
                }
            }
        }
        return c;
    }
}
