package revision;

import java.util.*;
//https://leetcode.com/problems/guess-the-word/discuss/766231/Very-Elegant-solution-beating-95-and-thorough-explaination
//https://leetcode.com/problems/guess-the-word/discuss/556075/How-to-explain-to-interviewer-843.-Guess-the-Word
//https://leetcode.com/problems/guess-the-word/submissions/
public class String_lc_guess_the_word {
    public void findSecretWord(String[] words, Master master) {
        ArrayList<String> l= new ArrayList<String>();
        for (String s:words) {
            l.add(s);
        }
        Random random=new Random();
        for(int itr=0;itr<10;++itr){
            int i=random.nextInt(l.size());
            int matching=master.guess(l.get(i));
            if(i==6) {
                break;
            }
            ArrayList<String> newl=new ArrayList<String>();
            for(int j=0;j<l.size();++j) {
                if(isMatchSame(matching,l.get(i), l.get(j))){
                    newl.add(l.get(j));
                }
            }
            l=newl;
        }
    }

    public boolean isMatchSame(int matching, String a, String b) {
        int c=0;
        for(int i=0;i<6;++i) {
            if (a.charAt(i)==b.charAt(i)){
                ++c;
            }
        }
        if(c==matching) {
            return true;
        }
        return false;
    }
    interface Master {
        public int guess(String word);
    }
}
