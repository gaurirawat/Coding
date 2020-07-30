package revision;
//https://www.geeksforgeeks.org/find-substrings-contain-vowels/

import java.util.*;

public class DP_gfg_substring_that_contain_all_vowels {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while(t--!=0){
            char s[]=sc.nextLine().toCharArray();
            HashSet<String> ans= new HashSet<>();
            HashSet<Character> vowels= new HashSet<Character>();
            generateAllVowelSubstring(0,s,ans,vowels, "");
            System.out.println(ans.toString());
        }
    }
    public static void generateAllVowelSubstring(int i, char[]s,HashSet<String>ans, HashSet<Character>vowels, String soFar){
        if(vowels.size()==5)
            ans.add(soFar);
        if(i==s.length)
            return;
        if(!isVowel(s[i]))
            generateAllVowelSubstring(i+1,s,ans, new HashSet<Character>(),"");
        else{
            generateAllVowelSubstring(i+1,s,ans, vowels,soFar);
            vowels.add(s[i]);
            generateAllVowelSubstring(i+1,s,ans, vowels,soFar+s[i]);
            vowels.remove(new Character(s[i]));
        }
    }

    public static boolean isVowel(char c){
        c=Character.toLowerCase(c);
        if(c=='a'||c=='e'|| c=='i'||c=='o'||c=='u')
            return true;
        return false;
    }
}
