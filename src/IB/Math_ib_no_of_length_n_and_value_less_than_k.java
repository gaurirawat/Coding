package IB;

import java.util.*;

//https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
public class Math_ib_no_of_length_n_and_value_less_than_k {
    public int solve(ArrayList<Integer> a, int dig, int k) {
        if(a.size()==0 || k==0) return 0;
        char krr[]=(k+"").toCharArray();
        if(krr.length<dig)
            return 0;
        if(krr.length>dig)
            return ((a.contains(0)&&dig!=1)?a.size()-1:a.size())*(int)Math.pow(a.size(),dig-1);

        Collections.sort(a);
        int c=0;
        for(int i=0;i<krr.length;++i){
            int noOfSmElem=Collections.binarySearch(a, Integer.parseInt(krr[i]+""));
            if(noOfSmElem<0)
                noOfSmElem=Math.abs(noOfSmElem+1);

            if(i==0 && a.contains(0) && dig!=1)
                c+= (noOfSmElem-1)*Math.pow(a.size(),dig-i-1);
            else
                c+= noOfSmElem*Math.pow(a.size(),dig-i-1);
            if(noOfSmElem==a.size()||a.get(noOfSmElem)!=Integer.parseInt(krr[i]+""))
                break;
        }
        return c;
    }
}

/*
Above solution is nlogn.
DP solution. This one is n^k solution where n=a.length.
public int solve(int[] a, int dig, int k) {
        if(a.length==0 || k==0) return 0;
        Arrays.sort(a);
        int c=0;
        for(int i=0;i<a.length;++i)
            if(a[i]!=0|| dig==1)
                c+=combinations(a[i],dig-1,k,a);
        return c;
    }
    public int combinations(int num ,int dig, int k, int []a){
        if(dig==0 && num<k) return 1;
        if(dig==0 || num*Math.pow(10,dig)>k) return 0;
        int c=0;
        for(int i=0;i<a.length;++i)
            c+=combinations(num*10+a[i],dig-1,k,a);
        return c;
    }
 */