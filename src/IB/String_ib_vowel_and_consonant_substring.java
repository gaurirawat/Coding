package IB;
//https://www.interviewbit.com/problems/vowel-and-consonant-substrings/
public class String_ib_vowel_and_consonant_substring {
    public int solve(String a) {
        char[] ch=a.toCharArray();
        int startsWithVowel=0;
        int startsWithConsonent=0;
        long c=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'){
                c+=startsWithConsonent;
                startsWithVowel++;
            }
            else{
                c+=startsWithVowel;
                startsWithConsonent++;
            }
        }
        return (int)(c%mod);
    }
}
