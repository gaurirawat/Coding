package IB;

import java.util.*;
//https://www.interviewbit.com/problems/points-on-the-straight-line
public class Hashing_ib_points_on_a_line {
    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x==null||x.size()==0) return 0;
        int max=0;
        for(int i=0;i<x.size();++i){
            int ix=x.get(i);
            int iy=y.get(i);
            HashMap<Double,Integer> map=new HashMap<Double, Integer>();
            int same=0;
            int t=0;
            for(int j=0;j<x.size();++j){
                if(i==j) continue;
                int jx=x.get(j);
                int jy=y.get(j);
                double num=jy-iy;
                double den=jx-ix;
                double slope=0.0;
                if(den==0 && num==0) {
                    same++;
                    continue;
                }
                if(den==0.0)
                    slope=Double.MAX_VALUE;
                else
                    slope=num/den;
                if(map.get(slope)!=null){
                    int c=map.get(slope);
                    map.remove(new Double(slope));
                    map.put(slope,c+1);
                }
                else
                    map.put(slope,1);
                t=Math.max(map.get(slope),t);
            }
            max=Math.max(t+same,max);
            // for(Map.Entry<Double,Integer> p:map.entrySet())
            //    System.out.println(p.getKey()+" "+p.getValue());
        }
        return max+1;
    }

}
