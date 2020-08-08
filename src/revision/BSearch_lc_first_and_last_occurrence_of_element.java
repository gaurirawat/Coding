package revision;

import java.util.Arrays;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
public class BSearch_lc_first_and_last_occurrence_of_element {
    public int[] searchRange(int[] arr, int t) {
        int a[]=new int[2];
        Arrays.fill(a,-1);
        if(arr.length==0)return a;
        a[0]=findFirstIndex(arr,t);
        a[1]=findLastIndex(arr,t);
        return a;
    }

    public int findFirstIndex(int arr[],int t){
        int l=0,r=arr.length-1;
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==t){
                res=mid;
                r=mid-1;
            }
            else if(arr[mid]>t)
                r=mid-1;
            else
                l=mid+1;
        }
        return res;
    }

    public int findLastIndex(int arr[],int t){
        int l=0,r=arr.length-1;
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==t){
                res=mid;
                l=mid+1;
            }
            else if(arr[mid]<t)
                l=mid+1;
            else
                r=mid-1;
        }
        return res;
    }
}
