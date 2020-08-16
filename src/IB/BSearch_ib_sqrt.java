package IB;
//https://www.interviewbit.com/problems/square-root-of-integer/
public class BSearch_ib_sqrt {
    public int sqrt(int n) {
        if(n==1) return 1;
        int l=1,r=n-1;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid*1l*mid<=n){
                ans=mid;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return ans;
    }
}
