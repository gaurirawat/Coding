package IB;
//https://www.interviewbit.com/problems/interleaving-strings/
public class DP_ib_interleaving_strings {
    public int isInterleave(String A, String B, String C) {
        char a[]=A.toCharArray();
        char b[]=B.toCharArray();
        char c[]=C.toCharArray();
        if(c.length!=(a.length+b.length)) return 0;
        return isInterleaveInner(a,b,c,0,0,0)?1:0;
    }

    public boolean isInterleaveInner(char a[], char b[], char c[], int aa, int bb, int cc){
        if(cc==c.length) return true;
        boolean result=false;
        if(aa<a.length && a[aa]==c[cc]) result=isInterleaveInner(a,b,c,aa+1,bb,cc+1);
        if(bb<b.length && b[bb]==c[cc]) result=result||isInterleaveInner(a,b,c,aa,bb+1,cc+1);
        return result;
    }
}