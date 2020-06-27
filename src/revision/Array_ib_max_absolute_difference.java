package revision;
//https://www.interviewbit.com/problems/maximum-absolute-difference/

//concept clarity: https://www.geeksforgeeks.org/maximum-absolute-difference-value-index-sums/
public class Array_ib_max_absolute_difference {
	 public int maxArr(int[] a) {
	        int pmx=Integer.MIN_VALUE;//max a[i]+i plus-max 
	        int mmx=Integer.MIN_VALUE;//max a[j]-j minus-max 
	        int pmn=Integer.MAX_VALUE;//min a[i]+i plus-min 
	        int mmn=Integer.MAX_VALUE;//min a[j]-j min
	        
	        for(int i=0 ;i< a.length; ++i){
	            pmx=Math.max(pmx, a[i]+i);
	            mmx=Math.max(mmx, a[i]-i);
	            pmn=Math.min(pmn, a[i]+i);
	            mmn=Math.min(mmn, a[i]-i);        
	        }
	        
	        return Math.max((pmx-pmn),(mmx-mmn));
	    }
}
