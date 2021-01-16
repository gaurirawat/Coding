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
/*

//KMP approach
    HashMap<String, String> map;
    public String encode(String s) {
        map = new HashMap<String, String>();
        return encodeInner(s);
    }

    public String encodeInner(String s) {
        if (s.length() <= 4) {
            return s;
        }
        if (map.get(s) != null) {
            return map.get(s);
        }

        String answer = s;

        String repetitionEncoding = getRepetitionEncoding(s);
        if (repetitionEncoding.length() < answer.length()) {
            answer = repetitionEncoding;
        }

        for (int i = 1; i < s.length(); ++i) {
            String l = encodeInner(s.substring(0, i));
            String r = encodeInner(s.substring(i));
            if (l.length() + r.length() < answer.length()) {
                answer = l + r;
            }
        }


        map.put(s, answer);
        return answer;
    }

    public String getRepetitionEncoding(String s) {
        char[] ch = s.toCharArray();
        int[] lps = new int[ch.length];

        int i = 0;
        for (int j = 1; j < ch.length; ++j) {
            while(ch[i] != ch[j] && i!= 0) {
                i = lps[i - 1];
            }
            if (ch[i] == ch[j]) {
                lps[j] = ++i;
            } else {
                lps[j] = 0;
            }
        }
        if (lps[ch.length - 1] == 0) {
            return new String(s);
        }

        String repeatedString = s.substring(0, s.length() - lps[ch.length - 1]);
        // System.out.println(repeatedString);
        if (s.length() % repeatedString.length() == 0) {
            int count = s.length() / repeatedString.length();
            // System.out.println(count);
            for (i = 0; i < count; ++i) {
                if (s.startsWith(repeatedString)) {
                    s = s.substring(repeatedString.length());

                    // System.out.println(s);
                } else {
                    return new String(ch);
                }
            }
            repeatedString = encodeInner(repeatedString);
            return count + "[" + repeatedString + "]";
        }
        return new String(ch);
    }
 */
