package IB;
//https://www.interviewbit.com/problems/atoi/
public class String_ib_string_to_integer {
    public int atoi(final String s) {
        String a=s.trim();
        if(a.length()==0) return 0;
        int i=0;
        boolean isPositive=true;
        if(a.charAt(0)=='+'){
            a=a.substring(1);
        }
        else if(a.charAt(0)=='-'){
            i++;
            isPositive=false;
        }
        for(;i<a.length();++i)
            if(!Character.isDigit(a.charAt(i)))
                break;
        if((isPositive && i==0)||!isPositive && i==1) return 0;
        a=a.substring(0,i);
        // System.out.println(a);
        if(isPositive&&(i>(Integer.MAX_VALUE+"").length()|| Long.parseLong(a)>Integer.MAX_VALUE))
            return Integer.MAX_VALUE;
        if(!isPositive &&(i>(Integer.MIN_VALUE+"").length()||Long.parseLong(a)<Integer.MIN_VALUE))
            return Integer.MIN_VALUE;
        else
            return Integer.parseInt(a);
    }
}
