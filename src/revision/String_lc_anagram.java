package revision;
//https://leetcode.com/problems/valid-anagram/submissions/
public class String_lc_anagram {
    public boolean isAnagram(String a, String b) {
        if(a.length()!=b.length()) {
            return false;
        }

        int[] alphabetsA= new int[26];
        int[] alphabetsB= new int[26];

        for(int i=0;i<a.length();++i) {
            alphabetsA[a.charAt(i)-'a']++;
            alphabetsB[b.charAt(i)-'a']++;
        }

        for(int i=0;i<26;++i) {
            if(alphabetsA[i]!=alphabetsB[i]) {
                return false;
            }
        }
        return true;
    }
}