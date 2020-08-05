package IB;

import java.util.*;
//https://leetcode.com/problems/longest-arithmetic-sequence/
// https://www.interviewbit.com/problems/longest-arithmetic-progression/

/*
this is the brute force solution of O(n3)
We have used this soln since the constraints are
    1 <= N <= 1000
    1 <= A[i] <= 1e9
on using proper dp soln using the array to store dp[diff][ending element index] the space complexity becomes since here
the diff can be huge too.

In leetcode the constraints are small hence the below O(n2) solution works well.
    2 <= A.length <= 2000
    0 <= A[i] <= 10000

    public int longestArithSeqLength(int[] nums) {
        if(nums.length<=2) return nums.length;
        int dp[][]=new int[2001][20001];
        int mx=0;
        for(int i=0;i<nums.length;++i){
            for(int j=i+1;j<nums.length;++j){
                int d=nums[j]-nums[i]+10000;
                dp[j][d]=Math.max(2,dp[i][d]+1);
                mx=Math.max(mx,dp[j][d]);
            }
        }
        return mx;
    }
    Look at the use of 1000 which is being added to the diff since the diff can be negative also.
 */

public class DP_ib_longest_AP {
    public int solve(final List<Integer> nums) {
        if(nums.size()<=1) return nums.size();
        int mx=1;
        HashSet<Integer> found=new HashSet<Integer>();
//        HashMap<Integer,Integer> s=new HashMap<Integer,Integer>();
//        s.entrySet().si
        for(int i=0;i<nums.size()-mx;++i){
            for(int j=i+1;j<nums.size();++j){
                int d=nums.get(j)-nums.get(i);
                if(found.contains(d))
                    continue;
                else{
                    int c=2;
                    int last=nums.get(j);
                    for(int k=j+1;k<nums.size();++k)
                        if(d==nums.get(k)-last){
                            c++;
                            last=nums.get(k);
                        }
                    mx=Math.max(mx,c);
                }
            }
        }
        return mx;
    }
}
