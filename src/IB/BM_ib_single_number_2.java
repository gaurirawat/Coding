package IB;

import java.util.List;
//https://www.interviewbit.com/problems/single-number-ii/
public class BM_ib_single_number_2 {
    public int singleNumber(final int[] nums) {
        int ones[] = new int[32];
        for (int x: nums) {
            for (int i=0; i<32; ++i) {
                boolean one = (((x>>i) & 1) == 1);
                if (one) {
                    ones[i]++;
                }
            }
        }
        int singleNumber = 0;
        for (int i = 0 ; i < 32; ++i) {
            if (ones[i] % 3 != 0) {
                singleNumber += (1<<i);
            }
        }
        return singleNumber;
    }
}