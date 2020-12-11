package IB;
//https://www.interviewbit.com/problems/check-palindrome/
public class Hashing_ib_check_palindrome {
    public int solve(String a) {
        int[] alp= new int[26];
        for(int i=0;i<a.length();++i) {
            alp[a.charAt(i)-'a']++;
        }
        boolean isOdd=false;
        for(int i=0;i<26;++i) {
            if(alp[i]%2!=0){
                if(!isOdd){
                    isOdd=true;
                }
                else{
                    return 0;
                }
            }
        }
        return 1;
    }
}
