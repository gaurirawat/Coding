package IB;

import java.util.Arrays;

//https://www.interviewbit.com/problems/maximal-string/
public class Backtracking_ib_maximal_string {
    int max;
    public String solve(String s, int k) {
        max = Integer.parseInt(s);
        char[] ch = s.toCharArray();
        if (k >= ch.length) {
            Arrays.sort(ch);
            return new String(ch);
        }
        inner(0, ch, k);
        return max + "";
    }

    public void inner(int i, char[] ch, int k) {
        max = Math.max(max, Integer.parseInt(new String(ch)));
        if (k == 0 || i == ch.length) {
            return;
        }
        inner(i + 1, ch, k);
        for (int j = 0; j <= i; ++j) {
            char t = ch[j];
            ch[j] = ch[i];
            ch[i] = t;
            inner(i + 1, ch, k - 1);
            t = ch[j];
            ch[j] = ch[i];
            ch[i] = t;
        }
        return;
    }
}
