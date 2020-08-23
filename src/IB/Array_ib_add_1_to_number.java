package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/add-one-to-number/
public class Array_ib_add_1_to_number {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        while(a.size()!=0 && a.get(0)==0)
            a.remove(0);
        int carry=1;
        for(int i=a.size()-1;i>=0;--i){
            if(carry==0)
                break;
            int e=a.get(i)+carry;
            carry=e/10;
            e=e%10;
            a.set(i,e);
        }
        if(carry==1)
            a.add(0,1);
        return a;
    }
}
