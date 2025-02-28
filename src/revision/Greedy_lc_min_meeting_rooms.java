package revision;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms-ii/submissions/
public class Greedy_lc_min_meeting_rooms {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int maxRequirement = 0;
        int occupiedRooms = 0;

        int i = 0;
        int j = 0;

        while (i < start.length) {
            if (start[i] == end[j]) {
                i++;
                j++;
            } else if (start[i] < end[j]) {
                occupiedRooms++;
                i++;
            } else {
                occupiedRooms--;
                j++;
            }

            if (occupiedRooms > maxRequirement) {
                maxRequirement = occupiedRooms;
            }
        }

        return maxRequirement;
    }
}
