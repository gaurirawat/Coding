package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/rearrange-array/
public class Math_ib_arrange_array {
    public void arrange(ArrayList<Integer> a) {
        int k=a.size();
        for(int i=0;i<a.size();++i){
            int ioth=a.get(i)%k;
            a.set(i, k*(a.get(ioth)%k)+ioth);
        }

        for(int i=0;i<a.size();++i){
            a.set(i, a.get(i)/k);
        }
    }
}
