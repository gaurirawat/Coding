package revision;
//https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
public class Array_lc_max_profit_of_operating_a_centennial_wheel {
    public int minOperationsMaxProfit(int[] cus, int bc, int rc) {
        int tnum=0;
        int snum=0;
        int maxC=0,maxR=-1;
        int i=0;
        for(;i<cus.length;++i){
            tnum+=cus[i];
            int curr=tnum>3?4:tnum;
            tnum-=curr;
            snum+=curr;
            long cost=snum*1*bc-((i+1)*rc);
            // System.out.println(cost);
            if(cost>maxC){
                maxC=(int)cost;
                maxR=i+1;
            }
        }
        while(tnum!=0){
            int curr=tnum>3?4:tnum;
            tnum-=curr;
            snum+=curr;
            long cost=snum*1*bc-((i+1)*rc);
            // System.out.println(cost);
            if(cost>maxC){
                maxC=(int)cost;
                maxR=i+1;
            }
            i++;
        }
        return maxR;
    }

}
