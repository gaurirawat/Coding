package revision;
//https://leetcode.com/problems/regular-expression-matching/submissions/
public class DP_lc_regular_expression_matching {
    public boolean isMatch(String s, String p) {
        if(p.length()==0 && s.length()==0) return true;
        if(p.length()==0) return false;
        int dp[][]= new int[s.length()][p.length()];
        return isMatchDP(s, p, s.length() - 1, p.length() - 1, dp) == 1;
    }

    public int isMatchDP(String s, String p, int i, int j, int dp[][]){
        if(i==-1 && j==-1)
            return 1;
        if(i==-1 && j>0 && p.charAt(j)=='*') //for a case where s="abc", p="*x*yabc"or  s="",p="*a*b*c"
            return isMatchDP(s,p,i,j-2,dp);
        if(i<=-1 || j<=-1)
            return -1;
        if(dp[i][j]!=0)
            return dp[i][j];

        if(p.charAt(j)=='.'||s.charAt(i)==p.charAt(j))
            dp[i][j]=isMatchDP(s,p,i-1,j-1,dp);
        else if(p.charAt(j)=='*'){
            // * element not present in string
            dp[i][j]=isMatchDP(s,p,i,j-2,dp);
            // * element present in string
            if(dp[i][j]==-1 && (p.charAt(j-1)=='.'||s.charAt(i)==p.charAt(j-1)))
                dp[i][j]=isMatchDP(s,p,i-1,j,dp);
        }
        else
            dp[i][j]=-1;
        return dp[i][j];
    }

}
