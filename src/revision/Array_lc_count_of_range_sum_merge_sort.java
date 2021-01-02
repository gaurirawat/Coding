package revision;

import java.util.Arrays;

//https://leetcode.com/problems/count-of-range-sum/submissions/
public class Array_lc_count_of_range_sum_merge_sort {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length==0) {
            return 0;
        }
        long[] sums=new long[nums.length];
        sums[0]=nums[0];
        for(int i=1; i<nums.length; ++i) {
            sums[i]+=sums[i-1]+ nums[i];
        }
        return mergeSortCount(sums, 0, nums.length-1, lower, upper) ;
    }

    public int mergeSortCount(long[] nums, int l, int r , int lower, int upper) {
        if(l==r) {
            return lower<=nums[l] && nums[l]<=upper? 1 : 0;
        }
        int mid= l+(r-l)/2;
        return mergeSortCount(nums, l, mid, lower, upper)+
                mergeSortCount(nums, mid+1, r, lower, upper)+
                merge(nums, l, r, mid, lower, upper);
    }

    public int merge(long[] nums, int l, int r, int mid, int lower, int upper) {
        long result[]=new long[r-l+1];
        int c=0;
        int lpos= mid+1, rpos= mid+1;
        for(int i=l; i<=mid; ++i) {
            while(lpos<=r && nums[lpos]-nums[i]<lower){
                ++lpos;
            }
            while(rpos<=r && nums[rpos]-nums[i]<=upper) {
                ++rpos;
            }
            c+=(rpos-lpos);
        }

        // replace below sort by regular array merge of O(n).
        Arrays.sort(nums, l, r+1);
        return c;
    }
}
