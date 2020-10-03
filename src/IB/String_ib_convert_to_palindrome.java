package IB;
//https://www.interviewbit.com/problems/convert-to-palindrome/
public class String_ib_convert_to_palindrome {
    public int solve(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                if(checkEqual(l,r-1,s)||checkEqual(l+1,r,s))
                    return 1;
                else
                    return 0;
            }
            ++l;
            --r;
        }
        if(s.length()%2==1)
            return 1;
        return 0;
    }

    public boolean checkEqual(int l, int r,String s){
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
}
