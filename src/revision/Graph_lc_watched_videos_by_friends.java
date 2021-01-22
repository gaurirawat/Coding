package revision;

import java.util.*;

//https://leetcode.com/problems/get-watched-videos-by-your-friends/submissions/
public class Graph_lc_watched_videos_by_friends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;
        q.add(id);
        while(level-- != 0 && !q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.pollFirst();
                for (int v : friends[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int x : q) {
            for (String s : watchedVideos.get(x)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        ArrayList<String> videos = new ArrayList<String>();
        if (map.isEmpty()) {
            return videos;
        }
        videos.addAll(map.keySet());
        Collections.sort(videos, (a, b) ->
                (map.get(a) != map.get(b) ? map.get(a) - map.get(b) : a.compareTo(b)));
        return videos;
    }
}
