package revision;

import java.util.*;
//ref: https://leetcode.com/problems/split-array-with-same-average/discuss/127863/Share-a-Java-solution-using-DP
//https://leetcode.com/problems/split-array-with-same-average/submissions/
public class Math_lc_split_array_with_same_average {
    public boolean splitArraySameAverage(int[] a) {
        ArrayList<HashSet<Integer>> l=new ArrayList<HashSet<Integer>>();
        int sum=0;
        int len=a.length;
        for(int x: a) {
            sum+=x;
            HashSet<Integer> set=new HashSet<Integer>();
            l.add(set);
        }

        for(int i=0; i<len; ++i) {
            for(int j=len-2; j>=0; --j) {
                HashSet<Integer> prev=l.get(j);
                for(int x: prev) {
                    l.get(j+1).add(x+a[i]);
                }
            }
            l.get(0).add(a[i]);
        }

        for(int i=1;i<len;++i) {
            // System.out.println(l.get(i).toString());
            if((sum*i)%len==0 && l.get(i-1).contains(sum*i/len)) {
                return true;
            }
        }
        return false;
    }
}
