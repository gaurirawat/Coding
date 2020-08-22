package IB;

// https://www.interviewbit.com/problems/number-of-1-bits/

public class BM_ib_no_of_1_bits {
    public int numSetBits(long a) {
        int c=0;
        while(a!=0){
            c++;
            a=a&(a-1);
        }
        return c;
    }
}
