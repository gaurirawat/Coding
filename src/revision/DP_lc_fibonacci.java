package revision;

//https://leetcode.com/problems/fibonacci-number/submissions/
public class DP_lc_fibonacci {
	
	public int fib(int n) {
        if(n<=1)
            return n;
        int a=0, b=1;
        int ans=0;
        while(n--!=1){
            ans= a+b;
            a=b;
            b=ans;
        }
        return ans;
    }
}	
