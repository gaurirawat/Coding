package IB;
//https://www.interviewbit.com/problems/counting-subarrays/
public class Pointer_ib_counting_subarray {
    public int solve(int[] a, int target) {
        int c=0;
        for(int i=0;i<a.length;++i) {
            int sum=0;
            for(int j=i;j<a.length;++j){
                sum+=a[j];
                if(sum<target) {
                    c++;
                }
                else{
                    break;
                }
            }
        }
        return c;
    }
}