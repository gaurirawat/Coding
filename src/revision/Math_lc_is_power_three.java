package revision;
//https://leetcode.com/problems/power-of-three/
public class Math_lc_is_power_three {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0 || n == 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
