package IB;

import java.util.*;

//https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/
public class DP_ib_largest_area_of_permutation_rectangle {
    public int solve(ArrayList<ArrayList<Integer>> a) {
        for(int i=1;i<a.size();++i){
            for(int j=0;j<a.get(0).size();++j)
            {
                if(a.get(i).get(j)!=0)
                    a.get(i).set(j,a.get(i).get(j)+a.get(i-1).get(j));
            }
        }
        int mx=0;
        for(int i=0;i<a.size();++i)
            mx=Math.max(mx, maxAreaHistogram(a.get(i)));
        return mx;
    }

    public int maxAreaHistogram(ArrayList<Integer> l){
        Collections.sort(l);
        int nsl[]=new int[l.size()];
        int nsr[]=new int[l.size()];
        Deque<Integer> st=new LinkedList<Integer>();    //contains indexes and not the actual elements

        for(int i=0;i<l.size();++i){
            while(st.size()!=0 && l.get(st.peekFirst())>=l.get(i))
                st.pollFirst();
            if(st.size()==0)
                nsl[i]=-1;
            else
                nsl[i]=st.peekFirst();
            st.addFirst(i);
        }

        st.clear();
        for(int i=l.size()-1;i>=0;--i){
            while(st.size()!=0 && l.get(st.peekFirst())>=l.get(i))
                st.pollFirst();
            if(st.size()==0)
                nsr[i]=l.size();
            else
                nsr[i]=st.peekFirst();
            st.addFirst(i);
        }

        int mx=0;
        for(int i=0;i<l.size();++i)
            mx=Math.max(mx, l.get(i)*(nsr[i]-nsl[i]-1));
        return mx;
    }
}
