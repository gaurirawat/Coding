package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/pretty-json/
public class String_ib_pretty_json {
    public String[] prettyJSON(String s) {
        ArrayList<Integer> intd =  new ArrayList<Integer>();
        ArrayList<String> levels = new ArrayList<String>();

        int i=0;
        int c=0;
        int len=s.length();
        while(i<len){
            int j=i;
            while(j<len && !isBreakingCharacter(j, s)) {
                ++j;
            }
            if(i!=j ){
                intd.add(c);
                String temp= s.substring(i,j);
                i=j;
                temp= temp.trim();
                levels.add(temp);
            }
            else{
                if(s.charAt(j)==',') {
                    String prev=levels.get(levels.size()-1);
                    prev+=",";
                    levels.set(levels.size()-1, prev);
                }
                else if(s.charAt(j)=='{' || s.charAt(j)=='['){
                    levels.add(s.substring(i, j+1));
                    intd.add(c);
                    c++;
                }
                else {
                    levels.add(s.substring(i, j+1));
                    c--;
                    intd.add(c);
                }
                i=j+1;
            }
        }

        String[] answer= new String[intd.size()];
        for (i=0; i<intd.size(); ++i) {
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<intd.get(i); ++j) {
                sb.append("\t");
            }
            sb.append(levels.get(i));
            answer[i]=sb.toString();
        }
        return answer;
    }

    public boolean isBreakingCharacter(int j, String s) {
        char ch=s.charAt(j);
        if(ch==',' || ch== '{' || ch=='}' || ch== '['|| ch== ']' ){
            return true;
        }
        return false;
    }
}
