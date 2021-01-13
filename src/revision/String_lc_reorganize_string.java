package revision;

import java.util.*;

//https://leetcode.com/problems/reorganize-string/submissions/
public class String_lc_reorganize_string {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>(Comparator.comparingInt(a->-map.get(a)));
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(e.getKey());
        }

        StringBuffer sb = new StringBuffer();
        while(pq.size() > 1) {
            char a = pq.poll();
            char b = pq.poll();
            sb.append(a);
            sb.append(b);
            map.put(a, map.get(a) - 1);
            map.put(b, map.get(b) - 1);
            if (map.get(a) != 0) {
                pq.add(a);
            }
            if (map.get(b) != 0) {
                pq.add(b);
            }
        }
        if (pq.size() == 0) {
            return sb.toString();
        }
        else if (map.get(pq.peek()) != 1){
            return "";
        }
        else {
            sb.append(pq.poll());
            return sb.toString();
        }
    }
}
