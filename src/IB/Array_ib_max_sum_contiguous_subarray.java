package IB;
//https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
public class Array_ib_max_sum_contiguous_subarray {
    public int maxSubArray(final int[] a) {
        int maxN=Integer.MIN_VALUE;
        int mx=0;
        int cmx=0;
        for(int i=0;i<a.length;++i){
            cmx=cmx+a[i];
            if(cmx<0)
                cmx=0;
            mx=Math.max(mx,cmx);
            maxN=Math.max(maxN,a[i]);
        }
        return mx==0?maxN:maxN;
    }
}