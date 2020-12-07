package revision;
//https://leetcode.com/problems/split-array-largest-sum/
public class BSearch_lc_split_array_largest_sum {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int r=0;
        for(int x:nums) {
            r+=x;
            l=Math.max(l, x);
        }
        int minMaxSum=r;
        while(l<=r) {
            int mid=l+(r-l)/2;
            int currMaxSum=getMaxSum(mid, k, nums);
            if(currMaxSum<=mid){
                minMaxSum=Math.min(minMaxSum,currMaxSum);
                r=currMaxSum-1;
            } else{
                l=mid+1;
            }
        }
        return minMaxSum;
    }

    public int getMaxSum(int sum, int k, int[] nums) {
        int max=0;
        int csum=0;
        for(int i=0;i<nums.length;++i) {
            csum+=nums[i];
            if(csum>sum) {
                csum=nums[i];
                --k;
            }
            if(k==0||csum>sum) {
                return Integer.MAX_VALUE;
            }
            max=Math.max(max, csum);
        }
        return max;
    }
}
