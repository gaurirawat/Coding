package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/multiply-strings/
public class String_ib_multiply_two_strings {
    public String multiply(String a, String b) {
        a = getNumber(a);
        b = getNumber(b);
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return "0";
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < lenA; ++i) {
            int num = a.charAt(lenA - i - 1) - '0';
            int carry = 0;

            int j;
            for (j = 0; j < lenB; ++j) {
                int digit = (b.charAt(lenB - j - 1) - '0') * num + carry;
                int pos =  j + i;
                if (result.size() == pos) {
                    result.add(0, digit % 10);
                } else {
                    pos = result.size() - 1 - pos ;
                    digit += result.get(pos);
                    result.set(pos, digit % 10);
                }
                carry = digit / 10;
            }

            while(carry > 0) {
                int pos = i + j;
                if (result.size() == pos) {
                    result.add(0, carry % 10);
                } else {
                    pos = result.size() - 1 - pos ;
                    carry += result.get(pos);
                    result.set(pos, carry % 10);
                }
                carry = carry / 10;
                ++j;
            }
        }

        StringBuffer br=new StringBuffer();
        for (int i = 0 ; i < result.size(); ++i){
            br.append(result.get(i));
        }
        return br.toString();
    }

    public String getNumber(String s) {
        char[] ch = s.toCharArray();
        int i;
        for (i = 0; i<s.length(); ++i ) {
            if (ch[i]!='0') {
                break;
            }
        }
        return s.substring(i);
    }
}
