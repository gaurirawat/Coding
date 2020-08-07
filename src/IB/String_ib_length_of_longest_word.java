package IB;
//https://www.interviewbit.com/problems/length-of-last-word/
public class String_ib_length_of_longest_word {
    public int lengthOfLastWord(final String s) {
        // if(s1==null||s1.length()==0) return 0;
        // String s=s1.trim();
        if(s==null||s.length()==0) return 0;
        int i=0;
        int j=-1;
        boolean flag=false;
        for(i=s.length()-1;i>=0;--i){
            if(!flag && Character.isLetter(s.charAt(i))){
                flag=true;
                j=i;
            }
            if(flag && !Character.isLetter(s.charAt(i)))
                break;
        }
        return j-i;
    }
}
