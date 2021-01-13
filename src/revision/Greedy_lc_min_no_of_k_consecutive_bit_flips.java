package revision;

//https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/submissions/
public class Greedy_lc_min_no_of_k_consecutive_bit_flips {
    public int minKBitFlips(int[] nums, int k) {
        int valid = 1;
        boolean[] flipIndex = new boolean[nums.length + 1];
        int flips = 0;

        for(int i = 0; i < nums.length; ++i) {
            if (flipIndex[i]) {
                valid = valid ^ 1;
            }
            if ((valid ^ nums[i]) != 0) {
                valid = valid ^ 1;
                flips++;

                if (i + k <= nums.length) {
                    flipIndex[i + k] = true;
                } else {
                    return -1;
                }
            }
        }
        return flips;
    }
}
