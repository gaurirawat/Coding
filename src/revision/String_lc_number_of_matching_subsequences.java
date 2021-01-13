package revision;

import java.util.*;

//https://leetcode.com/problems/number-of-matching-subsequences/submissions/
public class String_lc_number_of_matching_subsequences {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 26; ++i) {
            list.add(new ArrayList<String>());
        }
        for (String word: words) {
            list.get(word.charAt(0)-'a').add(word);
        }

        int c = 0;
        for (char ch: s.toCharArray()) {
            ArrayList<String> curr = list.get(ch - 'a');
            list.set(ch - 'a', new ArrayList<String>());
            for (String word : curr) {
                if (word.length() == 1) {
                    c++;
                }
                else {
                    list.get(word.charAt(1) - 'a').add(word.substring(1));
                }
            }
        }
        return c;
    }
}
