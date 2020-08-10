package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/letter-phone/
public class Backtracking_ib_letter_phone {
    ArrayList<String> l;
    ArrayList<String> ans;
    public ArrayList<String> letterCombinations(String a) {
        l=new ArrayList<String>(10);
        ans=new ArrayList<String>();
        if(a==null||a.length()==0)return ans;
        l.add("0");
        l.add("1");
        l.add("abc");
        l.add("def");
        l.add("ghi");
        l.add("jkl");
        l.add("mno");
        l.add("pqrs");
        l.add("tuv");
        l.add("wxyz");
        letterCombInner(0,a,"");
        return ans;
    }

    public void letterCombInner(int i, String a, String sb){
        if(i==a.length()){
            ans.add(sb);
            return;
        }
        String s=l.get(Integer.parseInt(a.charAt(i)+""));
        for(int j=0;j<s.length();++j)
            letterCombInner(i+1,a,sb+s.charAt(j));
    }

}
