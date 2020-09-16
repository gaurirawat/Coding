package revision;

import java.util.Arrays;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class Graph_lc_min_cost_to_connect_all_points_using_manhattan_distance {
    public int minCostConnectPoints(int[][] p) {
        int n=p.length;
        boolean conn[]=new boolean[n];
        int dis[]=new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int min=0;
        dis[0]=-1;
        for(int i=0;i<n;++i){
            int index=getMinDistPoint(conn, dis, p);
            // System.out.println(dis[index]);
            min+=dis[index]==-1?0:dis[index];
            conn[index]=true;
            updateDist(index, conn, dis, p);
        }
        return min;
    }

    public void updateDist(int index, boolean[]conn, int[]dis, int[][]p){
        int inx=p[index][0];
        int iny=p[index][1];
        for(int i=0;i<dis.length;++i){
            if(!conn[i]){
                long distance=Math.abs(0l+inx-p[i][0])+Math.abs(0l+iny-p[i][1]);
                if(distance<dis[i])
                    dis[i]=(int)distance;
            }
        }
    }


    public int getMinDistPoint(boolean[]conn, int[]dis, int[][]p){
        int minIndex=0;
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<conn.length;++i){
            if(!conn[i] && dis[i]<minVal){
                minVal=dis[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
