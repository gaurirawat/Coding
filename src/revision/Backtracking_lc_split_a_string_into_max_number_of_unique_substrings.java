package revision;

import java.util.HashSet;

//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
public class Backtracking_lc_split_a_string_into_max_number_of_unique_substrings {
    int max;
    public int maxUniqueSplit(String s) {
        max=1;
        HashSet<String> set=new HashSet<String>();
        splitInner(s,0,set);
        return max;
    }

    public void splitInner(String s, int i, HashSet<String> set){
        if(i==s.length())
            max=Math.max(max, set.size());
        for(int r=i+1;r<=s.length();++r){
            String x=s.substring(i,r);
            if(!set.contains(x)){
                set.add(x);
                splitInner(s,r,set);
                set.remove(x);
            }
        }
    }
}