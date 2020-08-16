package revision;
//https://leetcode.com/problems/kth-missing-positive-number/
public class Array_lc_kth_missing_positive_number {
    public int findKthPositive(int[] arr, int k) {
        int n=1;
        for(int i=0;i<arr.length;++i){
            while(arr[i]!=n){
                k--;
                if(k==0)
                    return n;
                ++n;
            }
            ++n;
        }
        return n+(k-1);
    }
}
