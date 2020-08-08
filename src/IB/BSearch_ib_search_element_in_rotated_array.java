package IB;
//https://www.interviewbit.com/problems/rotated-sorted-array-search/
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class BSearch_ib_search_element_in_rotated_array {
    public int search(final int[] a, int k) {
        if(a.length==0)return -1;
        int l=0,r=a.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(a[mid]>a[r])
                l=mid+1;
            else
                r=mid;
        }

        if(r==0||k<=a[a.length-1])
            return binarySearch(r,a.length-1,k,a);
        else
            return binarySearch(0,r-1,k,a);
    }

    public int binarySearch(int l, int r, int k, int[]a){
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==k){
                res=mid;
                break;
            }
            else if(a[mid]>k)
                r=mid-1;
            else
                l=mid+1;
        }
        return res;
    }
}
