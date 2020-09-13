package IB;
//https://www.interviewbit.com/problems/count-and-say/
public class String_ib_count_and_say {
    public String countAndSay(int n) {
        if(n==0)return "0";
        if(n==1)return "1";
        StringBuffer s=new StringBuffer("1");
        for(int i=2;i<=n;++i){
            StringBuffer t=new StringBuffer();
            for(int j=0;j<s.length();++j){
                char ch=s.charAt(j);
                int c=1;
                while(j+1<s.length()&&s.charAt(j+1)==ch){
                    c++;
                    j++;
                }
                t.append(c);
                t.append(ch);
            }
            s=t;
        }
        return s.toString();
    }
}
