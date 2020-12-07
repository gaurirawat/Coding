package revision;
//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class Array_lc_range_sum_query_2D_immutable {
    int[][] m;
    public Array_lc_range_sum_query_2D_immutable(int[][] matrix) {
        m=matrix;
        for(int i=0;i<m.length;++i) {
            int sum=0;
            for(int j=0;j<m[0].length;++j) {
                sum+=m[i][j];
                m[i][j]=sum+ (i==0?0:m[i-1][j]);

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top=(row1==0?0:m[row1-1][col2]);
        int left=(col1==0?0:m[row2][col1-1]);
        int repeat=(col1==0||row1==0)?0:m[row1-1][col1-1];
        return m[row2][col2]-top-left+repeat;
    }
}
