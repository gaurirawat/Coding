package revision;
//https://www.interviewbit.com/problems/array-3-pointers/
public class Pointer_ib_3_array_pointers {
	public int minimize(final int[] a, final int[] b, final int[] c) {
        if(a==null||b==null||c==null)
            return Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        int ca=0, cb=0, cc=0;
        while(ca!=a.length && cb!=b.length && cc!=c.length){
            int mx=Math.max(Math.max(a[ca], b[cb]), c[cc]);
            int mn=Math.min(Math.min(a[ca], b[cb]), c[cc]);
            ans=Math.min(ans, Math.abs(mx-mn));
            if(mn==a[ca])
                ca++;
            else if(mn==b[cb])
                cb++;
            else
                cc++;
        }
        return ans;
    }
}
