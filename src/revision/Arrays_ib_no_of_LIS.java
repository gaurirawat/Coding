package revision;

import java.util.Arrays;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/333243/Java-or-Time-and-Memory-beats-100-or-DP
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/submissions/
public class Arrays_ib_no_of_LIS {
    public int findNumberOfLIS(int[] nums) {
        int[] len= new int[nums.length];
        int[] count= new int[nums.length];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;++i) {
            for(int j=0;j<i;++j) {
                if(nums[i]>nums[j]) {
                    if(len[i]<len[j]+1) {
                        len[i]=len[j]+1;
                        count[i]=count[j];
                    } else if(len[i]==len[j]+1) {
                        count[i]+=count[j];
                    }
                }
            }
            if(max<len[i]) {
                max=len[i];
                sum=count[i];
            } else if(max==len[i]) {
                sum+=count[i];
            }
        }
        return sum;
    }
}
