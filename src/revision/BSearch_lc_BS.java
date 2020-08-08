package revision;
//https://leetcode.com/problems/binary-search/submissions/
public class BSearch_lc_BS {
	public int search(int[] nums, int target) {
        int l=0; int r=nums.length-1;        
        while(l<r){
            int mid=l+ (r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid;
        }
        if(nums[l]==target)
            return l;
        else return -1;
    }
}
	        
/*
    public int search(int[] arr, int t) {
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(t==arr[mid])
                return mid;
            else if(t>arr[mid])
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
 */
