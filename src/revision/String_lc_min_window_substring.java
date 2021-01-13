package revision;

import java.util.*;
//https://leetcode.com/problems/minimum-window-substring/submissions/
public class String_lc_min_window_substring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> alphT = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray()) {
            alphT.put(ch, alphT.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> alphS = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            alphS.put(ch, alphS.getOrDefault(ch, 0) + 1);
        }

        int uniqueT = 0;
        int uniqueS = 0;
        for (Map.Entry<Character, Integer> e : alphT.entrySet()) {
            uniqueT++;
            if (e.getValue() > alphS.getOrDefault(e.getKey(), 0)) {
                return "";
            }
        }

        alphS.clear();
        int l = 0;
        int r = 0;
        String answer = s;
        for (r = 0; r < s.length(); ++r) {
            char ch = s.charAt(r);
            alphS.put(ch, alphS.getOrDefault(ch, 0) + 1);
            if ((alphS.get(ch)).compareTo(alphT.getOrDefault(ch, 0)) == 0) {
                uniqueS++;

                if (uniqueS == uniqueT) {
                    while (l <= r) {
                        char currCh = s.charAt(l);
                        if ((alphS.get(currCh)).compareTo(alphT.getOrDefault(currCh, 0)) > 0) {
                            alphS.put(currCh, alphS.get(currCh) - 1);
                            l++;
                        } else {
                            break;
                        }
                    }

                    if (answer.length() > r - l + 1) {
                        answer = s.substring(l, r + 1);
                    }

                    //removing one element
                    char currCh = s.charAt(l);
                    alphS.put(currCh, alphS.get(currCh) - 1);
                    uniqueS--;
                    l++;
                }
            }
        }
        return answer;
    }
}
