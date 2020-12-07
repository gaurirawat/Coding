package revision;

import java.util.*;

public class BSearch_lc_median_sorted_array {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length>b.length) {
            return findMedianSortedArrays(b,a);
        }

        int lo=0;
        int hi=a.length;
        while(lo<=hi) {
            int indexA = lo+(hi-lo)/2;
            int indexB= (a.length+b.length+1)/2 -indexA;
            /*
                for total n elements mid element id at n/2 index.
                Now if indexA is 3, it means that if total n/2 elements have to be in the left part of the joined array then if
                3 elements belong to the first array then n/2 -3 elements have to belong to the second array.
            */
            int amax=indexA==0?Integer.MIN_VALUE:a[indexA-1];
            int amin=indexA==a.length?Integer.MAX_VALUE:a[indexA];

            int bmax=indexB==0?Integer.MIN_VALUE:b[indexB-1];
            int bmin=indexB==b.length?Integer.MAX_VALUE:b[indexB];
            if(amax<=bmin && bmax<=amin) {
                if((a.length+b.length)%2==0) {
                    return (Math.max(amax, bmax) + Math.min(amin,bmin))/2.0;
                }
                else
                    return (double) Math.max(amax, bmax);
            } else if(amax>bmin) {
                hi=indexA-1;
            } else {
                lo=indexA+1;
            }
        }
        return -1;
    }
}
