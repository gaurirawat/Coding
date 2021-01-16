package revision;

import java.util.HashMap;

//https://leetcode.com/problems/fraction-to-recurring-decimal/submissions/
public class String_lc_fractional_to_decimal {
    public String fractionToDecimal(int Num, int Den) {
        if (Num == 0 ) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        boolean neg = (Num < 0) ^ (Den < 0);
        long num = Math.abs(Num + 0L);
        long den = Math.abs(Den + 0L);

        sb.append(num/den);
        long rem = 1L * num % den;
        if (rem == 0) {
            return (neg ? "-" : "" )+ sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        while (rem != 0 && map.get(rem) == null) {
            map.put(rem, sb.length());
            sb.append(rem * 10 / den);
            rem = (rem * 10 ) % den;
        }

        if (rem == 0) {
            return (neg ? "-" : "" ) + sb.toString();
        }
        return (neg ? "-" : "" ) + sb.substring(0, map.get(rem)) +"(" + sb.substring(map.get(rem)) + ")" ;
    }
}