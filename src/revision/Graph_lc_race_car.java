package revision;

import java.util.*;
//ref:
// https://leetcode.com/problems/race-car/discuss/123884/Accepted-Java-solution-with-BFS
//https://leetcode.com/problems/race-car/submissions/
public class Graph_lc_race_car {
    public int racecar(int target) {
        Deque<int[]> q=new LinkedList<int[]>();
        HashSet<String> visited=new HashSet<String>();
        q.add(new int[]{0,1,0});
        visited.add("1 0");
        while (!q.isEmpty()) {
            int[] arr=q.poll();
            if(arr[0]==target) {
                return arr[2];
            }
            String A = (arr[0]+arr[1]) + " " + (arr[1]*2);
            String R = arr[0]+ " "+ (arr[1]>0?-1:1);
            if(Math.abs(arr[0]+arr[1]-target)<target && !visited.contains(A)) {
                visited.add(A);
                q.add(new int[]{arr[0]+arr[1],arr[1]*2, arr[2]+1});
            }
            if(Math.abs(arr[0]-target)<target && !visited.contains(R)){
                visited.add(R);
                q.add(new int[]{arr[0],(arr[1]>0?-1:1), arr[2]+1});
            }
        }
        return -1;
    }

}
