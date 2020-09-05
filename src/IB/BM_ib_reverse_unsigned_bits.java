package IB;
//https://www.interviewbit.com/problems/reverse-bits/
public class BM_ib_reverse_unsigned_bits {
    public long reverse(long a) {
        long b=0;
        for(int i=0;i<32;++i){
            int dig=(int)(a&1);
            a=a>>1;
            b=(b<<1)+dig;
        }

        return b;
    }
}
