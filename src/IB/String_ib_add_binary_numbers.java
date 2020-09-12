package IB;

import java.math.BigInteger;

//https://www.interviewbit.com/problems/add-binary-strings/
public class String_ib_add_binary_numbers {
    public String addBinary(String a, String b) {
        StringBuffer asb=new StringBuffer(a);
        StringBuffer bsb=new StringBuffer(b);
        asb=asb.reverse();
        bsb=bsb.reverse();
        int carry=0;
        int len=Math.max(a.length(),b.length());
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<len;++i){
            int x=i<a.length()?(asb.charAt(i)=='1'?1:0):0;
            int y=i<b.length()?(bsb.charAt(i)=='1'?1:0):0;
            int t=x+y+carry;
            carry=t/2;
            t=t%2;
            ans.append(""+t);
        }
        if(carry==1)
            ans.append("1");
        ans=ans.reverse();
        return (new BigInteger(ans.toString())).toString();
    }
}
