package IB;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/dungeon-princess/

public class DP_ib_dungeon_princess {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
        int r=a.size();
        int c=a.get(0).size();
        for(int i=r-1;i>=0;--i){
            for(int j=c-1;j>=0;--j){
                if(i==r-1 && j==c-1) {
                    if(a.get(i).get(j)>=0)
                        a.get(i).set(j,1);
                    else
                        a.get(i).set(j,Math.abs(a.get(i).get(j))+1);
                    continue;
                }
                int bottom= i==r-1? Integer.MAX_VALUE :a.get(i+1).get(j);
                int right= j==c-1? Integer.MAX_VALUE :a.get(i).get(j+1);
                int min= Math.min(bottom,right);
                int val= a.get(i).get(j)>=min? 1: min-a.get(i).get(j);
                a.get(i).set(j,val);
            }
        }
        return a.get(0).get(0);
    }
}
