package IB;

import java.util.*;

public class Hashing_ib_max_points_on_a_line {
    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        int max=0;
        for(int i=0;i<x.size();++i){
            int ix=x.get(i);
            int iy=y.get(i);
            HashMap<Double,Integer> map=new HashMap<Double, Integer>();
            for(int j=0;j<x.size();++j){
                if(i==j) continue;
                int jx=x.get(j);
                int jy=y.get(j);
                double num=jy-iy;
                double den=jx-ix;
                double slope=0.0;
                if(den==0.0)
                    slope=Double.MAX_VALUE;
                else
                    slope=num/den;
                if(map.get(slope)!=null)
                    map.replace(slope, map.get(slope)+1);
                else
                    map.put(slope,1);
                max=Math.max(map.get(slope),max);
            }
        }
        return max;
    }
}
