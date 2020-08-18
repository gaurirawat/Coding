package revision;
//https://leetcode.com/problems/the-kth-factor-of-n/
public class Math_lc_kth_factor_of_n {
    public int kthFactor(int n, int k) {
        if(k==0 || n==0) return -1;
        if(k==1) return 1;
        for(int i=1;i<=n/2+1;++i){
            if(n%i==0) --k;
            if(k==0) return i;
        }
        if(k==1) return n;
        return -1;
    }
}
