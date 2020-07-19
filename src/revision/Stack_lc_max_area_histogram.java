package revision;

//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class Stack_lc_max_area_histogram {
    public int largestRectangleArea(int[] h) {
        int nsl[]= new int[h.length];//contains index of nearest small element on the left
        int nsr[]= new int[h.length];//contains index of the nearest small element on the right
        int st[]= new int[h.length];
        int top=-1;

        //filling up nsl
        for(int i=0;i<h.length;++i){
            while(top!=-1 && h[st[top]]>=h[i])
                top--;
            nsl[i]= top==-1?-1:st[top];
            st[++top]=i;
        }

        //filling up nsr
        top=-1;
        for(int i=h.length-1;i>=0;--i){
            while(top!=-1 && h[st[top]]>=h[i])
                top--;
            nsr[i]= top==-1?h.length:st[top];
            st[++top]=i;
        }

        int max=0;
        for(int i=0;i<h.length;++i){
            int a=(nsr[i]-nsl[i]-1)*h[i];
            max=Math.max(a,max);
        }
        return max;
    }
}
