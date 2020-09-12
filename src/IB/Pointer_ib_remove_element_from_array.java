package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/remove-element-from-array/
public class Pointer_ib_remove_element_from_array {
    public int removeElement(ArrayList<Integer> a, int b){
        int i=0,j=0;
        for(;j<a.size();++j){
            if(a.get(j)!=b){
                a.set(i,a.get(j));
                ++i;
            }
        }

        return i;
    }
}