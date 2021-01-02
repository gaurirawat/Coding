package revision;
//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/submissions/
public class Array_lc_sum_of_absolute_difference {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        if(nums.length==0) {
            return nums;
        }
        int[] psum=new int[nums.length];
        psum[0] = nums[0];
        for(int i=1; i<nums.length; ++i) {
            psum[i]=psum[i-1]+nums[i];
        }
        int[] answer=new int[nums.length];
        for(int i=0; i<nums.length; ++i ) {
            int right = psum[nums.length-1]-psum[i];
            int left = i==0? 0 : psum[i-1];
            int cr = nums.length-i-1;
            int cl = i;
            answer[i] = right-(nums[i]*cr) + (nums[i]*cl - left);
        }
        return answer;
    }
}
