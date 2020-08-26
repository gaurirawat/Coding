package IB;

import java.util.*;

//https://www.interviewbit.com/problems/stepping-numbers/
public class Graph_ib_stepping_number {
        HashSet<Integer> set;
        public ArrayList<Integer> stepnum(int a, int b) {
            set=new HashSet<Integer>();
            int d=(Math.max(a,b)+"").length();
            for(int i=0;i<=9;++i)
                stepNumInner(a,b,i, 1, d);
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.addAll(set);
            Collections.sort(l);
            return l;
        }

        public void stepNumInner(int a, int b, int x, int xd, int maxd){
            if(x>=a&&x<=b)
                set.add(x);
            if(xd>maxd) return;
            if(xd*Math.pow(10,(maxd-xd))>b) return;
            int lastDig=x%10;
            if(lastDig!=9) stepNumInner(a,b,x*10+(lastDig+1),xd+1,maxd);
            if(lastDig!=0) stepNumInner(a,b,x*10+(lastDig-1),xd+1,maxd);
        }
}
