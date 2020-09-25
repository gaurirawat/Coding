package IB;

//https://www.interviewbit.com/problems/justified-text/
import java.util.*;
public class String_ib_justified_text {
    public ArrayList<String> fullJustify(ArrayList<String> a, int k) {
        int c=0;
        int i=0;
        ArrayList<String> ans= new ArrayList<String>();
        outer:for(;i<a.size();++i){
            c=0;
            int len=a.get(i).length();
            while(len+c<=k){
                c++;
                if(c+i==a.size())
                    break outer;
                len+=a.get(c+i).length();
            }
            StringBuffer br= new StringBuffer();
            if(c==1){
                br.append(a.get(i));
                for(int j=0;j+a.get(i).length()<k;++j)
                    br.append(" ");
            }
            else{
                len-=a.get(c+i).length();
                c--;
                int spaces=k-len;
                int gap=spaces/c==0?1:spaces/c;
                int extra=spaces%c;
                int even=extra==0?0:1;
                // System.out.println(c+" "+spaces+" "+gap+" "+extra+" "+even+" "+len);
                int tc=1;
                int j=i;
                br.append(a.get(i));
                for(j=i+1;j<=i+c;++j){
                    for(int m=1;m<=gap+even;++m)
                        br.append(" ");
                    br.append(a.get(j));
                    even=Math.min(even, extra-(even*tc));
                    tc++;
                }
                if(br.toString().charAt(br.length()-1)==' ')
                    br=br.delete(br.length()-1,br.length());
                i+=c;
            }
            ans.add(br.toString());
        }
        StringBuffer br=new StringBuffer();
        for(;i<a.size();++i)
            br.append(a.get(i)+" ");
        while(br.length()!=0 && br.length()<=k) br.append(" ");
        if (br.length()!=0)
            ans.add(br.toString().substring(0,br.length()-1));
        // ans.add(br.toString().substring(0,br.length()-1))
        return ans;
    }
}
