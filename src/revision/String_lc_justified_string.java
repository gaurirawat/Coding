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

/*

better understandable version.
public List<String> fullJustify(String[] words, int maxWidth) {
    ArrayList<String> answer = new ArrayList<String> ();

    int i = 0;
    outer: while (i < words.length) {
        int space = 0;
        int wordLen = words[i].length();
        int c = 1;
        if (i + c == words.length) {
            break outer;
        }
        int newLen = space + wordLen + words[i + c].length() + 1;
        while (newLen <= maxWidth ) {
            space++;
            wordLen += words[i + c].length();
            if (i + c + 1 == words.length) {
                break outer;
            }
            newLen = space + wordLen + words[i + c + 1].length() + 1;
            c++;
        }

        // System.out.println(i);
        int rem = maxWidth - wordLen;
        int equalSpace = c == 1 ? rem : rem / (c - 1);
        int extra = rem - equalSpace * (c - 1);

        StringBuffer sb = new StringBuffer(words[i]);
        if (c == 1) {
            for (int j = 0; j < rem; ++j) {
                sb.append(" ");
            }
        } else {
            for (int j = i + 1; j < i + c; ++j) {
                //append spaces;
                int currSpace = equalSpace + (extra > 0 ? 1 : 0);
                for (int k = 0; k < currSpace; ++k) {
                    sb.append(" ");
                }
                --extra;
                sb.append(words[j]);
            }
        }

        answer.add(sb.toString());
        i += c;
    }

    StringBuffer sb = new StringBuffer(words[i++]);
    for (; i < words.length; ++i) {
        sb.append(" " + words[i] );
    }
    while (sb.length() < maxWidth) {
        sb.append(" ");
    }
    answer.add(sb.toString());

    return answer;

}
 */
