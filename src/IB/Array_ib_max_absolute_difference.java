package IB;
//https://www.interviewbit.com/problems/maximum-absolute-difference/
//concept clarity: https://www.geeksforgeeks.org/maximum-absolute-difference-value-index-sums/

public class Array_ib_max_absolute_difference {
    public int maxArr(int[] a) {
        int mxs=Integer.MIN_VALUE, mxd=Integer.MIN_VALUE;
        int mns=Integer.MAX_VALUE, mnd=Integer.MAX_VALUE;
        for(int i=0;i<a.length;++i){
            mxs=Math.max(a[i]+i,mxs);
            mxd=Math.max(a[i]-i,mxd);
            mns=Math.min(a[i]+i,mns);
            mnd=Math.min(a[i]-i,mnd);
        }
        return Math.max(mxs-mns,mxd-mnd);
    }
}
