package revision;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
//https://www.interviewbit.com/problems/rotated-array/
public class BSearch_lc_minimum_in_rotated_array {
	 public int findMin(int[] a) {
	        // System.out.println(Arrays.toString(a));
	        int l=0, r=a.length-1;
	        while(l<r){
	            int mid=l+(r-l)/2;
	            if(a[mid]>a[r])
	                l=mid+1;
	            else
	                r=mid;
	        }
	        return a[r];
	    }
}
