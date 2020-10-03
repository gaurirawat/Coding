package IB;
//https://www.interviewbit.com/problems/maximal-string/
public class Backtracking_ib_maximal_string {
    int max;
    public String solve(String a, int k) {
        max=0;
        char ch[]=a.toCharArray();
        inner(ch,0,k);
        return max+"";
    }
    public void inner(char[]ch, int i, int k){
        max=Math.max(max, Integer.parseInt(String.valueOf(ch)));
        if(k==0 || i==ch.length) return;
        inner(ch,i+1,k);
        for(int j=0;j<ch.length;++j){
            char t=ch[i];
            ch[i]=ch[j];
            ch[j]=t;
            inner(ch,i+1,k-1);
            t=ch[i];
            ch[i]=ch[j];
            ch[j]=t;
        }
    }
}
