package revision;

import java.util.Arrays;

//https://www.interviewbit.com/problems/assign-mice-to-holes/
public class Greedy_ib_assign_mice_to_holes {
    public int mice(int[] m, int[] h) {
        if(m==null||h==null|| m.length==0|| h.length==0) return 0;
        Arrays.sort(m);
        Arrays.sort(h);
        int max=0;
        for(int i=0;i<m.length;++i){
            max=Math.max(max, Math.abs(m[i]-h[i]));
        }
        return max;
    }

}
