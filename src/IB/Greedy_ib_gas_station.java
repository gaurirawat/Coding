package IB;

import java.util.List;

//https://www.interviewbit.com/problems/gas-station/
public class Greedy_ib_gas_station {
    public int canCompleteCircuit(final List<Integer> a, final List<Integer> b) {
        int tot=0;
        int st=0;
        int curr=0;
        for(int i=0;i<a.size();++i){
            int diff=a.get(i)-b.get(i);
            if(curr>=0){
                curr+=diff;
            }
            else{
                curr=diff;
                st=i;
            }
            tot+=diff;
        }
        return tot>=0?st:-1;
    }
}
