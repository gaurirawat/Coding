package IB;

import java.util.HashMap;

//https://www.interviewbit.com/problems/fraction/
public class Hashing_ib_fraction {
    public String fractionToDecimal(int aa, int bb) {
        if(aa*1.0/bb==aa*1l/bb)
            return aa*1l/bb+"";
        StringBuffer sb=new StringBuffer();
        if(aa<0&&bb>0||aa>0&&bb<0)
            sb.append("-");
        long b=Math.abs(bb+0l);
        long a=Math.abs(aa+0l);
        sb.append(a*1l/b+".");
        long rem=a%b;
        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        int i=sb.length();
        while(rem!=0){
            if(map.get(rem)!=null){
                int x=map.get(rem);
                String s=sb.substring(0,x)+"("+sb.substring(x)+")";
                return s;
            }
            map.put(rem,i);
            sb.append((rem*10)/b);
            i++;
            rem=rem*10%b;
        }
        return sb.toString();
    }
}
