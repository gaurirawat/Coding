package revision;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/submissions/
/*
TC= O(xlogx) where x=no of unique elements. It will never be = nlogn even if all elements are unique since then we will
return the actual array using our if condition. hence xlogx<nlogn
 */
public class Heap_lc_top_k_frequent_items {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length){
            return nums;
        }
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;++i) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(Comparator.comparingInt(a->a[1]));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size()>k) {
                pq.poll();
            }
        }
        int[] ans=new int[k];
        int i=0;
        for(int[] x: pq) {
            ans[i++]=x[0];
        }
        return ans;
    }
}
