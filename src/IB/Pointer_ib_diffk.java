
package IB;

import java.util.*;

//https://www.interviewbit.com/problems/diffk/
public class Pointer_ib_diffk {
    public int diffPossible(ArrayList<Integer> l, int k) {
        for(int i=0;i<l.size();++i){
            int a=Collections.binarySearch(l,l.get(i)-k);
            int b=Collections.binarySearch(l,l.get(i)+k);
            if(a>=0&& a!=i||(b>=0 && b!=i)){
                // System.out.println(l.get(i)+" "+a+" "+b);
                return 1;
            }
        }
        return 0;
    }
}
