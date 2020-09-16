package IB;

import java.util.*;

//https://www.interviewbit.com/problems/substring-concatenation/
public class Hashing_ib_substring_concatenation {
    int tot;
    public ArrayList<Integer> findSubstring(String word, final List<String> sl) {
        tot=sl.size();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        HashMap<Character, ArrayList<Integer>> map=new HashMap<Character, ArrayList<Integer>>();
        for(int i=0;i<sl.size();++i){
            String s=sl.get(i);
            ArrayList<Integer> l= map.getOrDefault(s.charAt(0),new ArrayList<Integer>());
            l.add(i);
            map.put(s.charAt(0),l);
        }
        for(int i=0;i<word.length();++i)
            if(findSubstringInner(i,0, word, sl, map, new boolean[sl.size()]))
                ans.add(i);
        return ans;
    }

    public boolean findSubstringInner(int i, int count, String word, List<String> sl, HashMap<Character, ArrayList<Integer>> map, boolean found[]){
        if(count==tot) return true;
        if(i>=word.length()) return false;
        char ch=word.charAt(i);
        for(Integer index:map.getOrDefault(ch,new ArrayList<Integer>())){
            String s=sl.get(index);
            if(!found[index] && i+s.length()<=word.length() && s.equals(word.substring(i,i+s.length()))){
                found[index]=true;
                if(findSubstringInner(i+s.length(),count+1,word,sl,map,found))
                    return true;
                found[index]=false;
            }
        }
        return false;
    }
}