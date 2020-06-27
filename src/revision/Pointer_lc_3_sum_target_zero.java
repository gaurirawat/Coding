package revision;
//https://leetcode.com/problems/3sum/submissions/
/* this fuckall thing won't work on ib. Has issues with java min and max values*/
import java.util.*;
public class Pointer_lc_3_sum_target_zero {
	public List<List<Integer>> threeSum(int[] a) {
        ArrayList<List<Integer>> ls= new ArrayList<List<Integer>>();
        int c=0;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for(int i=0; i<a.length-1; ++i){
            while(i!=0 && i<a.length-1 && a[i]==a[i-1])++i;
            if(i==a.length-1)
                break;
            int l=i+1, r=a.length-1;
            long sum=(0-a[i]);
            while(l<r){
                long temp=(a[l]+a[r]);
                if(temp==sum){
                List<Integer> lst= new ArrayList<Integer>();
                    lst.add(a[i]);
                    lst.add(a[l]);
                    lst.add(a[r]);
                    ls.add(lst);
                    while(l<r && a[l]==a[l+1])++l;
                    while(l<r && a[r]== a[r-1])--r;
                    ++l; 
                    --r;
                }
                else if((a[l]+a[r])<sum)
                    l++;
                else 
                    r--;
            }
        }
        return ls;
    }

}
