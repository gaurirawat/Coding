package IB;

import java.util.*;
//https://www.interviewbit.com/problems/word-break-ii/
public class DP_ib_word_break_2 {
    ArrayList<String> resList;
    public ArrayList<String> wordBreak(String s, ArrayList<String> slist) {
        Set<String> set=new HashSet<String>(slist);
        slist.clear();
        for(String setString:set)
            slist.add(setString);
        Collections.sort(slist);
        HashMap<Character,ArrayList<String>> map=new HashMap<Character,ArrayList<String>>();
        for(String x:slist){
            if(map.get(x.charAt(0))==null){
                ArrayList<String> l=new ArrayList<String>();
                l.add(x);
                map.put(x.charAt(0),l);
            }
            else{
                map.get(x.charAt(0)).add(x);
            }
        }
        resList=new ArrayList<String>();
        generateStringDP(0,s,"",map);
        return resList;
    }

    public void generateStringDP(int i, String s, String res, HashMap<Character,ArrayList<String>> map){
        if(i==s.length()){
            resList.add(res);
            return;
        }
        if(map.get(s.charAt(i))==null) return;
        ArrayList<String> list=map.get(s.charAt(i));
        for(String word:list){
            int len=word.length();
            if(len+i<=s.length() && word.equals(s.substring(i,len+i)))
                generateStringDP(len+i,s,res.equals("")?word:res+" "+word,map);
        }
    }
}
