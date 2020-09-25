package IB;

import java.util.ArrayList;
//Pointer_ib_sort_by_color
public class Pointer_ib_sort_by_color {
    public void sortColors(ArrayList<Integer> a) {
        int i1=0,i2=a.size()-1;
        for(int i=0;i<=i2;++i){
            if(a.get(i)==0){
                int t=a.get(i1);
                a.set(i1,0);
                a.set(i,t);
                i1++;
            }
            else if(a.get(i)==2){
                int t=a.get(i2);
                a.set(i2,2);
                a.set(i,t);
                i2--;
                i--;
            }
        }
    }
}
