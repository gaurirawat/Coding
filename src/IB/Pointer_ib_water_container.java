package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/container-with-most-water/
public class Pointer_ib_water_container {
    public int maxArea(ArrayList<Integer> a) {
        int l=0,r=a.size()-1;
        int sum=0;
        while(l<r){
            int minHt=Math.min(a.get(l),a.get(r));
            sum=Math.max(sum, minHt*(r-l));
            if(minHt==a.get(l))
                l++;
            else
                r--;
        }
        return sum;
    }
}
