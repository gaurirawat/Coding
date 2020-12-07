package revision;

import java.util.Arrays;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/submissions/
//go through below implementation
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/549140/JAVA-0-ms-(-100-)-Divide-and-Conquer
public class String_lc_longest_substring_with_at_least_k_repeating_characters {
    int max;
    public int longestSubstring(String s, int k) {
        if(k==0||k==1){
            return s.length();
        }
        max=0;
        int[] alp=new int[26];
        boolean[] lessThanK=new boolean[26];
        Arrays.fill(lessThanK, true);
        for(int i=0;i<s.length();++i) {
            int index=s.charAt(i)-'a';
            alp[index]++;
            if(alp[index]==k) {
                lessThanK[index]=false;
            }
        }
        inner(alp,lessThanK,s,k);
        return max;
    }
    public void inner(int alp[], boolean lessThanK[], String s, int k) {
        // System.out.println(s+"--"+alp[0]+alp[1]+alp[2]+alp[3]+"--"+lessThanK[0]+lessThanK[1]+lessThanK[2]+lessThanK[3]);
        if(s.length()<=max || s.length()<k) {
            return;
        }
        int[] talp=new int[26];
        boolean[] tlessThanK=new boolean[26];
        Arrays.fill(tlessThanK,true);
        int l=0;
        int r;
        for(r=0;r<s.length();++r) {
            int i=s.charAt(r)-'a';
            if(lessThanK[i]) {
                inner(talp,tlessThanK,s.substring(l,r),k);
                Arrays.fill(talp,0);
                Arrays.fill(tlessThanK,true);
                l=r+1;
            } else {
                talp[i]++;
                if(talp[i]==k) {
                    tlessThanK[i]=false;
                }
            }
        }
        if(l==0 && r==s.length()) {
            max=Math.max(max,s.length());
        } else {
            inner(talp,tlessThanK,s.substring(l,r),k);
        }
    }

}
/*
"aaabb"
3

"sdkncnsvhjhfvbdxmvnfjnzxbvndzvdnv"
2

"ababbc"
2

"bbaaacbd"
3

"sdkncdassdknkjndsvknkjdsnnsvhjhfvbdxmvnfjnzxbvndzvdnv"
2
*/
