package IB;
//https://www.interviewbit.com/problems/search-in-bitonic-array/
public class BSearch_ib_search_in_bitonic_array {
    public int solve(int[] a, int target) {
        int index=findBitonicIndex(a);
        int ans=searchInc(a, target, index);
        if(ans==-1) {
            ans=searchDec(a, target, index);
        }
        return ans;
    }

    public int searchInc(int[] a, int target, int index){
        int l=0;
        int r=index;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==target){
                return mid;
            }
            if(a[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    public int searchDec(int[] a, int target, int index){
        int l=index+1;
        int r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==target){
                return mid;
            }
            if(a[mid]>target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    public int findBitonicIndex(int[] a) {
        int l=0;
        int r=a.length-1;
        int index=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((mid==0||a[mid-1]<a[mid])){
                index=mid;
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        return index;
    }
}