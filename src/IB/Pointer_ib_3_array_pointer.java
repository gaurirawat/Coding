package IB;
//https://www.interviewbit.com/problems/array-3-pointers/
public class Pointer_ib_3_array_pointer {
    public int minimize(final int[] a, final int[] b, final int[] c) {
        if(c==null||b==null||c==null||a.length==0||b.length==0||c.length==0)
            return Integer.MAX_VALUE;
        int aa=0,bb=0,cc=0;
        int ans=Integer.MAX_VALUE;
        while(aa<a.length && bb<b.length && cc<c.length){
            int max=Math.max(a[aa],Math.max(b[bb],c[cc]));
            int min=Math.min(a[aa],Math.min(b[bb],c[cc]));
            ans=Math.min(ans,max-min);
            if(a[aa]==min) aa++;
            else if(b[bb]==min) bb++;
            else if(c[cc]==min) cc++;
        }
        return ans;
    }
}
