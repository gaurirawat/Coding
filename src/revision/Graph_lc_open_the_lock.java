package revision;

import java.util.*;

//https://leetcode.com/problems/open-the-lock/submissions/
public class Graph_lc_open_the_lock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<String>();
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }

        Deque<String> q = new LinkedList<String>();
        q.add("0000");
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String curr = q.pollFirst();
                if (curr.equals(target)) {
                    return moves;
                }
                for (String x : getNextStrings(curr)) {
                    if (!visited.contains(x)) {
                        q.addLast(x);
                        visited.add(x);
                    }
                }
            }
            ++moves;
        }
        return -1;
    }

    public ArrayList<String> getNextStrings(String curr) {
        ArrayList<String> list = new ArrayList<String>();
        char[] ch = curr.toCharArray();
        for (int i = 0; i < 4; ++i) {
            ch[i] = ch[i] == '9' ? '0' : (char)(ch[i] + 1);
            list.add(new String(ch));
            ch[i] = ch[i] == '0' ? '9' : (char)(ch[i] - 1);


            ch[i] = ch[i] == '0' ? '9' : (char)(ch[i] - 1);
            list.add(new String(ch));
            ch[i] = ch[i] == '9' ? '0' : (char)(ch[i] + 1);
        }
        return list;
    }
}
