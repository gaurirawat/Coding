package revision;
import java.util.*;
//https://www.interviewbit.com/problems/3-sum/
/*concept:
 * for condition: a+b+c=0;
 * we put sum as -c and then use two pointer method to find if condition is true anywhere.
 * For target ie. a+b+c=target, put sum as target-c and then use two pointer to calculate if for any 
 * a+b, we get the sum as target-c;
 */
public class Pointer_ib_3_sum_target_k {
	public int threeSumClosest(int[] a, int b) {
        Arrays.sort(a);
        int ans=a[0]+a[1]+a[2];
        outer: for (int i=0; i<a.length-1; ++i){
            int sum=b-a[i];
            int l=i+1, r=a.length-1;
            while(l<r){
                int tsum=a[l]+a[r]-sum;
                if(tsum!=Integer.MIN_VALUE&& Math.abs(tsum)<=Math.abs(ans-b)){
                    ans=a[l]+a[r]+a[i];
                    if(ans==b)
                        break outer;
                }
                if(tsum>0)
                    --r;
                else
                    ++l;
            }
        }
        return ans;
    }
}
