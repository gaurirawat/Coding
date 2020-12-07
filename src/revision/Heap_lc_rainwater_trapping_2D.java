package revision;

import java.util.*;
/*
Insert all border elements into pq. Keep polling elements with lowest ht. enqueue the neighbouring cell if not visited.
at the time of adding a new cell to pq REMEMBER TO PUT HEIGHT AS MAX(NEW CELL HT, CURR CELL HT). This will help retain
the max boundary.
ref:https://leetcode.com/problems/trapping-rain-water-ii/discuss/89495/How-to-get-the-solution-to-2-D-%22Trapping-Rain-Water%22-problem-from-1-D-case
 */
//https://leetcode.com/problems/trapping-rain-water-ii/submissions/
public class Heap_lc_rainwater_trapping_2D {
    public int trapRainWater(int[][] ht) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        int m = ht.length;
        int n = (m == 0 ? 0 : ht[0].length);
        boolean[][] visited=new boolean[m][n];
        int sum=0;
        for(int i=0;i<m;++i) {
            pq.add(new int[]{i,0,ht[i][0]});
            pq.add(new int[]{i,n-1,ht[i][n-1]});
            visited[i][0]=true;
            visited[i][n-1]=true;
        }

        for(int j=0;j<n;++j) {
            pq.add(new int[]{0,j,ht[0][j]});
            pq.add(new int[]{m-1,j,ht[m-1][j]});
            visited[0][j]=true;
            visited[m-1][j]=true;
        }

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int[][] dxy=new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int i=0; i<4; ++i) {
                int x=curr[0]+dxy[i][0];
                int y=curr[1]+dxy[i][1];
                if(x>=0 && y>=0 && x<m&& y<n && !visited[x][y]){
                    visited[x][y]=true;
                    pq.add(new int[]{x,y,Math.max(ht[x][y],curr[2])});
                    if(curr[2]>ht[x][y]) {
                        sum+=curr[2]-ht[x][y];
                    }
                }
            }
        }
        return sum;
    }
}
