package revision;

import java.util.Arrays;

//https://leetcode.com/problems/count-of-range-sum/submissions/
public class    Array_lc_count_of_range_sum_merge_sort {
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

    /* same approach with merge instead of sort
    public int innerCountRangeMerge(long[]nums, int l, int r, int mid, int lower, int upper) {
        int a = mid + 1;
        int b = mid + 1;
        int count = 0;
        for (int i = l; i <= mid; ++i) {
            while (a <= r && nums[a] - nums[i] < lower) {
                ++a;
            }
            while (b <= r && nums[b] - nums[i] <= upper) {
                ++b;
            }
            count += b - a ;
        }

        long[] result = new long[r - l + 1];
        a = l;
        b = mid + 1;
        int c = 0;
        while (a <= mid && b <= r) {
            if (nums[a] < nums[b]) {
                result[c++] = nums[a++];
            } else {
                result[c++] = nums[b++];
            }
        }
        while(a <= mid) {
           result[c++] = nums[a++];
        }
        while(b <= r) {
           result[c++] = nums[b++];
        }

        for (int i = 0; i < result.length; ++i) {
            nums[l + i] = result[i];
        }
        return count;
    }
     */
}
