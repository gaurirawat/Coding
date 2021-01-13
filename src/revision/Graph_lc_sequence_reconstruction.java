package revision;

import java.util.*;

//https://leetcode.com/problems/sequence-reconstruction/submissions/
/*
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a
permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence
of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine
whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input: org = [1,2,3], seqs = [[1,2],[1,3]]
Output: false
Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input: org = [1,2,3], seqs = [[1,2]]
Output: false
Explanation: The reconstructed sequence can only be [1,2].
Example 3:

Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Output: true
Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Output: true

Constraints:
1 <= n <= 10^4
org is a permutation of {1,2,...,n}.
1 <= segs[i].length <= 10^5
seqs[i][j] fits in a 32-bit signed integer.
 */

public class Graph_lc_sequence_reconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0) {
            return org.length == 0;
        }
        // hashset used instead of arrayList since same edge can occur again as in example 4.
        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < org.length; ++i) {
            graph.add(new HashSet<Integer>());
        }

        for(List<Integer> list : seqs) {
            if (!isValid(list.get(0), org.length)) {
                return false;
            }
            for (int i = 1; i < list.size(); ++i) {
                if (!isValid(list.get(i), org.length)) {
                    return false;
                }
                graph.get(list.get(i - 1) - 1).add(list.get(i) - 1);
            }
        }

        //calculating the indegree after the graph creation so that indegree is not wrongly calculated at the time of same edge insertion to the graph.
        int[] inDegree = new int[org.length];
        for(HashSet<Integer> list : graph) {
            for (int v : list) {
                inDegree[v]++;
            }
        }
        // System.out.println(Arrays.toString(inDegree));

        //kahns algo
        Deque<Integer> zeroInDegree = new LinkedList<Integer>();
        for (int i = 0; i < org.length; ++i) {
            if (inDegree[i] == 0) {
                zeroInDegree.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<Integer>();
        while (zeroInDegree.size() == 1) {
            int u = zeroInDegree.poll();
            order.add(u);
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    zeroInDegree.add(v);
                }
            }
        }

        if(order.size() != org.length) {
            return false;
        }

        for (int i = 0; i < org.length; ++i) {
            if (order.get(i)+1 != org[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int i, int n) {
        if (i <= 0 || i > n) {
            return false;
        }
        return true;
    }
}
