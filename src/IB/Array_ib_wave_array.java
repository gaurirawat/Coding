package IB;

import java.math.BigInteger;
import java.util.*;

//https://www.interviewbit.com/problems/wave-array/
public class Array_ib_wave_array {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for(int i=0;i+1<a.size();i+=2){
            int t=a.get(i);
            a.set(i,a.get(i+1));
            a.set(i+1,t);
        }
        return a;
    }

}
