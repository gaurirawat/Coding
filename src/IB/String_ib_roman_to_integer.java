package IB;

import java.util.HashMap;
//https://www.interviewbit.com/problems/roman-to-integer/
public class String_ib_roman_to_integer {
    public int romanToInt(String A) {
        HashMap<Character,Integer> map= new HashMap<Character,Integer> ();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char r[]=A.toCharArray();
        int d=0;
        for(int i=0;i<r.length;++i){
            if(i+1!=r.length && map.get(r[i])<map.get(r[i+1])){
                d+=map.get(r[i+1])-map.get(r[i]);
                ++i;
            }
            else
                d+=map.get(r[i]);
        }
        return d;

    }
}
