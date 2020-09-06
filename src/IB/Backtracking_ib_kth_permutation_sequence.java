package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/kth-permutation-sequence/
public class Backtracking_ib_kth_permutation_sequence {
    public String getPermutation(int n, int k) {
        if(n==1) return "1";
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=n;++i)
            l.add(i);
        int dp[]=new int[n];
        fact(n-1,dp);
        // System.out.println(Arrays.toString(dp));
        StringBuffer str=new StringBuffer();
        for(int i=0;i<n-1;++i){
            int j=0;
            if(dp[n-i-1]!=0){
                j=k/dp[n-i-1];
                if(j*dp[n-i-1]==k)
                    --j;
                k=k-(j*dp[n-i-1]);
            }
            // System.out.println(l.get(j));
            str.append(""+l.get(j));
            l.remove(l.get(j));
        }
        str.append(""+l.get(0));
        return str.toString();
    }

    public int fact(int n, int dp[]){
        if(n==1)
            dp[n]=1;
        else
            dp[n]=n*fact(n-1,dp);
        return dp[n];
    }
}
