package IB;
//https://www.youtube.com/watch?v=pGVguAcWX4g
//https://www.interviewbit.com/problems/evaluate-expression-to-true/
//https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
public class DP_ib_ways_to_evaluate_expression_to_true {
    int mod=(int)Math.pow(10,3)+3;
    public int cnttrue(String a) {
        char ch[]=a.toCharArray();
        int t[][]=new int[a.length()][a.length()];
        int f[][]=new int[a.length()][a.length()];
        return cntTrueDP(0,a.length()-1,t,f,ch,true);
    }

    public int cntTrueDP(int l, int r, int t[][], int f[][], char ch[], boolean result){
        if(l==r)  return result?(ch[l]=='T'?1:0):(ch[l]=='T'?0:1);
        if(result && t[l][r]!=0) return t[l][r];
        else if(!result && f[l][r]!=0) return f[l][r];
        int tc=0;int fc=0;
        for(int i=l+1;i<r;i+=2){
            int lt=cntTrueDP(l,i-1,t,f,ch,true);
            int lf=cntTrueDP(l,i-1,t,f,ch,false);
            int rt=cntTrueDP(i+1,r,t,f,ch,true);
            int rf=cntTrueDP(i+1,r,t,f,ch,false);
            if(ch[i]=='|'){
                tc+=lt*rf+lf*rt+lt*rt;
                fc+=lf*rf;
            }
            else if(ch[i]=='&'){
                fc+=lt*rf+lf*rt+lf*rf;
                tc+=lt*rt;
            }
            else{
                tc+=lt*rf+lf*rt;
                fc+=lf*rf+lt*rt;
            }
        }
        t[l][r]=tc%mod;
        f[l][r]=fc%mod;
        return result?t[l][r]:f[l][r];
    }
}
