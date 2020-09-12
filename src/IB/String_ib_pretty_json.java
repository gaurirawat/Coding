package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/pretty-json/
public class String_ib_pretty_json {
    public ArrayList<String> prettyJSON(String s) {
        ArrayList<String> ans=new ArrayList<String>();
        int tab=0;
        int l=0,r=0;
        for(r=0;r<s.length();++r){
            char ch=s.charAt(r);
            if(ch=='{'||ch=='['||ch==','||ch=='}'||ch==']'){
                if(l!=r){
                    String ss=s.substring(l,r);
                    for(int i=0;i<tab;++i)
                        ss='\t'+ss;
                    if(ch==',')
                        ss+=',';
                    ans.add(ss);
                }
                l=r+1;
            }
            if(ch=='{'||ch=='['||ch=='}'||ch==']'){
                if(ch=='}'||ch==']')
                    --tab;
                String ss="";
                for(int i=0;i<tab;++i)
                    ss='\t'+ss;
                ss+=ch;
                if((ch=='}'||ch==']')&&r+1<s.length()&&s.charAt(r+1)==','){
                    ss+=',';
                    r++;
                    l=r+1;
                }
                ans.add(ss);
                if(ch=='{'||ch=='[')
                    ++tab;
            }
        }
        // System.out.println(ans.size());
        return ans;
    }
}
