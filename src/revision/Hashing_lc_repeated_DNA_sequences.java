package revision;

import java.util.*;

//https://leetcode.com/problems/repeated-dna-sequences/submissions/
public class Hashing_lc_repeated_DNA_sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<String>();
        }
        HashSet<String> set = new HashSet<String>();
        HashSet<String> repeats = new HashSet<String>();

        String window = s.substring(0, 10);
        set.add(window);
        for (int i = 10; i < s.length(); ++i) {
            window = window.substring(1) + s.charAt(i);
            if (set.contains(window)) {
                repeats.add(window);
            }
            set.add(window);
        }

        ArrayList<String> answer = new ArrayList<String>(repeats);
        return answer;
    }
}
