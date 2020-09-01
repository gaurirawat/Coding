package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/flip/
public class Array_ib_flip {
    public ArrayList<Integer> flip(String a) {
        char ch[]=a.toCharArray();
        int arr[]=new int[ch.length];
        for(int i=0;i<ch.length;++i)
            arr[i]=ch[i]=='0'?1:-1;
        int currSum=0, currL=0;
        int maxSum=0, maxL=0,maxR=0;
        for(int i=0;i<arr.length;++i){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
                currL=i+1;
            }
            if(currSum>maxSum){
                maxSum=currSum;
                maxL=currL;
                maxR=i;
            }
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(maxSum==0)
            return l;
        else{
            l.add(maxL+1);
            l.add(maxR+1);
            return l;
        }
    }
}
