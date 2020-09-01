package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/find-permutation/
public class Array_ib_find_permutation {
    public ArrayList<Integer> findPerm(final String s, int n) {
        int arr[]=new int[n];
        for(int i=0;i<n;++i)
            arr[i]=i+1;
        int l=0,h=arr.length-1;
        ArrayList<Integer> list=new ArrayList<Integer> ();
        for(int i=0;i<s.length();++i){
            int ch=s.charAt(i);
            if(ch=='I')
                list.add(arr[l++]);
            else
                list.add(arr[h--]);
        }
        list.add(arr[l]);
        return list;
    }
}
