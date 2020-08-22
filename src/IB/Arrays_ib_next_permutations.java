package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/next-permutation/
//https://leetcode.com/problems/next-permutation/submissions/

/*
simple logic:
1. start traversing from the end and look for the first element e which is smaller than the one that is after it.
2. If there is no such element then sort the array and return the result
3. Otherwise traverse again from the end to find the smallest element that is greater than e.\
4. swap e with this element. Sort all elements after the old pos of e.
 */
public class Arrays_ib_next_permutations {
    public int[] nextPermutation(int[] nums) {
        if(nums.length<=1) return nums;
        int i;
        for(i=nums.length-2;i>=0;--i)
            if(nums[i]<nums[i+1])
                break;

        if(i==-1)
            Arrays.sort(nums);
        else{
            int t=nums[i];
            int j;
            for(j=nums.length-1;j>i;--j)
                if(nums[j]>nums[i])
                    break;
            nums[i]=nums[j];
            nums[j]=t;
            Arrays.sort(nums,i+1,nums.length);
        }
        return nums;
    }
}
