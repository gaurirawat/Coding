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
	        
//while(l<=r){
//    int mid=l+ (r-l)/2; //important otherwise will go in overflow of int.
//    if(nums[mid]==target)
//        return mid;
//    if(target< nums[mid])
//        r=mid-1;
//    else
//        l=mid+1;
//}
//return -1;
