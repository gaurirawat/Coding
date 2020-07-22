package revision;

import java.util.Arrays;

//https://www.interviewbit.com/problems/highest-product/
public class Greedy_ib_highest_product {
    public int maxp3(int[] a) {
        Arrays.sort(a);
        if(a.length==1) return a[0]*a[0]*a[0];
        else if(a.length==2) return a[0]*a[1]*a[1];
        int x=a[a.length-1]*a[a.length-2]*a[a.length-3];
        int y=a[a.length-1]*a[0]*a[1];
        return x>y?x:y;
    }

}
