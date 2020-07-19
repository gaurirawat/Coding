package revision;
//https://www.youtube.com/watch?v=g8bSdXCG-lA&t=54s
//https://leetcode.com/problems/maximal-rectangle/
public class Matrix_Stack_lc_max_sum_rectangle_given_binary_matrix {
    public int maximalRectangle(char[][] m) {
        if(m.length==0) return 0;
        int arr[]=new int[m[0].length];
        int max=0;
        for(int i=0;i<m.length;++i){
            for(int j=0;j<m[0].length;++j)
                arr[j]=m[i][j]=='1'?arr[j]+1:0;
            max= Math.max(max, maximumAreaHistogram(arr));
        }
        return max;
    }

    public int maximumAreaHistogram(int h[]){
        int nsl[]=new int[h.length];
        int nsr[]=new int[h.length];
        int st[]=new int[h.length];

        int top=-1;
        for(int i=0;i<h.length;++i){
            while(top!=-1 && h[st[top]]>=h[i])
                top--;
            nsl[i]=top==-1?-1:st[top];
            st[++top]=i;
        }

        top=-1;
        for(int i=h.length-1;i>=0;--i){
            while(top!=-1 && h[st[top]]>=h[i])
                top--;
            nsr[i]=top==-1?h.length:st[top];
            st[++top]=i;
        }

        int max=0;
        for(int i=0;i<h.length;++i){
            max=Math.max(max, (nsr[i]-nsl[i]-1)*h[i]);
        }
        return max;
    }

}
