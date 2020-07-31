package revision;

import java.util.*;
//https://leetcode.com/problems/intersection-of-two-arrays/submissions/
public class Array_lc_intersection_of_two_array {
    public int[] intersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> l= new ArrayList<Integer>();
        int aa=0,bb=0;
        while(aa<a.length && bb<b.length){
            if(a[aa]==b[bb]){
                while(aa<a.length-1 && a[aa]==a[aa+1])
                    aa++;
                while(bb<b.length-1 && b[bb]==b[bb+1])
                    bb++;
                aa++;bb++;
            }
            else if(a[aa]<b[bb])
                l.add(a[aa++]);
            else
                l.add(b[bb++]);
        }
        aa=0;
        int ans[]= new int[l.size()];
        for(int x:l)
            ans[aa++]=x;
        return ans;
    }
}
