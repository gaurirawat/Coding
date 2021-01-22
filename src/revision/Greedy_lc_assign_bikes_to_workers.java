package revision;

import java.util.*;

//https://leetcode.com/problems/campus-bikes/submissions/
public class Greedy_lc_assign_bikes_to_workers {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        ArrayList<LinkedList<Pair>> list = new ArrayList<LinkedList<Pair>>();
        for (int i = 0; i < 2001; ++i) {
            list.add(new LinkedList<Pair>());
        }
        for (int i = 0; i < workers.length; ++i) {
            for (int j = 0; j < bikes.length; ++j) {
                Pair pair = new Pair(i, j);
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                list.get(distance).add(pair);
            }
        }

        int[] answer = new int[workers.length];
        boolean[] assignedWorkers = new boolean[workers.length];
        boolean[] assignedBikes = new boolean[bikes.length];

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).size() == 0) {
                continue;
            }
            for (Pair pair : list.get(i)) {
                if (!assignedWorkers[pair.worker] && !assignedBikes[pair.bike]) {
                    assignedWorkers[pair.worker] = true;
                    assignedBikes[pair.bike] = true;
                    answer[pair.worker] = pair.bike;
                }
            }
        }
        return answer;
    }

    class Pair{
        int worker;
        int bike;
        public Pair(int a, int b) {
            worker = a;
            bike = b;
        }
    }
}
