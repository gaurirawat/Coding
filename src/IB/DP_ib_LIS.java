package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/longest-increasing-subsequence/
public class DP_ib_LIS {
    public int lis(final int[] a) {
        int inc[]=new int[a.length];
        int c=0;
        for(int i=0;i<a.length;++i){
            int pos= Arrays.binarySearch(inc,0,c,a[i]);
            // System.out.println(pos);
            if(pos<0)
                pos=Math.abs(pos+1);
            inc[pos]=a[i];
            c=Math.max(pos+1,c);
        }
        return c;
    }
}
