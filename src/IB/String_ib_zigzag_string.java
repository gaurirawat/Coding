package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/zigzag-string/
public class String_ib_zigzag_string {
    ArrayList<StringBuffer> list;
    public String convert(String s, int r) {
        if(r==1) return s;
        list=new ArrayList<StringBuffer>();
        for(int i=0;i<r;++i)
            list.add(new StringBuffer());
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i+=(2*r-2)){
            list.get(0).append(ch[i]);
            zigzag(i+1,i+(2*r-3),ch,1);
        }
        StringBuffer str=new StringBuffer();
        for(int i=0;i<r;++i)
            str.append(list.get(i));
        return str.toString();
    }

    public void zigzag(int l, int r, char[]ch, int row){
        if(l>r||l>=ch.length) return;
        list.get(row).append(ch[l]+"");
        if(l==r) return;
        if(r<ch.length)
            list.get(row).append(""+ch[r]);
        zigzag(l+1,r-1, ch,row+1);
        return;
    }
}
