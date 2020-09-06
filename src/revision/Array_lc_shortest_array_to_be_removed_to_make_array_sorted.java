package revision;
//https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/submissions/
public class Array_lc_shortest_array_to_be_removed_to_make_array_sorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length<=1) return 0;
        int l=0;
        for(int i=1;i<arr.length;++i)
            if(arr[i]<arr[i-1]){
                l=i;
                break;
            }
        if(l==0) return 0;

        int r=arr.length;
        for(int i=arr.length-2;i>=0;--i){
            if(arr[i]>arr[i+1]){
                r=i;
                break;
            }
        }
        if(r==arr.length-2 && l==1 && arr[0]>arr[arr.length-1])
            return arr.length-1;
        return getMinLen(l,r, arr);
    }

    public int getMinLen(int l, int r, int arr[]){
        if(l==0) return r+1;
        else if(r==arr.length-1) return arr.length-l;
        int x=0;
        if(arr[l-1]<=arr[r+1])
            x=r-l+1;
        else
            x=Math.min(getMinLen(l-1,r,arr),getMinLen(l,r+1,arr));
        return x;
    }
}
