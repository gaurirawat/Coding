package IB;

import java.util.*;
//https://www.interviewbit.com/problems/word-break/

public class DP_ib_word_break {
    HashMap<Character, ArrayList<String>> map;
    public int wordBreak(String s, String[] arr) {
        if(arr.length==0||s.length()==0) return 0;
        map= new HashMap<Character, ArrayList<String>>();
        for(String ss:arr){
            ArrayList<String> l=map.getOrDefault(s.charAt(0), new ArrayList<String>());
            l.add(ss);
            map.put(s.charAt(0),l);
        }
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return booleanWB(s, 0, dp)?1:0;
    }

    public boolean booleanWB(String s, int i, int dp[]){
        if(i==s.length()) return true;
        if(map.get(s.charAt(0))==null)
            return false;
        if(dp[i]!=-1) return dp[i]==1?true:false;
        boolean wbPossible=false;
        ArrayList<String> l=map.get(s.charAt(0));
        for(String x:l)
            if(x.length()<=s.length()-i && x.equals(s.substring(i,i+x.length())))
                wbPossible=wbPossible||booleanWB(s,i+x.length(),dp);
        dp[i]=wbPossible?1:0;
        return wbPossible;
    }
}
