package IB;
//https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
public class Matrix_DP_ib_max_rectangle_area_in_binary_matrix {
    public int maximalRectangle(int[][] a) {
        for(int i=0;i<a.length;++i){
            for(int j=a[0].length-2;j>=0;--j){
                if(a[i][j]==1)
                    a[i][j]=a[i][j+1]+1;
            }
        }

        int mx=0;
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a[0].length;++j){
                if(a[i][j]==0) continue;
                int min=a[i][j];
                mx=Math.max(mx,min);
                for(int k=i+1;k<a.length;++k){
                    if(a[k][j]==0) break;
                    min=Math.min(min, a[k][j]);
                    mx=Math.max(mx,min*(k-i+1));
                }
            }
        }
        return mx;
    }
}
