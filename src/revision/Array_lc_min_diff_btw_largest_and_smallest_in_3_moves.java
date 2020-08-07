package revision;
//https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
import java.util.Arrays;

public class Array_lc_min_diff_btw_largest_and_smallest_in_3_moves {
    public int minDifference(int[] nums) {
        if(nums.length<=3)return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int l=0,r=nums.length-3-1;r<nums.length;++l,++r){
            min=Math.min(min,nums[r]-nums[l]);
        }
        return min;
    }
}
