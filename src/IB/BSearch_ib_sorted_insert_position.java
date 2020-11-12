package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/sorted-insert-position/
public class BSearch_ib_sorted_insert_position {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int index=0;
        int l=0,r=a.size()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a.get(mid)>=b){
                index=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return l;
    }
}

/*
    while(l<=r){
        int mid=l+(r-l)/2;
        if(a.get(mid)>=b){
            index=mid;
            r=mid-1;
        }
        else
            l=mid+1;
    }
    return index;

    OR

    while(l<r){
        int mid=l+(r-l)/2;
        if(a.get(mid)>=b){
            r=mid;
        }
        else
            l=mid+1;
    }
    if(a.get(l)<b) return l+1;
    return l;
 */