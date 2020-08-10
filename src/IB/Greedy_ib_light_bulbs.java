package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/bulbs/
public class Greedy_ib_light_bulbs {
    public int bulbs(ArrayList<Integer> a) {
        boolean toggle=false;
        int c=0;
        for(int x:a){
            if((x==1 && !toggle)||(x==0 && toggle))
                continue;
            else{
                toggle=!toggle;
                c++;
            }
        }
        return c;
    }
}
