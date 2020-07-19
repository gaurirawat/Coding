package revision;
//https://leetcode.com/problems/palindrome-partitioning-ii/submissions/
//https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.

/*
This problem appears to be similar to k partition problem at first but if we use that approach then the algo becomes very slow for
large inputs.
below soln is very easy. Only a bit different.
 */

public class DP_lc_palindrome_partitioning {
    public int minCut(String str) {
        if(str==null|| str.length()<=1)return 0;
        char s[]= str.toCharArray();

        // to store the min partitions required to make every substring palindrome for the initial i characters
        int dp[]= new int[s.length];
        //max partitions for string of length i can be i. hence worst case initialization.
        for(int i=0;i<s.length;++i)
            dp[i]=i;

        //consider every element to be mid of palindrome
        for(int m=0;m<s.length;++m){
            // CASE 1. odd len: center is at index mid, expand on both sides
            for(int l=m,r=m;l>=0 && r<s.length && s[l]==s[r];--l,++r){
                int part= l==0?0:dp[l-1]+1;
                dp[r]=Math.min(dp[r], part);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for(int l=m,r=m+1;l>=0 && r<s.length && s[l]==s[r];--l,++r){
                int part= l==0?0:dp[l-1]+1;
                dp[r]=Math.min(dp[r], part);
            }
        }
        return dp[s.length-1];
    }
}

/*
for huge length of string algo will become very slow. Plus the upper given approach is O(n^2)
    public int minCut(String s) {
        if(s==null||s.length()==1) return 0;
        return minCutDP(s,0,s.length()-1, new int[s.length()][s.length()]);
    }

    public int minCutDP(String s,int l, int r, int dp[][]){
        if(l==r)
            return 0;
        if(dp[l][r]!=0) return dp[l][r];
        if(isPalindrome(s.substring(l,r+1)))
            dp[l][r]=0;
        else{
            int part=Integer.MAX_VALUE;
            for(int i=l;i<r;++i){
                int x=minCutDP(s,l,i,dp);
                int y=-1;
                if(x!=-1)
                    y=minCutDP(s,i+1,r,dp);
                if(x!=-1 && y!=-1)
                    part=Math.min(part,1+x+y);
            }
            dp[l][r]=part==Integer.MAX_VALUE?-1:part;
        }
        return dp[l][r];
    }

    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
 */