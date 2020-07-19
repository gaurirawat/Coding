package revision;

//https://leetcode.com/problems/trapping-rain-water/submissions/
public class Array_lc_rainwater_trapping {
    public int trap(int[] h) {
        int lmax[]= new int[h.length];//contains the max element on left including itself
        int rmax[]= new int[h.length];//contains the max element on right including itself

        int max=0;
        for(int i=0;i<h.length;++i){
            max=Math.max(h[i],max);
            lmax[i]= max;
        }

        max=0;
        for(int i=h.length-1;i>=0;--i){
            max=Math.max(h[i],max);
            rmax[i]= max;
        }

        int sum=0;
        for(int i=0;i<h.length;++i)
            sum+= Math.min(lmax[i],rmax[i])-h[i];
        return sum;
    }
}
