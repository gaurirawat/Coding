package revision;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Collections;

//https://leetcode.com/problems/repeated-string-match/submissions/
public class String_lc_repeat_string_matching{
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int c=0;
        while(sb.length()<b.length()){
            sb.append(a);
            c++;
        }
        if(sb.indexOf(b)>=0) {
            return c;
        } else if(sb.append(a).indexOf(b)>=0) {
            return c+1;
        }
        return -1;
    }
}
