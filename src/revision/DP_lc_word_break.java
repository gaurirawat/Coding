package revision;

import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/word-break/
//https://practice.geeksforgeeks.org/problems/word-break/0

public class DP_lc_word_break {
    public boolean wordBreak(String s, List<String> dict) {
        if(s==null) return false;
        Collections.sort(dict);
        int dp[]= new int[s.length()]; //default is 0
        int x=wordBreakDP(0,s,dict,dp);
        //we'll take 1 for present, -1 for not
        return x==1?true:false;
    }

    public int wordBreakDP(int x, String s, List<String> dict, int dp[]){
        if(x==s.length())
            return 1;
        if(dp[x]!=0) return dp[x];

        for(int i=x+1;i<=s.length();++i){
            if(dict.contains(s.substring(x,i))){
                dp[x]=wordBreakDP(i,s,dict,dp);
                if(dp[x]==1)
                    return dp[x];
            }
        }
        return dp[x]=-1;
    }
}
