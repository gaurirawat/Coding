package revision;
//https://leetcode.com/problems/rearrange-spaces-between-words/submissions/
public class String_lc_rearrange_spaces {
    /*
    This soln is accurate by a tiny bit slow since steaming is happening.
        public String reorderSpaces(String text) {
            String s[]=text.trim().split("\\s+");
            int c= text.chars().map(ch->ch==' '?1:0).sum();
            int rep=s.length<=1?0:c/(s.length-1);
            int end=s.length<=1?c:c%(s.length-1);
            return String.join(" ".repeat(rep),s)+" ".repeat(end);
        }
     The complete one is faster but lengthy in code.
     */

    public String reorderSpaces(String text) {
        int c=0;
        int k=0;
        String arr[]=new String[text.length()];
        for(int i=0;i<text.length();++i){
            if(text.charAt(i)==' ')
                c++;
            else{
                int l=i;
                while(i<text.length()&&text.charAt(i)!=' ')++i;
                arr[k++]=text.substring(l,i);
                if(i<text.length())
                    ++c;
            }
        }
        if(c==0)
            return text;
        k--;
        if(k==0){
            StringBuffer sb=new StringBuffer();
            sb.append(arr[k]);
            for(int i=0;i<c;++i)
                sb.append(" ");
            return sb.toString();
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<k;++i){
            sb.append(arr[i]);
            for(int j=0;j<c/k;++j)
                sb.append(" ");
        }
        sb.append(arr[k]);
        if(c/(k)!=c*1.0/k){
            int x=c%k;
            for(int j=0;j<x;++j)
                sb.append(" ");
        }
        return sb.toString();
    }
}