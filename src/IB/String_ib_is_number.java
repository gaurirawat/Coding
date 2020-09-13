package IB;
//https://www.interviewbit.com/problems/valid-number/
public class String_ib_is_number {
    public int isNumber(final String ss) {
        String s=ss.trim();
        if(s.length()==0) return 0;
        boolean exAllowed=true;
        boolean decAllowed=true;
        boolean isFirstDig=true;
        char ch[]=s.toCharArray();
        for(int i=0;i<s.length();++i){
            if((ch[i]=='+'||ch[i]=='-') && (i==0||ch[i-1]=='e') && i+1<s.length() && (Character.isDigit(ch[i+1])||ch[i+1]=='.'))
                ;
            else if(Character.isDigit(ch[i]))
                ;
            else if(ch[i]=='e' && exAllowed && i!=0 && i+1<s.length() && (Character.isDigit(ch[i+1])||ch[i+1]=='+'||ch[i+1]=='-')){
                exAllowed=false;
                decAllowed=false;
                ;
            }
            else if(ch[i]=='.' && decAllowed && i+1<s.length() && Character.isDigit(ch[i+1]))
                ;
            else
                return 0;
        }
        return 1;
    }
}
