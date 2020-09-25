package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/multiply-strings/
public class String_ib_multiply_two_strings {
    public String multiply(String a, String b) {
        int s=0;
        while(s<a.length() && a.charAt(s)=='0')++s;
        a=a.substring(s);

        s=0;
        while(s<b.length() && b.charAt(s)=='0')++s;
        b=b.substring(s);

        if(a==null||b==null||a.length()==0||b.length()==0)
            return "0";
        a=(new StringBuilder(a)).reverse().toString();
        b=(new StringBuilder(b)).reverse().toString();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<a.length();++i){
            int ct=0,ca=0;
            int mul=a.charAt(i)-'0';
            for(int j=0;j<b.length();++j){
                int x=(b.charAt(j)-'0')*mul+ct;
                ct=x/10;
                int n=x%10;
                int pos=i+j;
                if(pos==ans.size()){
                    n=n+ca;
                    ans.add(n%10);
                    ca=n/10;
                }
                else{
                    n=n+ans.get(pos)+ca;
                    ans.set(pos,n%10);
                    ca=n/10;
                }
            }
            int pos=i+b.length();
            int c=ct+ca;
            while(c!=0){
                if(pos==ans.size()){
                    ans.add(c%10);
                    c=c/10;
                }
                else{
                    c+=ans.get(pos);
                    ans.set(pos,c%10);
                    c=c/10;
                }
                pos++;
            }
        }
        StringBuffer br=new StringBuffer();
        for(int i=ans.size()-1;i>=0;--i)
            br.append(ans.get(i));
        return br.toString();
    }
}
