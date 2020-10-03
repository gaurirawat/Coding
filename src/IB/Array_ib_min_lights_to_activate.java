package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
public class Array_ib_min_lights_to_activate {
    public int solve(ArrayList<Integer> a, int k) {
        return innerSolve(a,k,0);
    }

    public int innerSolve(ArrayList<Integer> a, int k, int i){
        if(i>=a.size())
            return 0;
        boolean found=false;
        int j=k-1;
        for(j=k-1;j>=-(k-1);--j){
            if((i+j)<0 || (i+j)>=a.size())
                continue;
            if(a.get(i+j)==1){
                found=true;
                break;
            }
        }
        if(!found)
            return -1;

        int val=innerSolve(a,k,i+j+k);
        if(val==-1)
            return -1;
        else
            return 1+val;
    }
}