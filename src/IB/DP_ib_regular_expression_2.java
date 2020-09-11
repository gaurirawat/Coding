package IB;
//https://www.interviewbit.com/problems/regular-expression-ii/

public class DP_ib_regular_expression_2 {
    public int isMatch(final String s, final String p) {
        int dp[][]=new int[s.length()][p.length()];
        char srr[]=s.toCharArray();
        char prr[]=p.toCharArray();
        return matchDP(srr.length-1,prr.length-1,srr,prr,dp)==1?1:0;
    }

    public int matchDP(int i, int j, char[]s, char[]p, int[][]dp){
        if(i==-1 && j==-1)
            return 1;
        if(i==-1 && j>0 && p[j]=='*')
            return matchDP(i,j-2,s,p,dp);
        if(i==-1||j==-1)
            return -1;
        if(dp[i][j]!=0) return dp[i][j];
        int ans=-1;
        if(s[i]==p[j]||p[j]=='.')
            ans= matchDP(i-1,j-1,s,p,dp);
        if(p[j]=='*'){
            ans=matchDP(i,j-2,s,p,dp);
            if(ans!=1 && (p[j-1]=='.'||p[j-1]==s[i]))
                ans=matchDP(i-1,j,s,p,dp);
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
}