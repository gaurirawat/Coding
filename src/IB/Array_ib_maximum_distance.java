package IB;
//https://www.interviewbit.com/problems/max-distance/
//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class Array_ib_maximum_distance {
    public int maximumGap(final int[] a) {
        if(a.length==0) return 0;
        int sml[]=new int[a.length];
        int bgr[]=new int[a.length];
        sml[0]=a[0];
        bgr[a.length-1]=a[a.length-1];

        for(int i=1;i<a.length;++i)
            sml[i]=Math.min(sml[i-1],a[i]);
        for(int i=a.length-2;i>=0;--i)
            bgr[i]=Math.max(bgr[i+1],a[i]);

        int mx=0;
        int ss=0,bb=0;
        while(ss<a.length && bb<a.length){
            if(sml[ss]>bgr[bb]){
                ss++;
            }
            else{
                mx=Math.max(mx, bb-ss);
                bb++;
            }

        }
        return mx;
    }
}
