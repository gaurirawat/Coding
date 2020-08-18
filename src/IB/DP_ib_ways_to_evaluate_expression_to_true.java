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

    public int cntTrueDP(int l, int r, int trr[][], int frr[][], char ch[], boolean result){
        if(l==r) return ch[l]=='T'?(result?1:0):(result?0:1);
        if(result && trr[l][r]!=0) return trr[l][r];
        if(!result && frr[l][r]!=0) return frr[l][r];
        int t=0,f=0;
        for(int i=l+1;i<r;i+=2){
            int lt=cntTrueDP(l,i-1,trr,frr,ch,true);
            int rt=cntTrueDP(i+1,r,trr,frr,ch,true);
            int lf=cntTrueDP(l,i-1,trr,frr,ch,false);
            int rf=cntTrueDP(i+1,r,trr,frr,ch,false);
            if(ch[i]=='&'){
                t+=lt*rt;
                f+=((lt+lf)*(rt+rf))-rt*lt;
            }
            else if(ch[i]=='|'){
                t+=((lt+lf)*(rt+rf))-lf*rf;
                f+=lf*rf;
            }
            else if(ch[i]=='^'){
                t+= lf*rt+lt*rf;
                f+= lt*rt+lf*rf;
            }
            t%=mod;
            f%=mod;
        }
        trr[l][r]=t;
        frr[l][r]=f;
        if(result) return trr[l][r];
        return frr[l][r];
    }
}
