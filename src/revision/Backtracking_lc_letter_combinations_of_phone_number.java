package revision;

import java.util.*;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Backtracking_lc_letter_combinations_of_phone_number {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        if (digits.length() == 0) {
            return answer;
        }
        String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generateCombinations(0, digits, "", arr, answer);
        return answer;
    }

    public void generateCombinations(int i, String digits, String curr, String[]arr, List<String> answer) {
        if (i == digits.length()) {
            answer.add(curr);
            return;
        }

        for (char ch: arr[digits.charAt(i)-'2'].toCharArray()) {
            generateCombinations(i+1, digits, curr+ch, arr, answer);
        }
    }
}
