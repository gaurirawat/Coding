package IB;

import java.util.*;

/*
This problem can be taken as the problem of dividing the array into k partitions such that the max sum of each partition
is minimized.
 */
//https://www.interviewbit.com/problems/painters-partition-problem/
public class BSearch_ib_painters_partition_problem {
    public int paint(int k, int time, ArrayList<Integer> fence) {
        if ( k >= fence.size() ) {
            return Collections.max(fence) * time;
        }

        int l = Collections.max(fence);
        int r = 0;
        for (int x: fence) {
            r+= x;
        }

        int blocks = Integer.MAX_VALUE;
        while (l<=r) {
            int mid = l +(r -l) / 2;
            int currBlocks = getMaxBlocks(k, mid, fence);
            if (currBlocks < blocks) {
                blocks = currBlocks;
                r = blocks - 1;
            }
            else {
                l = mid + 1;
            }
        }

        int mod = (int)Math.pow(10,7) + 3;
        long cost = (blocks * 1L * time) % mod;
        return (int)cost;
    }

    public int getMaxBlocks(int k, int mid, ArrayList<Integer> fence) {
        int currBlocks = 0;
        int maxBlocks = 0;
        for (int i = 0; i<fence.size(); ++i) {
            currBlocks += fence.get(i);
            if (currBlocks > mid) {
                currBlocks = fence.get(i);
                --k;
                if (k == 0) {
                    return Integer.MAX_VALUE;
                }
            }
            maxBlocks = Math.max(maxBlocks, currBlocks);
        }
        return maxBlocks;
    }
}
