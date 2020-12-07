package IB;
//https://www.interviewbit.com/problems/xor-ing-the-subarrays/
public class BM_ib_xoring_the_subarrays {
    public int solve(int[] a) {
        int xorResult=0;
        for(int i=0; i<a.length; ++i) {
            int tempXor=0;
            for(int j=i; j<a.length; ++j){
                tempXor^=a[j];
                xorResult^=tempXor;
            }
        }
        return xorResult;
    }
}
