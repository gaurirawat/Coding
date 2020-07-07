package revision;

//https://leetcode.com/problems/longest-common-subsequence/submissions/
public class DP_lc_LCS {
	
	public int longestCommonSubsequence(String t1, String t2) {
        int m=t1.length();
        int n= t2.length();
        int dp[][]= new int[2][n+1];
        
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n ;++j){
                
                if(t1.charAt(i-1)== t2.charAt(j-1))
                    dp[i%2][j]= dp[(i-1)%2][j-1]+1;
                else
                    dp[i%2][j]= Math.max( dp[i%2][j-1], dp[(i-1)%2][j] );
            }
        }        
        return dp[m%2][n];
    }
	
	/* Efficient but unnecessarily complicated
	public int longestCommonSubsequence(String t1, String t2) {
        int m=t1.length();
        int n= t2.length();
        int dp[]= new int[n+1];
        for(int i=1 ;i<=m; ++i){
            int prev=0;
            for(int j=1; j<=n; ++j){
                int temp=dp[j];
                if(t1.charAt(i-1)==t2.charAt(j-1))
                    dp[j]=prev+1;
                else
                    dp[j]= Math.max(dp[j], dp[j-1]);
                prev=temp;
            }
        }
        return dp[n];
    }
    */
}
