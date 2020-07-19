package revision;
//https://leetcode.com/problems/count-submatrices-with-all-ones/submissions/
//brute force: https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/721266/C%2B%2B-Understand-the-brute-force-solution-first!

/*
First understand brute force.
Now pre-compute the length of continuous ones for each cell.
We iterate through each cell and find all sub-matrices that can be made by keeping that cell as the top-left point.
If for particular cell[1][5] the precomputed[5] column has values= {3,4,5,2,4,0,5} as the remaining column then the no
of sub-matrices that can be made by keeping cell[1][5] as the top-left point are=
4(leave out 3 since cell is at row0.Now 4 mat can be formed of size 1*1,1*2,1*3,1*4)
+4 (4 mat can be formed of size 2*1,2*2,2*3,2*4)
+2 (min of (4,2) is taken. so 2 mat can be formed of size 3*1,3*2)
+2
+0 (we stop here since no matrix can be formed now)
 */

import java.util.Map;
import java.util.PriorityQueue;

public class Matrix_DP_lc_count_all_submatrices_with_ones {

    public int numSubmat(int[][] m) {
        int cnt[][]=new int[m.length][m[0].length];
        //contains length of continuous ones starting from cell i. (type pf prefix sum)
        for(int i=0;i<m.length;++i){
            int c=0;
            for(int j=m[0].length-1;j>=0;--j){
                if(m[i][j]==1)
                    cnt[i][j]=++c;
                else
                    c=0;
            }
        }

        int sum=0;
        for(int i=0;i<m.length;++i){
            for(int j=0;j<m[0].length;++j){
                if(m[i][j]==1)
                    sum+=submarticesWithCurrentCellAsTopLeftCell(cnt,i,j);
            }
        }
        return sum;
    }

    public int submarticesWithCurrentCellAsTopLeftCell(int cnt[][],int x,int y){
        int sum=cnt[x][y];
        int mxWidth=cnt[x][y];
        for(int i=x+1;i<cnt.length;++i){
            if(cnt[i][y]==0)
                break;
            else{
                mxWidth=Math.min(mxWidth,cnt[i][y]);
                sum+=mxWidth;
            }
        }
        return sum;
    }

}
