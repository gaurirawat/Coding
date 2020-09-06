package IB;
//https://www.interviewbit.com/problems/longest-common-prefix/
public class String_ib_longest_common_prefix {
    public String longestCommonPrefix(String[] a) {
        StringBuffer str=new StringBuffer(a.length);
        for(int i=0;i<a[0].length();++i){
            char ch=a[0].charAt(i);
            int j=0;
            for(;j<a.length;++j)
                if(i==a[j].length() || ch!=a[j].charAt(i))
                    break;
            if(j==a.length)
                str.append(ch+"");
            else break;
        }
        return str.toString();
    }
}
