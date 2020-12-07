package revision;

import java.util.*;

public class String_lc_justified_string {
    public List<String> fullJustify(String[] w, int maxW) {
        List<String> l=new ArrayList<String>();
        int i=0;

        outer: while(i<w.length) {
            StringBuilder sb=new StringBuilder();
            sb.append(w[i]);
            int wlen=w[i].length();
            int c=0;
            while(wlen+c<=maxW){
                ++c;
                if(c+i==w.length)
                    break outer;
                wlen+=w[c+i].length();
            }
            int tot=wlen+c;
            if(c==1) {
                for(int j=w[i].length();j<maxW;++j){
                    sb.append(" ");
                }
                l.add(sb.toString());
                i=i+1;
                continue;
            }
            wlen-=w[i+c].length();
            c--;
            int space=(maxW-wlen)/c;
            int extra=(maxW-wlen)%c;
            for(int j=1;j<=c;++j) {
                for(int k=0;k<(space+(extra>=1?1:0));++k) {
                    sb.append(" ");
                }
                extra=extra>0?extra-1:0;
                sb.append(w[i+j]);
            }
            l.add(sb.toString());
            i=i+c+1;
        }
        StringBuilder sb=new StringBuilder(w[i++]);
        for(;i<w.length;++i) {
            sb.append(" "+w[i]);
        }
        for(int j=sb.length();j<maxW;++j){
            sb.append(" ");
        }
        l.add(sb.toString());
        return l;
    }
}
