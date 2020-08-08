package IB;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
//https://www.interviewbit.com/problems/rotated-array/

public class BSearch_ib_find_min_in_rotated_array {
    public int findMin(int[] nums) {
        if(nums.length<1)return 0;
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r])
                l=mid+1;
            else
                r=mid;
        }
        return nums[r];
    }
}
