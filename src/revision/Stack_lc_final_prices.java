package revision;

import java.util.*;

public class Stack_lc_final_prices {
    public int[] finalPrices(int[] p) {
        int res[]=new int[p.length];
        Deque<Integer> st=new LinkedList<Integer>();
        st.add(p[p.length-1]);
        res[p.length-1]=p[p.length-1];

        for(int i=p.length-2;i>=0;--i){
            while(st.size()!=0 && st.peekFirst()>p[i])
                st.pollFirst();
            if(st.size()==0)
                res[i]=p[i];
            else
                res[i]=p[i]-st.peekFirst();
            st.addFirst(p[i]);
        }
        return res;
    }
}
