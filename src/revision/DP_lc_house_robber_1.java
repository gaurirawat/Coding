package revision;
//https://leetcode.com/problems/house-robber/submissions/
public class DP_lc_house_robber_1 {
    public int rob(int[] nums) {
        int inc = 0;
        int exc = 0;
        for(int x : nums) {
            int nInc = Math.max(inc, x + exc);
            int nExc = Math.max(inc, exc);
            inc = nInc;
            exc = nExc;
        }
        return Math.max(inc, exc);
    }
}
