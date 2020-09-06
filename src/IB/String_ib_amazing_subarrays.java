package IB;
//https://www.interviewbit.com/problems/amazing-subarrays/
public class String_ib_amazing_subarrays {
    public int solve(String A) {
        A=A.toLowerCase();
        char ch[]=A.toCharArray();
        int c=0;
        int mod=10003;
        for(int i=0;i<ch.length;++i)
            if(isVowel(ch[i]))
                c+=ch.length-i;
        c%=mod;
        return c;
    }

    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
