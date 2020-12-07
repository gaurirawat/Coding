package revision;

import java.util.Arrays;
//https://leetcode.com/problems/plus-one/
public class Array_lc_plus_one {
    public int[] plusOne(int[] digits) {
        int carry=1;
        int i=digits.length-1;
        while (carry!=0 && i!=-1) {
            int dig=digits[i];
            digits[i]=(dig+carry)%10;
            carry=(dig+carry)/10;
            i--;
        }
        if(carry==1) {
            int[] ans= new int[digits.length+1];
            ans[0]=1;
            for(i=1;i<ans.length;++i) {
                ans[i]=digits[i-1];
            }
            return ans;
        }
        return digits;
    }
}
