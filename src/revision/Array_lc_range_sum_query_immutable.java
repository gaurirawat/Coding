package revision;
//https://leetcode.com/problems/range-sum-query-immutable/
public class Array_lc_range_sum_query_immutable {
    class NumArray {
        int num[];
        public NumArray(int[] nums) {
            num=nums;
            for(int i=1;i<nums.length;++i) {
                nums[i]+=nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return i==0? num[j]:(num[j]-num[i-1]);
        }
    }
}
