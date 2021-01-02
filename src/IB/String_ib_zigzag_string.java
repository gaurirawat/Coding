package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/zigzag-string/
public class String_ib_zigzag_string {
    public String convert(String s, int k) {
        StringBuilder[] rows=new StringBuilder[k];
        for(int i=0; i<k; ++i) {
            rows[i]= new StringBuilder();
        }
        int i=0;
        while(i<s.length()) {
            int j=0;
            while(j<k && i<s.length()){
                rows[j].append(s.charAt(i)+"");
                ++j;++i;
            }
            j=k-2;
            while(j>0 && i<s.length()) {
                rows[j].append(s.charAt(i)+"");
                --j;++i;
            }
        }
        return String.join("", rows);
    }
}
