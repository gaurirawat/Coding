package revision;
// https://leetcode.com/problems/majority-element/
public class Array_lc_majority_element {
	 public int majorityElement(int[] nums) {
        int c=0;
        int element=nums[0];
        for(int x:nums){
        	if(x==element)
        		c++;
        	else{
        		c--;
        		if(c<0){
        			element=x;
        			c=0;
        		}
        	}
        }
        c=0;
        for(int x:nums){
        	if(element==x)
        		c++;
        }
        if(c>nums.length/2)
        	return element;
        return -1;
    }
}
