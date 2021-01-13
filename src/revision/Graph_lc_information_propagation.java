package revision;

import java.util.*;

//https://leetcode.com/problems/time-needed-to-inform-all-employees/submissions/
public class Graph_lc_information_propagation {
    public int numOfMinutes(int n, int head, int[] mgr, int[] timeArray) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) {
            if (mgr[i] != -1) {
                ArrayList<Integer> l = graph.getOrDefault(mgr[i], new ArrayList<Integer>());
                l.add(i);
                graph.put(mgr[i], l);
            }
        }
        return getMinTime(head, graph, timeArray);
    }

    public int getMinTime(int head, HashMap<Integer, ArrayList<Integer>> graph, int[] timeArray) {
        if (graph.get(head) == null) {
            return 0;
        }

        int time = 0;
        for (int sub : graph.get(head)) {
            time = Math.max(time, getMinTime(sub, graph, timeArray));
        }
        return time + timeArray[head];
    }
}