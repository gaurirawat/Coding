package revision;

import java.util.*;
//https://leetcode.com/problems/random-pick-with-weight/
public class Implementation_lc_random_number_generator_with_probability {
    class Solution {
        int[] cumFreq;
        int[] w;
        Random random;
        public Solution(int[] w) {
            this.w = w;
            cumFreq = new int[w.length];
            for (int i = 0; i < w.length; ++i) {
                cumFreq[i] = (i == 0 ? 0 : cumFreq[i - 1]) + w[i];
            }
            random = new Random();
        }

        public int pickIndex() {
            int freq = random.nextInt(cumFreq[cumFreq.length - 1]);
            freq++; // to make it one based
            int pos = Arrays.binarySearch(cumFreq, freq);
            if (pos < 0) {
                pos = Math.abs(pos + 1);
            }
            return pos;
        }
    }

}
