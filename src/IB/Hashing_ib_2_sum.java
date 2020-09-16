package IB;

import java.util.HashMap;

//https://www.interviewbit.com/problems/2-sum/
public class Hashing_ib_2_sum {
    public int[] twoSum(final int[] a, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<a.length;++i){
            if(map.get(target-a[i])!=null){
                int ans[]=new int[2];
                ans[0]=map.get(target-a[i])+1;
                ans[1]=i+1;
                return ans;
            }
            if(map.get(a[i])==null)
                map.put(a[i],i);
        }
        int ans[]=new int[0];
        return ans;
    }
}
