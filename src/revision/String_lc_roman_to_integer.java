package revision;

import java.util.HashMap;

//https://leetcode.com/problems/roman-to-integer/submissions/
public class String_lc_roman_to_integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char ch[] = s.toCharArray();
        int number = 0;
        for (int i = ch.length - 1; i >= 0; --i) {
            if (i != 0 && map.get(ch[i-1]) < map.get(ch[i])) {
                number += map.get(ch[i]) - map.get(ch[i-1]);
                --i;
            }
            else {
                number += map.get(ch[i]);
            }
        }
        return number;
    }
}