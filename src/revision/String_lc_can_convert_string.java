package revision;

import java.util.HashMap;

//https://leetcode.com/problems/can-convert-string-in-k-moves/submissions/
public class String_lc_can_convert_string {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length()) return false;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==t.charAt(i))
                continue;
            else{
                int x=t.charAt(i)-s.charAt(i);
                if(x<0)
                    x=26+x;
                int prevC=map.getOrDefault(x,0);
                map.put(x,prevC+1);
                if(26*prevC+x>k) return false;
            }
        }
        return true;
    }
}
