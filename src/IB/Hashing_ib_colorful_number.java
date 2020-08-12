package IB;

import java.util.HashSet;

//https://www.interviewbit.com/problems/colorful-number/
public class Hashing_ib_colorful_number {
    public int colorful(int a) {
        HashSet<Integer> set=new HashSet<Integer>();
        char ch[]=(a+"").toCharArray();
        for(int i=0;i<ch.length;++i){
            int prod=1;
            for(int j=i;j<ch.length;++j){
                prod*=Integer.parseInt(ch[j]+"");
                if(set.contains(prod))
                    return 0;
                set.add(prod);
            }
        }
        return 1;
    }
}
