package IB;
//https://www.interviewbit.com/problems/unique-binary-search-trees-ii/
public class DP_ib_no_of_unique_BST {
    public int numTrees(int n) {
        if(n==0) return 0;
        int dp[]=new int[n+1];
        return numTreesDP(n,dp);
    }

    public int numTreesDP(int n, int dp[]){
        if(n<=1) return 1;
        if(dp[n]!=0) return dp[n];
        int c=0;
        for(int i=0;i<n;++i){
            int lst=numTreesDP(i,dp);
            int rst=numTreesDP(n-i-1,dp);
            c+=(lst*rst);
        }
        dp[n]=c;
        return dp[n];
    }
}
