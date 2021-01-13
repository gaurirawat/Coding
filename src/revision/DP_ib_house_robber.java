package revision;
//https://leetcode.com/problems/house-robber/submissions/
public class DP_ib_house_robber {
    public int rob(int[] nums) {
        int inc = 0;
        int exc = 0;

        for(int x : nums) {
            int tinc = Math.max(exc + x, inc);
            int texc = Math.max(inc, exc);
            inc = tinc;
            exc = texc;
        }
        return Math.max(inc, exc);
    }
}
