package revision;

import java.util.*;

//https://leetcode.com/problems/permutations/submissions/
public class Backtracking_lc_all_permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        boolean[] set = new boolean[nums.length];
        generatePermutations(nums, set, answer, new ArrayList<Integer>());
        return answer;
    }

    public void generatePermutations(int[]nums, boolean[] set, List<List<Integer>> answer, ArrayList<Integer> list) {
        if (list.size() == set.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            answer.add(temp);
            return;
        }

        for (int i = 0; i<set.length; ++i) {
            if (!set[i]) {
                set[i] = true;
                list.add(nums[i]);
                generatePermutations(nums, set, answer, list);
                set[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
