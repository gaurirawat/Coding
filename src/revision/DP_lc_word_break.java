package revision;

import java.util.*;

//https://leetcode.com/problems/word-break/
//https://practice.geeksforgeeks.org/problems/word-break/0

public class DP_lc_word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Character, List<String>> map = new HashMap<Character, List<String>>();
        int[] dp = new int[s.length()];
        for (String word : wordDict) {
            List<String> l = map.getOrDefault(word.charAt(0), new ArrayList<String>());
            l.add(word);
            map.put(word.charAt(0), l);
        }

        return wordExist(0, s, map, dp) == 1 ? true : false;
    }

    public int wordExist(int i, String s, HashMap<Character, List<String>> map, int[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        dp[i] = -1;
        for (String word : map.getOrDefault(s.charAt(i), new ArrayList<String>())) {
            int len = word.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(word)
                    && wordExist(i + len, s, map, dp) == 1) {
                dp[i] = 1;
                break;
            }
        }

        return dp[i];
    }
}
