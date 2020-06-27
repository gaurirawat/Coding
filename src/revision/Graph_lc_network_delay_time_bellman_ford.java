package revision;
// https://leetcode.com/problems/network-delay-time/
// Rememeber in bellman Ford the condition for the first loop is <v-1

import java.util.*;
public class Graph_lc_network_delay_time_bellman_ford {
	public int networkDelayTime(int[][] times, int v, int k) { 
        k--; //sincde src is 1->N
        int distance[]= new int[v];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k]=0;
		for(int j=0; j<v-1;++j){
			for(int i=0; i<times.length;++i){
				if(distance[times[i][0]-1]!=Integer.MAX_VALUE&& distance[times[i][1]-1]>distance[times[i][0]-1]+times[i][2])
					distance[times[i][1]-1]=distance[times[i][0]-1]==Integer.MAX_VALUE?0:distance[times[i][0]-1]+times[i][2];
			}
		}
    
        int max= Integer.MIN_VALUE;
		for(int i:distance){
			if(i==Integer.MAX_VALUE)
                return -1;
            else
                max=Math.max(max, i);
		}
		return max;
	}
}
