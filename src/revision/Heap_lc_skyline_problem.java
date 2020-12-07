package revision;

import java.util.*;
//https://leetcode.com/problems/the-skyline-problem/submissions/

//ref:
//https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
public class Heap_lc_skyline_problem {
    public List<List<Integer>> getSkyline(int[][] b) {
        List<int[]> l= new ArrayList<int[]> ();
        List<List<Integer>> ans= new ArrayList<List<Integer>> ();
        for(int i=0;i<b.length;++i) {
            l.add(new int[]{b[i][0], b[i][2]});
            l.add(new int[]{b[i][1], -b[i][2]});
        }
        Collections.sort(l, new CustomComparator());

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        int max=-1;
        pq.add(0);
        for(int i=0; i<l.size();++i) {
            int[] t=l.get(i);
            if(t[1]<0) {
                pq.remove(-t[1]);
            } else {
                pq.add(t[1]);
            }
            if(max!=pq.peek()) {
                List<Integer> point= new ArrayList<Integer>();
                point.add(t[0]);
                point.add(pq.peek());
                ans.add(point);
                max=pq.peek();
            }
        }
        return ans;
    }


}
class CustomComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] a, int[] b) {
        if(a[0]!=b[0]) {
            return a[0]-b[0];
        }
        return b[1]-a[1];
    }
}