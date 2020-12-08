package IB;

import java.util.HashMap;

//https://www.interviewbit.com/problems/longest-subarray-length/
public class Hashing_ib_longest_subarray_length {
    public int solve(int[] a) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0,-1);
        int maxLen=0;
        int sum=0;
        for(int i=0;i<a.length;++i){
            sum+=a[i]==0?-1:1;
            if(map.get(sum-1)!=null){
                maxLen=Math.max(maxLen, i-map.get(sum-1));
            }
            if(map.get(sum)==null){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
