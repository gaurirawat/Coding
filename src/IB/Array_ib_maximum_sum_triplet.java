package IB;

import java.util.TreeSet;
//https://www.interviewbit.com/problems/maximum-sum-triplet/
public class Array_ib_maximum_sum_triplet {
    public int solve(int[] arr) {
        TreeSet<Integer> elemSoFar =new TreeSet<Integer>();
        int sum[]=new int[arr.length];
        for(int i=0;i<arr.length;++i){
            Integer smallerElem=elemSoFar.lower(arr[i]);
            if(smallerElem!=null)
                sum[i]=arr[i]+smallerElem;
            elemSoFar.add(arr[i]);
        }
        int ans=0;
        int maxElemSoFar=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;--i){
            if(maxElemSoFar>arr[i]){
                if(sum[i]!=0)
                    ans=Math.max(ans, sum[i]+maxElemSoFar);
            }
            else
                maxElemSoFar=arr[i];
        }
        return ans;
    }
}