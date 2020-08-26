package IB;

import java.util.*;

//https://www.interviewbit.com/problems/maxspprod/
public class Stack_ib_max_stack_product {
    public int maxSpecialProduct(int[] arr) {
        int ngl[]=new int[arr.length];
        int ngr[]=new int[arr.length];
        Deque<Integer> st=new LinkedList<Integer>();

        for(int i=1;i<arr.length;++i){
            while(!st.isEmpty() && arr[st.peekLast()]<=arr[i])
                st.pollLast();
            if(st.peekLast()!=null)
                ngl[i]=st.peekLast();
            st.addLast(i);
        }

        st.clear();
        for(int i=arr.length-1;i>=0;--i){
            while(!st.isEmpty() && arr[st.peekLast()]<=arr[i])
                st.pollLast();
            if(st.peekLast()!=null)
                ngr[i]=st.peekLast();
            st.addLast(i);
        }
        // System.out.println(Arrays.toString(ngl));
        // System.out.println(Arrays.toString(ngr));
        long max=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<arr.length;++i)
            max=Math.max(max, ngl[i]*1l*ngr[i]);
        return (int)(max%mod);
    }
}
