package revision;
//https://leetcode.com/problems/climbing-stairs/submissions/
public class DP_lc_climb_stairs {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; ++i) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}
