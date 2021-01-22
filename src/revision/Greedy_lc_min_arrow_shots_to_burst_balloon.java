package revision;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class Greedy_lc_min_arrow_shots_to_burst_balloon {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int intervalI = points[0][0];
        int intervalJ = points[0][1];
        int arrow = 1;

        for (int i = 1; i < points.length; ++i) {
            int beg = points[i][0];
            int end = points[i][1];
            if (intervalJ < beg) {
                ++arrow;
                intervalI = beg;
                intervalJ = end;
            } else {
                if (intervalI < beg) {
                    intervalI = beg;
                }
                if (intervalJ > end) {
                    intervalJ = end;
                }
            }
        }
        return arrow;
    }
}
