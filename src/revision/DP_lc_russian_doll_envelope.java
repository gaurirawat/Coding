package revision;

import java.util.*;

//https://leetcode.com/problems/russian-doll-envelopes/submissions/
/*
We answer the question from the intuition by sorting. Let's pretend that we found the best arrangement of envelopes.
We know that each envelope must be increasing in w, thus our best arrangement has to be a subsequence of all our
envelopes sorted on w.
After we sort our envelopes, we can simply find the length of the longest increasing subsequence on the second dimension.
Consider an input [[1, 3], [1, 4], [1, 5], [2, 3]]. If we simply sort and extract the second dimension we get
[3, 4, 5, 3], which implies that we can fit three envelopes (3, 4, 5). The problem is that we can only fit one envelope,
since envelopes that are equal in the first dimension can't be put into each other.

In order fix this, we don't just sort increasing in the first dimension - we also sort decreasing on the second
dimension, so two envelopes that are equal in the first dimension can never be in the same increasing subsequence.
 */

public class DP_lc_russian_doll_envelope {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> (a[0] == b[0] ?(-a[1] + b[1]): (a[0] - b[0])));
        ArrayList<Integer> l = new ArrayList<Integer>();

        int i = 0;
        while (i < envelopes.length) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];

            int pos = Collections.binarySearch(l, h);
            if (pos < 0) {
                pos = Math.abs(pos + 1);
            }
            if (pos == l.size()) {
                l.add(h);
            } else {
                l.set(pos, h);
            }

            i++;
        }
        return l.size();
    }
}
