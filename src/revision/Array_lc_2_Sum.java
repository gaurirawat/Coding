package revision;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class Array_lc_2_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans= new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;++i) {
            if(map.get(target-nums[i])!=null) {
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
