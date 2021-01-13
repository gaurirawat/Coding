package revision;
//https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
public class Math_lc_trailing_zeros {
    public int trailingZeroes(int n) {
        int five = getMultiples(n, 5);
        int two = getMultiples(n, 2);
        return Math.min(five, two);
    }

    public int getMultiples(int n, int divisor) {
        int c = 0;
        int pow = divisor;
        for (int i = 1; pow <= n; ++i) {
            c += n / pow;
            pow *= divisor;
        }
        return c;
    }
}