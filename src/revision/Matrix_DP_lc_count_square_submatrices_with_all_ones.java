package revision;
//https://www.youtube.com/watch?v=aYnEO53H4lw
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/
public class Matrix_DP_lc_count_square_submatrices_with_all_ones {
    public int countSquares(int[][] m) {
        int dp[][]= new int[m.length][m[0].length];
        int sum=0;
        for(int i=0;i<m.length;++i){
            for(int j=0;j<m[0].length;++j){
                if(i==0||j==0)
                    dp[i][j]=m[i][j];
                else if(m[i][j]==1)
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]))+1;
                else
                    dp[i][j]=0;
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}
