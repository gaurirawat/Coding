package revision;

import java.util.*;
//https://leetcode.com/problems/merge-intervals/
public class Array_lc_merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int i=0;
        int c=0;
        while(i<intervals.length) {
            int[] t=intervals[i];
            ++i;
            while(i<intervals.length && t[1]>=intervals[i][0]){
                t[1]=Math.max(t[1], intervals[i][1]);
                i++;
            }
            intervals[c++]=t;
        }
        int[][] ans= new int[c][2];
        for(int j=0;j<c; ++j) {
            ans[j]=intervals[j];
        }
        return ans;
    }
}
