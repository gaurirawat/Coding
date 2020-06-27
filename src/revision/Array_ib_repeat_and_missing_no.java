package revision;
import java.util.*;
//https://www.interviewbit.com/problems/repeat-and-missing-number-array/	
public class Array_ib_repeat_and_missing_no {
	public int[] repeatedNumber(final int[] A) {
        int ans[]= new int[2];
        int a[]= Arrays.copyOf(A, A.length);
        for(int i=0; i< a.length; ++i){
            if(a[Math.abs(a[i])-1]<0)
                ans[0]=Math.abs(a[i]);
            else
                a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
        }
        for(int i=0; i< a.length; ++i){
            if(a[i]>0)
                ans[1]=i+1;
        }
        return ans;
    }
}
