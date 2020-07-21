package revision;

import java.util.Arrays;

//https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/

//wrong approach
public class Array_ib_Triplets_with_Sum_between_given_range {
    public int solve(String[] a) {
        double arr[]= new double[a.length];
        for(int i=0;i<a.length;++i){
            arr[i]=Double.parseDouble(a[i]);
        }

        Arrays.sort(arr);
        for(int i=0;i<a.length;++i){
            if(arr[i]<2){
                boolean res=twoPointer(arr,i);
                if(res)
                    return 1;
            }
        }
        return 0;
    }

    public boolean twoPointer(double a[], int i){
        int l=i==0?1:0;
        int r=i==a.length-1?a.length-2:a.length-1;
        while(l<r){
            if((a[l]+a[r])<(2-a[i]) && (a[l]+a[r])>(1-a[i]))
                return true;
            else if(a[l]>(2-a[i]))
                return false;
            else if((a[l]+a[r])>=(2-a[i]))
                --r;
            else
                ++l;
            if(l==i)
                ++l;
            if(r==i)
                --r;
        }
        return false;
    }

}
