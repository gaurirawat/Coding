package revision;
//https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
public class DP_lc_no_of_subarray_with_odd_sum {
    public int numOfSubarrays(int[] arr) {
        int e=0,o=0;//no of subarrays ending with the ith element
        long c=0;
        int mod = (int)Math.pow(10, 9) + 7;
        for(int i=0;i<arr.length;++i){
            if(arr[i]%2==0)
                e=e+1;
            else{
                int temp=e;
                e=o;
                o=temp+1;
            }
            c=(c+o)%mod;
        }
        return (int)c;
    }
}
