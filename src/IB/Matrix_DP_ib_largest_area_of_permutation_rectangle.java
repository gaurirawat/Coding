package IB;

import java.util.*;

//https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/
public class Matrix_DP_ib_largest_area_of_permutation_rectangle {
    public int solve(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        for(int i=1; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(a[i][j]==1) {
                    a[i][j]+= a[i-1][j];
                }
            }
        }

        int max=0;
        for(int i=0; i<m; ++i) {
            Integer[] temp = new Integer[n];
            for(int j=0; j<n; ++j) {
                temp[j]= a[i][j];
            }

            max= Math.max(max, findMaxArea(temp));
        }
        return max;
    }

    public int findMaxArea(Integer[] nums){
        Arrays.sort(nums, Collections.reverseOrder());
        int max=0;
        for(int i=0; i<nums.length; ++i) {
            max= Math.max(max, (i+1)*nums[i]);
            if(nums[i] == 0) {
                break;
            }
        }
        return max;
    }
}
