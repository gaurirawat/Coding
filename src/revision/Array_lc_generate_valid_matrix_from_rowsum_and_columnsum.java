package revision;
//https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
public class Array_lc_generate_valid_matrix_from_rowsum_and_columnsum {
    public int[][] restoreMatrix(int[] rs, int[] cs) {
        int a[][]=new int[rs.length][cs.length];
        for(int i=0;i<rs.length;++i){
            for(int j=0;j<cs.length;++j){
                a[i][j]=Math.min(rs[i], cs[j]);
                rs[i]-=a[i][j];
                cs[j]-=a[i][j];
            }
        }
        return a;
    }
}
