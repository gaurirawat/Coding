package IB;

import java.util.HashMap;

//https://www.interviewbit.com/problems/subarray-with-equal-occurences/
public class Hashing_ib_subarray_with_equal_occurrences {
    public int solve(int[] arr, int a, int b) {
        int aCount=0, bCount=0;
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        map.put(aCount-bCount,1);
        int c=0;
        for(int i=0;i<arr.length;++i){
            aCount+= arr[i]==a?1:0;
            bCount+= arr[i]==b?1:0;
            int t=map.getOrDefault(aCount-bCount,0);
            c+=t;
            map.put(aCount-bCount, t+1);
        }
        return c;
    }
}
