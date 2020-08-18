package revision;
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
public class Array_lc_longest_subarray_of_ones_after_deleting_one_element {
    public int longestSubarray(int[] nums) {
        if(nums.length==0)return 0;
        int l=0,r=0;

        boolean flag=true;
        while(r<nums.length && ((nums[r]==1)||(flag && nums[r]==0))){
            if(nums[r]==0) flag=false;
            ++r;
        }
        if(r==nums.length) return nums.length-1;

        int max=r-l-1;

        while(r<nums.length){
            r++;
            while(nums[l]==1 &&l<r) l++;
            l++;
            while(r<nums.length && nums[r]==1) r++;
            max=Math.max(max, r-l-1);
        }
        return max;
    }
}
