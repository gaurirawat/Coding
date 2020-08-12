package IB;

import java.util.HashSet;

//https://www.interviewbit.com/problems/longest-substring-without-repeat/
public class Hashing_ib_longest_substring_with_non_repeating_characters {
    public int lengthOfLongestSubstring(String a) {
        char ch[]=a.toCharArray();
        HashSet<Character> set= new HashSet<Character>();
        int mx=0;
        int l=0,r=0;
        for(r=0;r<ch.length;++r){
            if(set.contains(ch[r])){
                mx=Math.max(mx,r-l);
                while(ch[l]!=ch[r])
                    set.remove(new Character(ch[l++]));
                set.remove(new Character(ch[l++]));
            }
            set.add(ch[r]);
        }
        mx=Math.max(mx,r-l);
        return mx;
    }
}
