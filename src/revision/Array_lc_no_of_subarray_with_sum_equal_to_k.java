package revision;

import java.util.HashMap;
//https://leetcode.com/problems/subarray-sum-equals-k/submissions/
//Ref:
//https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
/*
Algo:
Iterate over the array and keep cumulating the sum(ie form the very first element).
Now if we aim to find subarray with sum=k,(eg k=10) then there can be two possibilities
1. the cumulative sum can be =k;
2. the cumulative sum is greater than k with difference, diff=sum-k. but we may have encountered that as a sum before.
eg at index 3(initial 0->3 ie 4 elements) sum=5, at some greater index 8(sum of initial 0->8 ie 9 elements) we get
sum=15. so now we have a subarray from index 4->8 with sum=10;
We create a hashmap where <k,v>=<sum, no of arrays possible for given sum starting from first element>
keep adding every time the sum=k or (sum-k) was present before.

 */
public class Array_lc_no_of_subarray_with_sum_equal_to_k {
    public int subarraySum(int[] nums, int k) {
        int cnt =0;
        HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
        int sum=0;
        for(int x:nums){
            // Add current element to sum so far.
            sum+=x;
            if(sum==k) cnt++;
            if(map.get(sum-k)!=null) cnt+=map.get(sum-k);
            if(map.get(sum)==null)
                map.put(sum,1);
            else
                map.put(sum,map.get(sum)+1);
        }
        return cnt;
    }
}
