package revision;
//https://leetcode.com/problems/sqrtx/submissions/
public class BSearch_lc_sqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int r = x;
        int sqrt = 1;
        while (l<=r) {
            int mid = l + (r - l) / 2;
            if (mid * 1L* mid <= x) {
                sqrt = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return sqrt;
    }
}
