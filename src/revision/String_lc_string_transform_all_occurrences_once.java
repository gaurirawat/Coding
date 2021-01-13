package revision;

import java.util.Arrays;

//https://leetcode.com/problems/string-transforms-into-another-string/
public class String_lc_string_transform_all_occurrences_once {
    public boolean canConvert(String aStr, String bStr) {
        if (aStr.equals(bStr)){
            return true;
        }
        int[] graph = new int[26];
        int[] alphB = new int[26];
        Arrays.fill(graph, -1);
        for (int i = 0; i < aStr.length(); ++i) {
            int a = aStr.charAt(i) - 'a';
            int b = bStr.charAt(i) - 'a';
            alphB[b]++;
            if (graph[a] == -1) {
                graph[a] = b;
            }
            else if(graph[a] != b) {
                return false;
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (alphB[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
