package IB;
//https://www.interviewbit.com/problems/maximum-ones-after-modification/
public class Pointer_ib_max_ones_after_modification {
    public int solve(int[] a, int k) {
        int l=0;
        int r=a.length;
        int max=0;
        for(int i=0;i<a.length;++i) {
            if(a[i]==0) {
                if(k==0) {
                    r = i;
                    break;
                }
                --k;
            }
        }
        max=r-l;
        while(r!=a.length) {
            ++r;
            while(r!=a.length && a[r]!=0) {
                r++;
            }
            while (l!=r && a[l]!=0) {
                ++l;
            }
            ++l;
            max=Math.max(max,r-l);
        }
        return max;
    }
}
