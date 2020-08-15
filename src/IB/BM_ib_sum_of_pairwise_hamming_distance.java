package IB;

import java.util.List;
//https://www.interviewbit.com/courses/programming/topics/math/
/*
the problem we were facing here was that our c could be as long as 10^7 and then on multiplying it with the no of zeros
the overall sum was exceeding integer limit hence wrong answer.
 */
public class BM_ib_sum_of_pairwise_hamming_distance {
    public int hammingDistance(final List<Integer> a) {
        int sum=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<32;++i){
            long c=0;
            for(int j=0;j<a.size();++j)
                c+= (a.get(j)>>i)&1;
            sum+=(c*(a.size()-c)*2)%mod;
            sum%=mod;
        }
        return sum;
    }
}
