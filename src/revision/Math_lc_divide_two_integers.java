package revision;
//https://leetcode.com/problems/divide-two-integers/
public class Math_lc_divide_two_integers {
    public int divide(int dividendI, int divisorI) {
        boolean neg = (divisorI > 0) ^ (dividendI > 0);
        long dividend = Math.abs(dividendI + 0L);
        long divisor = Math.abs(divisorI + 0L);

        long ans = inner(dividend, divisor);
        ans = neg ? 0 - ans : ans;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        else {
            return (int)ans;
        }
    }

    public long inner(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        int i = 1;
        while(Math.pow(divisor, i + 1) <= dividend) {
            i++;
        }
        long noOfTimesDivided = (long)Math.pow(divisor, i - 1);
        return noOfTimesDivided + inner(dividend - (long)Math.pow(divisor, i), divisor);
    }
}