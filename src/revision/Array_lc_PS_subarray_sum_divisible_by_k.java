package revision;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/
/*
explanation:
https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
so for the array based one.
*/
public class Array_lc_PS_subarray_sum_divisible_by_k {
	public int subarraysDivByK(int[] A, int k) {
		int arr[]= new int[k];
	    arr[0]=1;
	    int count=0,sum=0; 
	    for(int a:A){
	        sum= (sum+a)%k;
	        if(sum<0)
	            sum+=k;
	        count+= arr[sum];
	        arr[sum]++;
	     }
	    return count;
	}
}
