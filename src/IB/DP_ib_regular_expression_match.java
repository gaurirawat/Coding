package IB;
//https://www.interviewbit.com/problems/regular-expression-match/
public class DP_ib_regular_expression_match {
    public int isMatch(final String a, final String b) {
        char arr[]=a.toCharArray();
        char brr[]=b.toCharArray();
        int dp[][]=new int[arr.length][brr.length];
        return isMatchInner(arr,brr,arr.length-1,brr.length-1,dp)==1?1:0;
    }

    public int isMatchInner(char[]a, char[]b, int i, int j, int dp[][]){
        if(i==-1 && j==-1) return 1;
        if(i==-1 && b[j]=='*') return isMatchInner(a,b,i,j-1,dp);
        if(i==-1|| j==-1) return -1;
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j]=-1;
        if(a[i]==b[j]||b[j]=='?')
            dp[i][j]= isMatchInner(a,b,i-1,j-1,dp);
        else if(b[j]=='*'){
            dp[i][j]=isMatchInner(a,b,i-1,j-1,dp);
            if(dp[i][j]!=1)
                dp[i][j]=isMatchInner(a,b,i-1,j,dp);
            if(dp[i][j]!=1)
                dp[i][j]=isMatchInner(a,b,i,j-1,dp);
        }
        return dp[i][j];
    }
}
