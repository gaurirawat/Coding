package IB;

import java.util.*;
//https://www.interviewbit.com/problems/anagrams/
public class Hashing_ib_anagram {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < a.size(); ++i) {
            char ch[] = a.get(i).toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.get(s) == null) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i + 1);
                map.put(s, l);
            } else
                map.get(s).add(i + 1);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<String, ArrayList<Integer>> e : map.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }
}