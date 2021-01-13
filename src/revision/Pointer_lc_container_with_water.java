package revision;
//https://leetcode.com/problems/container-with-most-water/submissions/
public class Pointer_lc_container_with_water {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min * (r - l));
            if (min == height[l]) {
                l++;
            }
            else {
                r--;
            }
        }
        return max;
    }
}