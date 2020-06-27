package revision;

//https://leetcode.com/problems/power-of-two/
public class Backtracking_lc_power_of_two {	
	  public boolean isPowerOfTwo(int n) {
	        if(n==1)
	            return true;
	        if(n%2!=0 || n<=0)
	            return false;
	        else
	            return isPowerOfTwo(n/2);
	    }
}
