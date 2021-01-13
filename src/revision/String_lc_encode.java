package revision;

import java.util.HashMap;
//Ref: https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95613/Java-DFS-%2B-Memorization
//https://leetcode.com/problems/encode-string-with-shortest-length/
public class String_lc_encode {
    HashMap<String, String> map = new HashMap<String, String>();

    public String encode(String s) {
        if (s.length() <= 4) {
            return s;
        }
        if (map.get(s) != null) {
            return map.get(s);
        }

        String answer = s;

        //first we try to partition the string to see if the concat of partitions can give us the correct answer.
        for (int i = 1; i < s.length(); ++i) {
            String left = encode(s.substring(0, i));
            String right = encode(s.substring(i));
            if (left.length() + right.length() < answer.length()) {
                answer = left + right;
            }
        }

        //we see if this complete string can be rewritten as repetition of some pattern
        for(int len = 1; len <= s.length() / 2; ++len) {
            String pattern = s.substring(s.length() - len);
            if (s.length() % pattern.length() == 0) {
                int c = getNoOfRepetitions(s, pattern);
                if (c != -1) {
                    String tempAnswer = ""+ c + '[' + encode(pattern) + ']';
                    if (tempAnswer.length() < answer.length()) {
                        answer = tempAnswer;
                    }
                }

            }
        }
        map.put(s, answer);
        return answer;
    }

    public int getNoOfRepetitions(String s, String pattern) {
        int c = 0;
        while (s.length() != 0 && s.startsWith(pattern)) {
            c++;
            s = s.substring(pattern.length());
        }
        if (s.length() == 0) {
            return c;
        } else {
            return -1;
        }
    }
}
