package revision;

import java.util.Arrays;

public class Graph_lc_cheapest_flight_within_k_stops_bellman_ford {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src < 0 || dst <0 || src >= n || dst >= n) {
            return -1;
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int k = 1 ; k <= K + 1; ++k) {
            int[] nextDistance = Arrays.copyOf(distance, distance.length);
            for (int j = 0; j < flights.length; ++j) {
                int u = flights[j][0];
                int v = flights[j][1];
                int cost = flights[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + cost) {
                    nextDistance[v] = Math.min(nextDistance[v], distance[u] + cost);
                }
            }
            distance = nextDistance;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
