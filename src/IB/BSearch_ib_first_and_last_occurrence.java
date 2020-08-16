package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/search-for-a-range/
public class BSearch_ib_first_and_last_occurrence {
    public int[] searchRange(final int[] arr, int n) {
        int index[]=new int[2];
        Arrays.fill(index,-1);

        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==n){
                index[0]=mid;
                r=mid-1;
            }
            else if(arr[mid]<n)
                l=mid+1;
            else
                r=mid-1;
        }

        if(index[0]==-1)
            return index;

        l=0;
        r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==n){
                index[1]=mid;
                l=mid+1;
            }
            else if(arr[mid]<n)
                l=mid+1;
            else
                r=mid-1;
        }

        return index;
    }
}
