package revision;

import java.util.*;

public class Graph_lc_accounts_merge_DIS {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = accounts.size();
        int[] root = new int[len];

        // set roots for differents account
        for (int i = 0; i < len; ++i) {
            root[i] = i;
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                String x = accounts.get(i).get(j);
                if (map.get(x) != null && !find(i, map.get(x), root)) {
                    union(i, map.get(x), root);
                } else {
                    map.put(x, i);
                }
            }
        }

        //collecting emails belonging to one root together.
        HashMap<Integer, TreeSet<String>> mergedAccounts = new HashMap<Integer, TreeSet<String>>();
        for (int i = 0; i < len; ++i) {
            int accountRoot = getRoot(i, root);
            TreeSet<String> set = mergedAccounts.getOrDefault(accountRoot, new TreeSet<String>());
            mergedAccounts.put(accountRoot, set);
            for (int j = 1; j < accounts.get(i).size(); ++j){
                String email= accounts.get(i).get(j);
                mergedAccounts.get(accountRoot).add(email);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (Map.Entry<Integer, TreeSet<String>> e: mergedAccounts.entrySet()) {
            ArrayList<String> mergedAccountEntry = new ArrayList<String>();
            String name = accounts.get(e.getKey()).get(0);
            mergedAccountEntry.add(name);
            mergedAccountEntry.addAll(e.getValue());

            result.add(mergedAccountEntry);
        }

        return result;
    }

    public boolean find(int u, int v, int[]root) {
        return getRoot(u, root) == getRoot(v, root);
    }

    public void union(int u, int v, int[] root) {
        int rootU = getRoot(u, root);
        root[rootU] = getRoot(v, root);
    }

    public int getRoot(int v, int[] root) {
        while (root[v] != v) {
            root[v] = root[root[v]];
            v = root[v];
        }
        return v;
    }
}
