package revision;

import java.util.*;

//https://leetcode.com/problems/palindrome-partitioning/
public class DP_lc_palindrome_partitioning_generate_all_partitions {
    public List<List<String>> partition(String s) {
        ArrayList<ArrayList<Integer>> palindromeIndexes = new ArrayList<ArrayList<Integer>>();
        for (int l = 0; l < s.length(); ++l) {
            palindromeIndexes.add(new ArrayList<Integer>());
            for (int r = l; r < s.length(); ++r) {
                if (isPalindromic(s.substring(l, r+1))) {
                    palindromeIndexes.get(l).add(r);
                }
            }
        }

        List<List<String>> answer = new ArrayList<List<String>>();
        generatePossiblePartitions(0, s, palindromeIndexes, new ArrayList<String>(), answer);
        return answer;
    }

    public void generatePossiblePartitions(int i, String s, ArrayList<ArrayList<Integer>> palindromeIndexes,
                                           ArrayList<String> partition, List<List<String>> answer) {
        if (i == s.length()) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(partition);
            answer.add(temp);
            return;
        }
        for (int r: palindromeIndexes.get(i)) {
            partition.add(s.substring(i, r+1));
            generatePossiblePartitions(r+1, s, palindromeIndexes, partition, answer);
            partition.remove(partition.size()-1);
        }
    }

    public boolean isPalindromic(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}
