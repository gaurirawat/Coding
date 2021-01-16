package revision;

import java.util.*;
//https://leetcode.com/problems/minimum-window-substring/submissions/
public class String_lc_min_window_substring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> alpT = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            alpT.put(ch, alpT.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> alpS = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            alpS.put(ch, alpS.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> e : alpT.entrySet()) {
            if (alpS.get(e.getKey()) == null || alpS.get(e.getKey()) < e.getValue()) {
                return "";
            }
        }

        int uniqueT = alpT.size();
        int uniqueS = 0;
        alpS.clear();

        char[] ch = s.toCharArray();
        String ans = s;

        int l = 0;
        int r = 0;
        for (; r < ch.length; ++r) {
            alpS.put(ch[r], alpS.getOrDefault(ch[r], 0) + 1);

            if (alpS.get(ch[r]).equals(alpT.get(ch[r]))) {
                uniqueS++;
                if (uniqueS == uniqueT) {
                    // contracting window as long as it remains valid
                    while (alpT.get(ch[l]) == null || alpS.get(ch[l]) > alpT.get(ch[l])) {
                        alpS.put(ch[l], alpS.get(ch[l]) - 1);
                        ++l;
                    }
                    //checking if it is of a smaller length than our current answer window
                    if (ans.length() > r - l + 1) {
                        ans = s.substring(l, r + 1);
                    }

                    //removing the first alphabet that will make the window invalid so we
                    // can look for the next window with greater r index
                    alpS.put(ch[l], alpS.get(ch[l++]) - 1);
                    uniqueS--;
                }
            }
        }
        return ans;
    }
}
