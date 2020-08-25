package IB;
//https://www.interviewbit.com/problems/ways-to-decode/
public class DP_ib_ways_to_decode {
    public int numDecodings(String s) {
        char ch[]=s.toCharArray();
        int dp[]=new int[s.length()+1];
        return decodingInner(0,ch,dp);
    }
    public int decodingInner(int i, char[]ch, int dp[]){
        if(i==ch.length) return 1;
        if(ch[i]=='0') return 0;
        if(dp[i]!=0) return dp[i];

        int mod=(int)Math.pow(10,9)+7;
        long c=decodingInner(i+1,ch,dp);
        if(i!=ch.length-1 && Integer.parseInt(ch[i]+""+ch[i+1])<=26)
            c+=decodingInner(i+2,ch,dp);
        c=c%mod;
        dp[i]=(int)c;
        return dp[i];
    }
}
