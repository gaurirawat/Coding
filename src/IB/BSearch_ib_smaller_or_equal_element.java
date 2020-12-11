package IB;
//https://www.interviewbit.com/problems/smaller-or-equal-elements/
public class BSearch_ib_smaller_or_equal_element {
    public int solve(int[] a, int k) {
        int l=0;
        int h=a.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]<=k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l;
    }
}
