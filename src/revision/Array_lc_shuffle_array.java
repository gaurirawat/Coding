package revision;
//https://leetcode.com/problems/shuffle-an-array/submissions/
import java.util.*;
public class Array_lc_shuffle_array {
    class Solution{
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffleArray = new int[nums.length];
            Random random = new Random();
            for (int i = 0; i < nums.length; ++i) {
                shuffleArray[i] = nums[i];
                int index = random.nextInt(i+1);
                int t = shuffleArray[i];
                shuffleArray[i] = shuffleArray[index];
                shuffleArray[index] = t;
            }
            return shuffleArray;
        }
    }
}
